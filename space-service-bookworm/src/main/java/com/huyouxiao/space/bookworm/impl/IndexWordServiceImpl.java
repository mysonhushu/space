package com.huyouxiao.space.bookworm.impl;

import com.huyouxiao.space.bookworm.IndexWordService;
import com.huyouxiao.space.common.utils.FileUtils;
import com.huyouxiao.space.common.utils.PinyinUtils;
import com.huyouxiao.space.dao.entity.PoetryIndexEntity;
import com.huyouxiao.space.dao.mapper.PoetryIndexEntityMapper;
import com.huyouxiao.space.model.bookworm.IndexWords;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class IndexWordServiceImpl implements IndexWordService {
  public static final int BATCH_INSERT_SIZE = 1000;
  public static final String LINE_SEPARATOR = ",";
  public static Map<String, IndexWords> cacheWords = new HashMap<>();


  @Autowired
  private PoetryIndexEntityMapper poetryIndexEntityMapper;

  @Override
  public Map<String, IndexWords> indexWords(File file) {
    Map<String, IndexWords> returnIndexWords = new HashMap<>();

    // convert file to string list.
    List<String> lines = FileUtils.readFileLines(file);

    // loop the list, spilt each string by ","
    for (String line : lines) {
      String[] fields = line.split(LINE_SEPARATOR);
      Long poetryId = Long.valueOf(fields[0]);

      for (int i = 1; i < fields.length; i++) {
        String words = fields[i];
        String regex3 = "[\\u4e00-\\u9fa5]+";
        boolean cleanChinese = words.matches(regex3);
        if(!cleanChinese) {
          log.info("Skip {}, {}", words, poetryId);
          continue;
        }

        IndexWords indexWords = cacheWords.get(words);
        if (null == indexWords) {
          indexWords = new IndexWords();
          indexWords.setWords(words);
          indexWords.setWordsPinyin(PinyinUtils.getPinYin(words));
          indexWords.setWordsLetter(PinyinUtils.getPinYinFirstChar(words));
          for (int j = 0; j < words.length(); j++) {
            Character word = words.charAt(j);
            indexWords.setIndexWord(j, word.toString());
          }
        }
        cacheWords.put(words, indexWords);
        returnIndexWords.put(words, indexWords);
        // add poetryId into indexWords.
        indexWords.addPoetryId(poetryId);
      }

    }
    return returnIndexWords;
  }


  @Override
  public void storeInDb(Map<String, IndexWords> words) {
    Iterator iterator = words.entrySet().iterator();
    List<PoetryIndexEntity> indexEntities = new ArrayList<>(words.size());
    StringBuffer stringBuffer = new StringBuffer();
    while(iterator.hasNext()) {
      Map.Entry item = (Map.Entry) iterator.next();
      IndexWords indexWords = (IndexWords)item.getValue();
      indexEntities.add(indexWords.toEntity());
      stringBuffer.append(indexWords.toString());
    }

    FileUtils.writeFile("indexWords_"+System.currentTimeMillis(), stringBuffer.toString());

    // group list by size, batch insert.
    int fromIndex = 0;
    while(fromIndex + BATCH_INSERT_SIZE <= indexEntities.size()) {
      int toIndex = fromIndex + BATCH_INSERT_SIZE;
      poetryIndexEntityMapper.batchInsert(indexEntities.subList(fromIndex, toIndex));
      fromIndex = toIndex;
    }

    // insert rest of  exist.
    if(indexEntities.size()-fromIndex > 0) {
      poetryIndexEntityMapper.batchInsert(indexEntities.subList(fromIndex, indexEntities.size()));
    }
  }
}
