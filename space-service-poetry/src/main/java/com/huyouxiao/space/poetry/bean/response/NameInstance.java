package com.huyouxiao.space.poetry.bean.response;

import com.huyouxiao.space.common.utils.JsonUtils;
import com.huyouxiao.space.common.utils.PinyinUtils;
import com.huyouxiao.space.dao.entity.NamePoolEntity;
import lombok.Data;

import java.util.List;

@Data
public class NameInstance {
  private Long id;
  private String name;
  private String namePinyin;
  private String nameLetter;
  private String firstWord;
  private String secondWord;
  private String thirdWord;
  private String fourthWord;
  private Integer frequency = 1;
  private List<String> familyNames;

  public void addFamilyName(String familyName) {
    familyNames.add(familyName);
  }

  public void setWord(int i, String word) {
    if(i == 1) {
      firstWord = word;
    } else if (i == 2) {
      secondWord = word;
    } else if (i == 3) {
      thirdWord = word;
    } else if (i == 4) {
      fourthWord = word;
    }
  }

  public NamePoolEntity toEntity() {
    NamePoolEntity entity = new NamePoolEntity();
    entity.setName(name);
    entity.setNamePinyin(PinyinUtils.getPinYin(name));
    entity.setNameLetter(PinyinUtils.getPinYinFirstChar(name));
    entity.setFirstWord(firstWord);
    entity.setSecondWord(secondWord);
    entity.setThirdWord(thirdWord);
    entity.setFourthWord(fourthWord);
    entity.setFrequency(frequency);
    entity.setFamilyNames(JsonUtils.toJsonString(familyNames.toArray()));
    return entity;
  }

  public void addFrequency() {
    frequency = frequency + 1;
  }
}
