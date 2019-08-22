package com.huyouxiao.space.zhouyi.enums;


/**
 * 天干
 *    木  火  土  金  水
 * 阳  甲  丙  戊  庚  壬
 * 阴  乙  丁  己  辛  癸
 */
public enum HeavenEnum {
  jia(1, "甲", "jia",  YinYangEnum.yang, FiveElementEnum.wood, DirectionEnum.EAST),
  yi(2, "乙", "yi",  YinYangEnum.yin, FiveElementEnum.wood, DirectionEnum.EAST),

  bing(3, "丙", "bing",  YinYangEnum.yang, FiveElementEnum.fire, DirectionEnum.NORTH),
  ding(4, "丁", "ding",  YinYangEnum.yin, FiveElementEnum.fire, DirectionEnum.NORTH),

  wu(5, "戊", "wu",  YinYangEnum.yang, FiveElementEnum.earth, DirectionEnum.CENTER),
  ji(6, "己", "ji",  YinYangEnum.yin, FiveElementEnum.earth, DirectionEnum.CENTER),

  geng(7, "庚", "geng",  YinYangEnum.yang, FiveElementEnum.gold, DirectionEnum.WEST),
  xin(8, "辛", "xin",  YinYangEnum.yin, FiveElementEnum.gold, DirectionEnum.WEST),

  ren(9, "壬", "ren",  YinYangEnum.yang, FiveElementEnum.water, DirectionEnum.SOUTH),
  gui(10, "癸", "gui", YinYangEnum.yin, FiveElementEnum.water, DirectionEnum.SOUTH);

  private int number;
  private String  name;
  private String  code;
  private YinYangEnum position;
  private FiveElementEnum element;
  private DirectionEnum direction;

  private HeavenEnum(Integer number, String name, String code, YinYangEnum position, FiveElementEnum element, DirectionEnum direction) {
    this.number = number;
    this.name = name;
    this.code = code;
    this.position = position;
    this.element = element;
    this.direction = direction;
  }


  public static HeavenEnum getByNumber(int number) {
    for(HeavenEnum value : HeavenEnum.values()) {
      if(value.getNumber() == number) {
        return value;
      }
    }
    return null;
  }


  public static HeavenEnum getByName(String name) {
    for(HeavenEnum value : HeavenEnum.values()) {
      if(value.getName().equals(name) ) {
        return value;
      }
    }
    return null;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
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

  public YinYangEnum getPosition() {
    return position;
  }

  public void setPosition(YinYangEnum position) {
    this.position = position;
  }

  public FiveElementEnum getElement() {
    return element;
  }

  public void setElement(FiveElementEnum element) {
    this.element = element;
  }

  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }
}
