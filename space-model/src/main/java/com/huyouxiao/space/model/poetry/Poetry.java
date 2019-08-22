package com.huyouxiao.space.model.poetry;

import com.huyouxiao.space.dao.entity.PoetryEntity;
import lombok.Data;

@Data
public class Poetry {
  private Long id;

  private String name;

  private String dynasty;

  private String content;

  public static  Poetry getPoetry(PoetryEntity poetryEntity) {
     if(null == poetryEntity) {
       return null;
     }
     Poetry poetry = new Poetry();
     poetry.id = poetryEntity.getId();
     poetry.name = poetryEntity.getName();
     poetry.dynasty = poetryEntity.getDynasty();
     poetry.content = poetryEntity.getContent();
     return poetry;
  }
}
