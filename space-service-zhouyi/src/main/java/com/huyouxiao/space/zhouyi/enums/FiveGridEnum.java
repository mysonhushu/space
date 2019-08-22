package com.huyouxiao.space.zhouyi.enums;

/**
 * 天格：是先祖留传下来的，其数理对人影响不大。
 * 地格：又称前运，影响人中年以前的活动力。
 * 人格：又称主运，是整个姓名的中心点，影响人的一生命运。
 * 总格：又称后运，影响人中年以后的命运。
 * 外格：又称变格，影响人的社交能力、智慧等，其数理不用重点去看。
 */
public enum FiveGridEnum {
  HEAVEN_GRID("天格", "是先祖留传下来的，其数理对人影响不大。"),
  EARTH_GRID("地格", "又称前运，影响人中年以前的活动力。"),
  PERSON_GRID("人格", "又称主运，是整个姓名的中心点，影响人的一生命运。"),
  TOTAL_GRID("总格", "又称后运，影响人中年以后的命运。"),
  OUTSIDE_GRID("外格", "又称变格，影响人的社交能力、智慧等，其数理不用重点去看。"),
    ;
  private String name;
  private String description;
  private FiveGridEnum(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
