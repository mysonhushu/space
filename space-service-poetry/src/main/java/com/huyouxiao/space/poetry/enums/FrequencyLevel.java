package com.huyouxiao.space.poetry.enums;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum FrequencyLevel {
  LEVEL_A("LEVEL_A",1,5, "独一无二"),
  LEVEL_B("LEVEL_B",5,10, "万里挑一"),
  LEVEL_C("LEVEL_C",10,20, "千载难逢"),
  LEVEL_D("LEVEL_D",20,50, "百花齐放"),
  LEVEL_E("LEVEL_E",50,100, "十全十美"),
  LEVEL_F("LEVEL_F",100,2000, "喜闻乐见"),
  LEVEL_G("LEVEL_G",2000,3000, "满腹经纶");
  private String code;
  private Integer start;
  private Integer end;
  private String  label;
  private FrequencyLevel(String code, Integer start, Integer end, String label) {
      this.code  = code;
      this.start = start;
      this.end   = end;
      this.label = label;
  }

  public String getCode() {
    return code;
  }

  public Integer getStart() {
    return start;
  }

  public Integer getEnd() {
    return end;
  }

  public String getLabel() {
    return label;
  }

  public static String getLabelByFrequency(int frequency) {
    for (FrequencyLevel level : FrequencyLevel.values()) {
      if (level.start <= frequency && level.end > frequency) {
        return level.label;
      }
    }
    return LEVEL_G.label;
  }
}
