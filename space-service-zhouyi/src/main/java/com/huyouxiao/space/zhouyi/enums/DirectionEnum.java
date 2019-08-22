package com.huyouxiao.space.zhouyi.enums;

/**
 * 东 西 南 北 中
 *
 East, West, North, South, Center
 */
public enum DirectionEnum {
  NORTH("NORTH","南", 12),
  NORTH_TO_WEST("NORTH_TO_WEST","南偏西", 1),
  WEST_TO_NORTH("WEST_TO_NORTH","西偏南", 2),
  WEST("WEST","西", 3),
  WEST_TO_SOUTH("WEST_TO_SOUTH","西偏北", 4),
  SOUTH_TO_WEST("SOUTH_TO_WEST","北偏西", 5),
  SOUTH("SOUTH","北", 6),
  SOUTH_TO_EAST("SOUTH_TO_EAST","北偏东", 7),
  EAST_TO_SOUTH("EAST_TO_SOUTH","东偏北", 8),
  EAST("EAST","东", 9),
  EAST_TO_NORTH("EAST_TO_NORTH", "东偏南", 10),
  NORTH_TO_EAST("NORTH_TO_EAST", "南偏东", 11),
  CENTER("CENTER","中", 12);
  private String code;
  private String name;
  private Integer point;
  private DirectionEnum(String code, String name, Integer point) {
    this.code = code;
    this.name = name;
    this.point = point;
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
}
