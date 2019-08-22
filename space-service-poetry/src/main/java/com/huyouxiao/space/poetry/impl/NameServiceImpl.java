package com.huyouxiao.space.poetry.impl;

import com.github.pagehelper.PageHelper;
import com.huyouxiao.space.common.utils.DateUtils;
import com.huyouxiao.space.common.utils.FileUtils;
import com.huyouxiao.space.common.utils.JsonUtils;
import com.huyouxiao.space.dao.entity.NamePoolEntity;
import com.huyouxiao.space.dao.entity.PoetryEntity;
import com.huyouxiao.space.dao.entity.PoetryIndexEntity;
import com.huyouxiao.space.dao.entity.WordEntity;
import com.huyouxiao.space.dao.mapper.NamePoolEntityMapper;
import com.huyouxiao.space.dao.mapper.PoetryEntityMapper;
import com.huyouxiao.space.dao.mapper.PoetryIndexEntityMapper;
import com.huyouxiao.space.dao.mapper.WordEntityMapper;
import com.huyouxiao.space.poetry.FileService;
import com.huyouxiao.space.poetry.NameService;
import com.huyouxiao.space.poetry.bean.Name;
import com.huyouxiao.space.poetry.bean.Poetry;
import com.huyouxiao.space.poetry.bean.request.GenerateNameRequest;
import com.huyouxiao.space.poetry.bean.response.GenerateNameResponse;
import com.huyouxiao.space.poetry.bean.response.NameInstance;
import com.huyouxiao.space.zhouyi.FortuneService;
import com.huyouxiao.space.zhouyi.bean.Word;
import com.huyouxiao.space.zhouyi.bean.response.NameScoreResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;

@Service
@Slf4j
public class NameServiceImpl implements NameService {
  public static final int BATCH_INSERT_SIZE = 1000;

  @Autowired
  private NamePoolEntityMapper namePoolEntityMapper;

  @Autowired
  private FortuneService fortuneService;

  @Autowired
  private WordEntityMapper wordEntityMapper;

  @Autowired
  private PoetryIndexEntityMapper poetryIndexEntityMapper;

  @Autowired
  private PoetryEntityMapper poetryEntityMapper;

  @Autowired
  private FileService  fileService;


  @Override
  public GenerateNameResponse generateName(GenerateNameRequest request) {
    GenerateNameResponse response = new GenerateNameResponse();

    Date birthday = request.getBirthday();

    response.setBaZhi(fortuneService.getCharacter(birthday));

    Integer frequencyStart = null;
    Integer frequencyEnd = null;
    if(null != request.getFrequencyLevel()) {
      frequencyStart = request.getFrequencyLevel().getStart();
      frequencyEnd = request.getFrequencyLevel().getEnd();
    }

    Integer count = namePoolEntityMapper.selectNamesCount(request.getPinyinAbridge(), request.getNameLength(),request.getWantField(),frequencyStart, frequencyEnd);
    Integer pageCount = count.intValue() / request.getPageSize() + 1;
    response.setTotal(count);

    if (request.isPaged()) {
      PageHelper.startPage(request.getPageNo(), request.getPageSize());
      response.setPageNo(request.getPageNo());
      response.setPageSize(pageCount);
    }

    List<NamePoolEntity> entities = namePoolEntityMapper.selectNames(request.getPinyinAbridge(), request.getNameLength(),request.getWantField(),frequencyStart, frequencyEnd);

    // generate name by poetry.
    List<Name> poetryNames = queryNameFromPoetry(request.getFamilyName(), request.getPinyinAbridge(),request.getWantField());


    // NOTICE: just comment it
    for (Name name : poetryNames) {
      processScore(name);
    }

    List<Name> names = new ArrayList<>(entities.size() + poetryNames.size());

    names.addAll(poetryNames);

    if(null != entities) {
      for(NamePoolEntity item : entities) {
        Name name = Name.get(request.getFamilyName(),item);
        names.add(name);
        processScore(name);
      }
    }

    response.setNames(names);

    fileService.generateNamePdf(response);

    return response;
  }

  private void processScore(Name name) {
    NameScoreResponse score = fortuneService.getNameScore(name.getChineseName());
    name.setScore(score.getScore());
    name.setNameScore(score);
    name.setNamePinyin(score.getFamilyNamePinYin().toUpperCase() + " " + name.getNamePinyin());
    name.setDetail(score.getPerson().getDescription());

    // query name's word means.
    name.setWords(queryWords(name.getChineseName()));
  }

