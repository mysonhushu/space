package com.huyouxiao.space.poetry.bean;

import com.huyouxiao.space.dao.entity.PoetryEntity;
import lombok.Data;

@Data
public class Poetry {
  private Long id;
  private String name;
  private String dynasty;
  private String sentence;

  public Poetry() {

  }

  public Poetry(PoetryEntity poetryEntity, String word) {
    id = poetryEntity.getId();
    name = poetryEntity.getName();
    dynasty = poetryEntity.getDynasty();
    String content = poetryEntity.getContent().replace("</p>","").replace("<p>","").replace("?","").replace("?","");
    String[] sentences = content.split("。");
    for (String value: sentences) {
      if (value.contains(word)) {
        sentence = value;
        return;
      }
    }
  }
}
