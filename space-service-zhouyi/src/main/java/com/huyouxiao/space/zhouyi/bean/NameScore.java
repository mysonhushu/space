package com.huyouxiao.space.zhouyi.bean;

import com.huyouxiao.space.zhouyi.enums.FiveGridEnum;
import lombok.Data;

@Data
public class NameScore {
  private FiveGridEnum grid;
  private int score;
  private String description;
  private String fierce;
  private int strokes;
}
