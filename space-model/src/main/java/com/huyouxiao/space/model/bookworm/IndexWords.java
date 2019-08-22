package com.huyouxiao.space.model.bookworm;

import com.huyouxiao.space.common.utils.JsonUtils;
import com.huyouxiao.space.dao.entity.PoetryIndexEntity;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class IndexWords {
  private Long id;
  private String words;
  private String firstWord;
  private String secondWord;
  private String thirdWord;
  private String fourthWord;
  private String wordsPinyin;
  private String wordsLetter;
  private List<Long> poetryIds = new LinkedList<>();

  public PoetryIndexEntity toEntity() {
    PoetryIndexEntity entity = new PoetryIndexEntity();
    entity.setId(id);
    entity.setWords(words);
    entity.setFirstWord(firstWord);
    entity.setSecondWord(secondWord);
    entity.setThirdWord(thirdWord);
    entity.setFourthWord(fourthWord);
    entity.setWordsPinyin(wordsPinyin);
    entity.setWordsLetter(wordsLetter);
    entity.setPoetryIds(JsonUtils.toJsonStr(poetryIds.toArray(),true));
    entity.setPoetryIdsSize(poetryIds.size());
    return entity;
  }

  public void setIndexWord(int index, String value) {
    if(0 == index) {
      firstWord = value;
    } else if(1 == index) {
      secondWord = value;
    } else if(2 == index) {
      thirdWord = value;
    } else if (3 == index) {
      fourthWord = value;
    }
  }

  public void addPoetryId(Long poetryId) {
    poetryIds.add(poetryId);
  }

  @Override
  public String toString() {
    return  words + ',' +  poetryIds.toString()+"\r\n";
  }
}
