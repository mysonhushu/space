package com.huyouxiao.space.bookworm.impl;

import com.huyouxiao.space.bookworm.StatisticsWordService;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import com.huyouxiao.space.common.utils.FileUtils;
import com.huyouxiao.space.common.utils.PinyinUtils;
import com.huyouxiao.space.dao.entity.WordEntity;
import com.huyouxiao.space.dao.entity.WordFrequencyEntity;
import com.huyouxiao.space.dao.mapper.WordEntityMapper;
import com.huyouxiao.space.dao.mapper.WordFrequencyEntityMapper;
import com.huyouxiao.space.model.bookworm.StatisticsWord;
import com.huyouxiao.space.model.poetry.enums.SensitiveTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@Slf4j
public class StatisticsWordServiceImpl implements StatisticsWordService {
  public static final int BATCH_INSERT_SIZE = 1000;



  @Autowired
  private WordEntityMapper wordEntityMapper;

  @Autowired
  private WordFrequencyEntityMapper wordFrequencyEntityMapper ;

  public void setWordEntityMapper(WordEntityMapper wordEntityMapper) {
    this.wordEntityMapper = wordEntityMapper;
  }

  @Override
  public Map<Character, StatisticsWord> statistics(File file, SensitiveTypeEnum sensitiveTypeEnum) {
    if( null == sensitiveTypeEnum) {
      log.warn("request sensitiveType can't be null. fileName:{}", file.getName());
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
    List<String> lines = FileUtils.readFileLines(file);

    Map<Character, StatisticsWord> result = new HashMap<>();

    Set<Character> cache = new HashSet<>();

    // use set to remove duplicate.
    for(String line : lines) {
      for(int i=0; i< line.length(); i++) {
        Character word = line.charAt(i);

        if(cache.contains(word.charValue())) {
          continue;
        } else {
          cache.add(word);
        }
      }
    }


    // query word id
    for(Character word : cache) {
      String pinyinLetter = PinyinUtils.getPinYin(word.toString());
      WordEntity wordEntity = wordEntityMapper.selectByWord(word.toString(), pinyinLetter);
      if(null != wordEntity) {
        StatisticsWord statisticsWord = new StatisticsWord();
        statisticsWord.setWord(word.toString());
        statisticsWord.setWordId(wordEntity.getId());
        statisticsWord.setType(sensitiveTypeEnum);
        result.put(word.charValue(), statisticsWord);
      }
    }

    // statistic words
    for(String line : lines) {
      for(int i=0; i< line.length(); i++) {
        Character word = line.charAt(i);
        StatisticsWord sw = result.get(word.charValue());
        if(null != sw) {
          sw.increase();
        }
      }
    }
    return result;
  }

  @Override
  public void storeInDb(Map<Character, StatisticsWord> words) {
    Iterator iterator = words.entrySet().iterator();
    List<WordFrequencyEntity> wordScoreEntities = new ArrayList<>(words.size());
    while(iterator.hasNext()) {
      Map.Entry item = (Map.Entry) iterator.next();
      StatisticsWord statisticsWord = (StatisticsWord)item.getValue();
      wordScoreEntities.add(statisticsWord.toEntity());
    }

    // group list by size, batch insert.
    int fromIndex = 0;
    while(fromIndex + BATCH_INSERT_SIZE <= wordScoreEntities.size()) {
      int toIndex = fromIndex + BATCH_INSERT_SIZE;
      wordFrequencyEntityMapper.batchInsert(wordScoreEntities.subList(fromIndex, toIndex));
      fromIndex = toIndex;
    }

    // insert rest of  exist.
    if(wordScoreEntities.size()-fromIndex > 0) {
      wordFrequencyEntityMapper.batchInsert(wordScoreEntities.subList(fromIndex, wordScoreEntities.size()));
    }
  }



}
