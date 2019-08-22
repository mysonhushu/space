package com.huyouxiao.space.zhouyi.enums;

/**
 * 五行相生：木生火，火生土，土生金，金生水，水生木。 五行相剋：木剋土，土剋水，水剋火，火剋金，金剋木。
 */
public enum FiveElementEnum {
  water("water", "水",1, WordEnum.heaven, "木", "火"),
  fire("fire", "火", 2, WordEnum.heaven, "土", "金"),
  earth("earth", "土", 3, WordEnum.heaven, "金", "水"),
  gold("gold","金", 4, WordEnum.heaven, "水", "木"),
  wood("wood", "木", 5, WordEnum.heaven, "火", "土"),
  ;
  private String code;
  private String name;
  private Integer order;
  private WordEnum position;
  private String produce;
  private String kill;


  private FiveElementEnum(String code, String name, Integer order, WordEnum position, String produce, String kill) {
    this.code = code;
    this.name = name;
    this.order = order;
    this.position = position;
    this.produce = produce;
    this.kill = kill;
  }

  public static FiveElementEnum getByName(String name) {
    for (FiveElementEnum value : FiveElementEnum.values()) {
      if (value.getName().equals(name)) {
        return value;
      }
    }
    return null;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public Integer getOrder() {
    return order;
  }

  public WordEnum getPosition() {
    return position;
  }

  public String getProduce() {
    return produce;
  }

  public String getKill() {
    return kill;
  }}
