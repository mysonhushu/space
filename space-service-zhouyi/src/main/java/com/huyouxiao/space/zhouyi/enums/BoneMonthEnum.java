package com.huyouxiao.space.zhouyi.enums;

/**
 * 　　出生月的重量：
 *
 * 正月	六钱	    二月	七钱	    三月	一两八钱	  四月	九钱
 * 五月	五钱	    六月	一两六钱	七月	九钱	      八月	一两五钱
 * 九月	一两八钱	十月	八钱	    十一月	九钱	  十二月	五钱
 *
 * January——1月
 *
 * February——2月
 *
 * March——3月
 *
 * April——4月
 *
 * May——5月
 *
 * June——6月
 *
 * July——7月
 *
 * August——8月
 *
 * September——9月
 *
 * October——10月
 *
 * November——11月
 *
 * December——12月
 */
public enum BoneMonthEnum {
  January("正月", 1,	"六钱", 0, 6),
  February("二月", 2,	"七钱", 0, 7),
  March("三月", 3,	"一两八钱", 1, 8),
  April("四月", 4, "九钱", 0, 9),
  May("五月", 5,	"五钱", 0, 5),
  June("六月", 6, "一两六钱", 1, 6),
  July("七月", 7,	"九钱", 0, 9	),
  Auguest("八月", 8, "一两五钱", 1, 5),
  September("九月", 9, "一两八钱", 1, 8),
  October("	十月", 10, "八钱", 0, 8),
  November("十一月", 11, "九钱", 0, 9),
  December("十二月	", 12, "五钱", 0, 5),
  ;
  private String monthName;
  private int    month;
  private String weightName;
  private int liang;
  private int qian;
  private BoneMonthEnum(String monthName, int month, String weightName, int liang, int qian) {
    this.monthName = monthName;
    this.month = month;
    this.weightName = weightName;
    this.liang = liang;
    this.qian = qian;
  }

  public static BoneMonthEnum getByMonth(int month) {
    for (BoneMonthEnum value: BoneMonthEnum.values()) {
      if (value.month == month) {
        return value;
      }
    }
    return null;
  }

  public String getMonthName() {
    return monthName;
  }

  public int getMonth() {
    return month;
  }

  public String getWeightName() {
    return weightName;
  }

  public int getLiang() {
    return liang;
  }

  public int getQian() {
    return qian;
  }
}
