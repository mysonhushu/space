package com.huyouxiao.space.zhouyi.enums;

/**
 * 　　出生日的重量：
 *
 * 初一  五钱   初二  一两   初三  八钱      初四  一两五钱   初五  一两六钱
 * 初六  一两五钱  初七  八钱      初八  一两六钱  初九  八钱      初十  一两六钱
 * 十一  九钱  十二  一两七钱  十三  八钱  十四  一两七钱  十五  一两
 * 十六  八钱  十七  九钱  十八  一两八钱  十九  五钱  二十  一两
 * 廿一  一两  廿二  九钱  廿三  八钱  廿四  九钱  廿五  一两五钱
 * 廿六  一两八钱  廿七  七钱  廿八  八钱  廿九  一两六钱  三十  六钱
 */
public enum BoneDayEnum {
  DAY_1("初一", 1,  "五钱", 0 ,5),
  DAY_2("初二", 2, "一两", 1, 0),
  DAY_3("初三", 3,  "八钱", 0, 3),
  DAY_4("初四", 4,   "一两五钱", 1, 5),
  DAY_5("初五", 5, "一两六钱", 1, 6),
  DAY_6("初六", 6,  "一两五钱", 1, 5),
  DAY_7("初七", 7, "八钱", 0, 8),
  DAY_8("初八", 8, "一两六钱", 1, 8),
  DAY_9("初九", 9,   "八钱", 0, 9),
  DAY_10("初十", 10, "一两六钱", 1, 6),
  DAY_11("十一", 11,  "九钱", 0, 9),
  DAY_12("十二", 12,   "一两七钱", 1, 7),
  DAY_13("十三", 13, "八钱", 0, 8),
  DAY_14("十四", 14,  "一两七钱", 1, 7),
  DAY_15("十五", 15, "一两", 1, 0),
  DAY_16( "十六",  16, "八钱", 0, 8),
  DAY_17("十七", 17, "九钱", 0, 9),
  DAY_18("十八", 18,  "一两八钱", 1, 8),
  DAY_19("十九",  19,  "五钱", 0, 5),
  DAY_20("二十", 20,  "一两", 1, 0),
  DAY_21("廿一", 21, "一两", 1, 0),
  DAY_22("廿二", 22,  "九钱", 0, 9),
  DAY_23("廿三", 23,  "八钱", 0, 8),
  DAY_24("廿四", 24,  "九钱", 0,9),
  DAY_25("廿五", 25,  "一两五钱", 1, 5),
  DAY_26("廿六", 26,  "一两八钱", 1, 8),
  DAY_27("廿七", 27,  "七钱", 0, 7),
  DAY_28("廿八", 28,   "八钱", 0, 8),
  DAY_29("廿九", 29,   "一两六钱", 1, 6),
  DAY_30("三十", 30, "六钱", 0,6)
  ;
  private String dayName;
  private int    day;
  private String weight;
  private int liang;
  private int qian;
  private BoneDayEnum(String dayName, int day, String weight, int liang, int qian) {
    this.dayName = dayName;
    this.day = day;
    this.weight = weight;
    this.liang = liang;
    this.qian = qian;
  }

  public static BoneDayEnum getByDay(int day) {
    for (BoneDayEnum value : BoneDayEnum.values()) {
      if (value.day == day) {
        return value;
      }
    }
    return null;
  }

  public String getDayName() {
    return dayName;
  }

  public int getDay() {
    return day;
  }

  public String getWeight() {
    return weight;
  }

  public int getLiang() {
    return liang;
  }

  public int getQian() {
    return qian;
  }
}
