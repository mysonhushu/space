package com.huyouxiao.space.poetry.bean;

import com.huyouxiao.space.dao.entity.NamePoolEntity;
import com.huyouxiao.space.dao.entity.PoetryIndexEntity;
import com.huyouxiao.space.poetry.enums.FrequencyLevel;
import com.huyouxiao.space.zhouyi.bean.Word;
import com.huyouxiao.space.zhouyi.bean.response.NameScoreResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Name {
  private String chineseName;
  private String namePinyin;
  private int score;
  private NameScoreResponse nameScore;
  private String detail;
  private String frequency;
  private List<Word> words;
  private boolean fromPoetry = false;
  private List<Poetry> poetry = new ArrayList<>();

  public static Name get(String familyName, NamePoolEntity entity) {
    Name instance = new Name();
    instance.setChineseName(familyName + entity.getName());
    instance.setNamePinyin(entity.getNamePinyin().toUpperCase());
    instance.setFrequency(FrequencyLevel.getLabelByFrequency(entity.getFrequency()));
    return instance;
  }

  public static Name get(String familyName, PoetryIndexEntity index) {
    Name instance = new Name();
    instance.setChineseName(familyName + index.getWords());
    instance.setNamePinyin(index.getWordsLetter().toUpperCase());
    instance.setFrequency(FrequencyLevel.LEVEL_G.getLabel());
    instance.setFromPoetry(true);
    return instance;
  }

  public String isFromPoetry() {
    if (fromPoetry) {
      return "查询到 " + poetry.size() + " 首诗歌包含。";
    } else {
      return "没有查询到相关的诗歌。";
    }
  }
}
