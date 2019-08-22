package com.huyouxiao.space.zhouyi.enums;

public enum SixElementEnum {
  water("water", "水", 1, WordEnum.earth),
  waterEarth("waterEarth", "土", 2, WordEnum.earth),
  wood("wood", "木", 3, WordEnum.earth),
  fire("fire", "火", 4, WordEnum.earth),
  fireEarth("fireEarth", "土", 5, WordEnum.earth),
  gold("gold","金", 5, WordEnum.earth),
      ;
  private String code;
  private String name;
  private Integer order;
  private WordEnum position;


  private SixElementEnum(String code, String name, Integer order, WordEnum position) {
    this.code = code;
    this.name = name;
    this.order = order;
    this.position = position;
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

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public WordEnum getPosition() {
    return position;
  }

  public void setPosition(WordEnum position) {
    this.position = position;
  }
}
