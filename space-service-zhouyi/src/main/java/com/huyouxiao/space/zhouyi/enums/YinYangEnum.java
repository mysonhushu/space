package com.huyouxiao.space.zhouyi.enums;

public enum YinYangEnum {
  yin("yin", "阴", -1),
  yang("yang", "阳", 1);
  private String code;
  private String name;
  private Integer value;
  private YinYangEnum(String code, String name, Integer value) {
    this.code = code;
    this.name = name;
    this.value = value;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }
}
