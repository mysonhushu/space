package com.huyouxiao.space.zhouyi.enums;

/**
 * 地支
 *    水   湿土  木   火  燥土   金
 * 阳  子   辰    寅   午  戌     申
 * 阴  亥   丑    卯   巳  未     酉
 *
 * （子、丑、寅、卯、辰、巳、午、未、申、酉、戌、亥）
 */
public enum EarthEnum {
  zi(1, "子", "zi",  YinYangEnum.yang, SixElementEnum.water, DirectionEnum.NORTH),
  chou(2, "丑", "chou",  YinYangEnum.yin, SixElementEnum.waterEarth, DirectionEnum.SOUTH_TO_EAST),

  yin(3, "寅", "yin",  YinYangEnum.yang, SixElementEnum.wood, DirectionEnum.EAST_TO_SOUTH),
  mao(4, "卯", "mao",  YinYangEnum.yin, SixElementEnum.wood, DirectionEnum.EAST),

  chen(5, "辰", "chen", YinYangEnum.yang, SixElementEnum.waterEarth, DirectionEnum.EAST_TO_NORTH),
  si(6, "巳", "si",  YinYangEnum.yin, SixElementEnum.fire, DirectionEnum.NORTH_TO_EAST),

  wu(7, "午", "wu",  YinYangEnum.yang, SixElementEnum.fire, DirectionEnum.NORTH),
  wei(8, "未", "wei", YinYangEnum.yin, SixElementEnum.fireEarth, DirectionEnum.NORTH_TO_WEST),

  shen(9, "申", "shen",  YinYangEnum.yang, SixElementEnum.gold, DirectionEnum.WEST_TO_NORTH),
  you(10, "酉", "you", YinYangEnum.yin, SixElementEnum.gold, DirectionEnum.WEST),

  xu(11, "戌", "xu",  YinYangEnum.yang, SixElementEnum.fireEarth, DirectionEnum.WEST_TO_SOUTH),
  hai(12, "亥", "hai",  YinYangEnum.yin, SixElementEnum.water, DirectionEnum.NORTH_TO_WEST),
  ;
  private int number;
  private String  name;
  private String  code;
  private YinYangEnum position;
  private SixElementEnum element;
  private DirectionEnum direction;


  private EarthEnum(Integer number, String name, String code, YinYangEnum position, SixElementEnum element, DirectionEnum direction) {
    this.number = number;
    this.name = name;
    this.code = code;
    this.position = position;
    this.element = element;
    this.direction = direction;
  }

  public static EarthEnum getByNumber(int number) {
    if(number == 0) {
      return hai;
    }
    for(EarthEnum value : EarthEnum.values()) {
      if(value.getNumber() == number) {
        return value;
      }
    }
    return null;
  }

  public static EarthEnum getByName(String name) {
    for(EarthEnum value : EarthEnum.values()) {
      if(value.getName().equals(name)) {
        return value;
      }
    }
    return null;
  }

  public int getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public YinYangEnum getPosition() {
    return position;
  }

  public SixElementEnum getElement() {
    return element;
  }

  public DirectionEnum getDirection() {
    return direction;
  }}
