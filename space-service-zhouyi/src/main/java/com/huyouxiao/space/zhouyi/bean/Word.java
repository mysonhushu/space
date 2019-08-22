package com.huyouxiao.space.zhouyi.bean;

import com.huyouxiao.space.dao.entity.WordEntity;
import lombok.Data;

@Data
public class Word {
  private String word;
  private String pingYin;
  private int strokes;
  private String radicals;
  private String explanation;
  public Word() {

  }
  public Word(WordEntity entity) {
    if (null == entity) {
      return;
    }
    word = entity.getWord();
    pingYin = entity.getPinyin();
    strokes = entity.getStrokes();
    radicals = entity.getRadicals();
    explanation = entity.getExplanation().replace("\n\n","");
  }
}
