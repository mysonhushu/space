package com.huyouxiao.space.zhouyi.enums;

public enum WordEnum {
  heaven(1, "天", "heaven"),
  earth(-1, "地", "earth");
  private Integer value;
  private String name;
  private String code;

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  private WordEnum(Integer value, String name, String code) {
    this.value = value;
    this.name = name;
    this.code = code;
  }
}