  @Override
  public  Map<String, NameInstance> statisticsName(File file) {
    // read file to lines
    List<String> names = FileUtils.readFileLines(file);

    Map<String, NameInstance> caches = new HashMap<>();

    for(String name : names) {
      name = name.replace("\r\n","");
      String familyName;
      String restName;
      if(StringUtils.isEmpty(name) || name.length() == 1) {
        log.info("name is invalid:{}, skip it.", name);
        continue;
      }else if(name.startsWith("欧阳")) {
        familyName = name.substring(0,2);
        restName = name.substring(2);
      } else  {
        //split first family name and rest name.
        familyName = name.substring(0, 1);
        restName = name.substring(1);
      }

      if(StringUtils.isEmpty(restName)) {
        log.info("restName is empty, skip:{}", name);
        continue;
      }
      NameInstance instance = caches.get(restName);
      if(null == instance) {
        instance = new NameInstance();
        instance.setFamilyNames(new LinkedList<>());
        instance.addFamilyName(familyName);
        instance.setName(restName);
        for(int i=0; i<restName.length(); i++) {
          instance.setWord(i+1, String.valueOf(restName.charAt(i)));
        }
        caches.put(restName, instance);
      } else {
        instance.addFamilyName(familyName);
        instance.addFrequency();
      }

    }
    return caches;
  }

  @Override
  public void storeInDb(Map<String, NameInstance> words) {
    Iterator iterator = words.entrySet().iterator();
    List<NamePoolEntity> wordsEntities = new ArrayList<>(words.size());
    while(iterator.hasNext()) {
      Map.Entry item = (Map.Entry) iterator.next();
      NameInstance name = (NameInstance)item.getValue();
      wordsEntities.add(name.toEntity());
    }

    // group list by size, batch insert.
    int fromIndex = 0;
    while(fromIndex + BATCH_INSERT_SIZE <= wordsEntities.size()) {
      int toIndex = fromIndex + BATCH_INSERT_SIZE;
      namePoolEntityMapper.batchInsert(wordsEntities.subList(fromIndex, toIndex));
      fromIndex = toIndex;
    }

    // insert rest of  exist.
    if(wordsEntities.size()-fromIndex > 0) {
      namePoolEntityMapper.batchInsert(wordsEntities.subList(fromIndex, wordsEntities.size()));
    }
  }

  @Override
  public File downloadName(GenerateNameRequest request) {
    List<NamePoolEntity> entities = namePoolEntityMapper.selectNames(request.getPinyinAbridge(), request.getNameLength(),request.getWantField(), null, null);

    if(null == entities) {
      return new File("empty.txt");
    }

    StringBuffer stringBuffer = new StringBuffer();
    for(NamePoolEntity name : entities) {
      stringBuffer.append(request.getFamilyName()).append(name.getName()).append("\r\n");
    }
    return  FileUtils.writeFile("result.txt", stringBuffer.toString());
  }

  @Override
  public void listName() {
     //TODO: list names.
  }


  private List<Word> queryWords(String name) {
    List<Word> result = new ArrayList<>();
    char[] values = name.toCharArray();
    for (int i=1; i<values.length; i++) {
      String value = String.valueOf(values[i]);
      WordEntity wordEntity = wordEntityMapper.selectByWord(value, null);
      result.add(new Word(wordEntity));
    }
    return result;
  }

  private List<Name> queryNameFromPoetry(String familyName, String pinYin, String wantField) {
    List<Name> result = new ArrayList<>();

    List<PoetryIndexEntity> indexList = poetryIndexEntityMapper.selectByWordsLetter(pinYin, wantField);
    if (null == indexList) {
      return result;
    }

    for (PoetryIndexEntity index : indexList) {
      Name name = Name.get(familyName, index);
      List<Long> poetryIds = JsonUtils.toList(index.getPoetryIds(),Long.class);
      List<PoetryEntity> poetryEntities = poetryEntityMapper.selectByPoetryIds(poetryIds);
      List<Poetry> poetryList = new ArrayList<>(poetryEntities.size());
      for (PoetryEntity poetry : poetryEntities) {
         poetryList.add(new Poetry(poetry, index.getWords()));
      }
      name.setPoetry(poetryList);
      result.add(name);
    }

    return result;
  }


}































