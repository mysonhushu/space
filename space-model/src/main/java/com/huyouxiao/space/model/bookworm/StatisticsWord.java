package com.huyouxiao.space.model.bookworm;

import com.huyouxiao.space.dao.entity.WordFrequencyEntity;
import com.huyouxiao.space.model.poetry.enums.SensitiveTypeEnum;
import lombok.Data;

@Data
public class StatisticsWord {
  private Long wordId;
  private String word;
  private Integer frequency = 1;
  private SensitiveTypeEnum type;
  public  void increase() {
    frequency = frequency + 1;
  }

  public WordFrequencyEntity toEntity() {
    WordFrequencyEntity  entity = new WordFrequencyEntity();
    entity.setWord(word);
    entity.setWordId(wordId);
    entity.setFrequency(frequency);
    entity.setSensitiveType(type.getCode());
    entity.setStatus("1");
    return entity;
  }
}
