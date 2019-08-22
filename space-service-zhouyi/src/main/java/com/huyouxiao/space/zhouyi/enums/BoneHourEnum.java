package com.huyouxiao.space.zhouyi.enums;

/**
 * 　　出生时辰的重量：
 *
 * 子时	一两六钱	丑时	六钱	寅时	七钱	卯时	一两	辰时	九钱	巳时	一两六钱
 * 午时	一两	未时	八钱	申时	八钱	酉时	九钱	戌时	六钱	亥时	六钱
 *
 * 　　时辰还算表：
 *
 * 子时：	23:00 - 01:00	丑时：	01:00 - 03:00	寅时：	03:00 - 05:00	卯时：	05:00 - 07:00
 * 辰时：	07:00 - 09:00	已时：	09:00 - 11:00	午时：	11:00 - 13:00	未时：	13:00 - 15:00
 * 申时：	15:00 - 17:00	酉时：	17:00 - 19:00	戌时：	19:00 - 21:00	亥时：	21:00 - 23:00
 */
public enum BoneHourEnum {
  HOUR_ZI("子时",	 "一两六钱", 1, 6, 23, 1),
  HOUR_COU("丑时",	"六钱", 0, 6, 1, 3),
  HOUR_YIN("寅时",	"七钱", 0, 7, 3, 5),
  HOUR_MAO("卯时", "一两",	 1, 0, 5, 7),
  HOUR_CHEN("辰时", "九钱", 0, 9, 7, 9),
  HOUR_SI("巳时",	 "一两六钱", 1, 6, 9, 11),
  HOUR_WU("午时", "一两", 1, 0, 11, 13),
  HOUR_WEI("未时", "八钱", 0, 8, 13, 15),
  HOUR_SHEN("申时", 	"八钱", 0, 8, 15, 17),
  HOUR_YOU("酉时",	"九钱", 0, 9, 17, 19),
  HOUR_XU("戌时", 	"六钱", 0, 6, 19, 21),
  HOUR_HAI("亥时", 	"六钱", 0, 6, 21, 23),
  ;
  private String hourName;
  private String weightName;
  private int liang;
  private int qian;
  private int startHour;
  private int endHour;
  private BoneHourEnum(String hourName, String weightName, int liang, int qian, int startHour, int endHour) {
    this.hourName = hourName;
    this.weightName = weightName;
    this.liang = liang;
    this.qian = qian;
    this.startHour = startHour;
    this.endHour = endHour;
  }

  public static BoneHourEnum getByHour(int hour) {
    if ( hour == 23 || hour == 0) {
      return HOUR_ZI;
    }
    for (BoneHourEnum value: BoneHourEnum.values()) {
      if (value.startHour <= hour && value.endHour > hour) {
        return value;
      }
    }
    return null;
  }

  public String getHourName() {
    return hourName;
  }

  public String getWeightName() {
    return weightName;
  }

  public int getStartHour() {
    return startHour;
  }

  public int getEndHour() {
    return endHour;
  }

  public int getLiang() {
    return liang;
  }

  public int getQian() {
    return qian;
  }}
