package com.huyouxiao.space.zhouyi.enums;

/**
 * ganzhiList = ["甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥",
 *               "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥",
 *               "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥",
 *               "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥",
 *               "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"]
 *
 */
public enum BoneYearEnum {
  YEAR_AT_JIA_ZI(0,"鼠", "甲子", "一两二钱", 1, 2),
  YEAR_AT_BING_ZI(12,"鼠", "丙子", "一两六钱", 1, 6),
  YEAR_AT_WU_ZI(24, "鼠", "戊子", "一两五钱", 1, 5),
  YEAR_AT_GEN_ZI(36, "鼠", "庚子", "七钱", 0 ,7),
  YEAR_AT_REN_ZI(48, "鼠","壬子", "五钱", 0, 5),
  YEAR_OX_YI_COU(1,"牛", "乙丑", "九钱", 0,9),
  YEAR_OX_DING_COU(13,"牛", "丁丑", "八钱", 0, 8),
  YEAR_OX_JI_COU(25, "牛", "己丑", "七钱", 0, 7),
  YEAR_OX_XIN_COU(37,"牛", "辛丑", "七钱", 0, 7),
  YEAR_OX_GUI_COU(49, "牛", "癸丑", "七钱", 0, 7),
  YEAR_TIGER_BIN_YIN(2, "虎", "丙寅", "六钱", 0, 6),
  YEAR_TIGER_WU_YIN(14,"虎", "戊寅", "八钱", 0, 8),
  YEAR_TIGER_GEN_YIN(26,"虎", "庚寅", "九钱", 0, 9),
  YEAR_TIGER_REN_YIN(38,"虎", "壬寅", "九钱", 0, 9),
  YEAR_TIGER_JIA_YIN(50,"虎", "甲寅", "一两二钱", 1, 2),
  YEAR_RABBIT_DING_MAO(3,"兔", "丁卯", "七钱", 0, 7),
  YEAR_RABBIT_JI_MAO(15,"兔", "己卯", "一两九钱", 1, 9),
  YEAR_RABBIT_XIN_MAO(27, "兔", "辛卯", "一两二钱", 1, 2),
  YEAR_RABBIT_GUI_MAO(39, "兔", "癸卯", "一两二钱", 1, 2),
  YEAR_RABBIT_YI_MAO(51, "兔", "乙卯", "八钱", 0, 8),
  YEAR_DRAGON_WU_CHEN(4, "龙", "戊辰", "一两二钱", 1, 2),
  YEAR_DRAGON_GEN_CHEN(16, "龙", "庚辰", "一两二钱", 1, 2),
  YEAR_DRAGON_REN_CHEN(28, "龙", "壬辰", "一两", 1, 0),
  YEAR_DRAGON_JIA_CHEN(40, "龙", "甲辰", "八钱", 0, 8),
  YEAR_DRAGON_BIB_CHEN(52, "龙", "丙辰", "八钱", 0, 8),
  YEAR_SNAKE_JI_SI(5, "蛇", "己已", "五钱", 0, 5),
  YEAR_SNAKE_XIN_SI(17,"蛇", "辛已", "六钱", 0, 6),
  YEAR_SNAKE_GUI_SI(29,"蛇", "癸已", "七钱",0 ,7),
  YEAR_SNAKE_YI_SI(41,"蛇", "乙已", "七钱", 0, 7),
  YEAR_SNAKE_DING_SI(53, "蛇", "丁已", "六钱", 0 ,6),
  YEAR_HOURSE_GEN_WU(6, "马", "庚午", "九钱", 0, 9),
  YEAR_HOURSE_REN_WU(18, "马", "壬午", "八钱", 0, 8),
  YEAR_HOURSE_JIA_WU(30, "马", "甲午", "一两五钱", 1, 5),
  YEAR_HOURSE_BIN_WU(42, "马", "丙午", "一两三钱", 1, 3),
  YEAR_HOURSE_WU_WU(54, "马", "戊午", "一两九钱",1, 9),
  YEAR_GOAT_XIN_WEI(7, "羊", "辛未", "八钱", 0, 8),
  YEAR_GOAT_GUI_WEI(19, "羊",  "癸未", "七钱", 0, 7),
  YEAR_GOAT_YI_WEI(31, "羊", "乙未", "六钱",0, 6),
  YEAR_GOAT_DING_WEI(43, "羊", "丁未", "五钱",0 ,5),
  YEAR_GOAT_JI_WEI(55, "羊", "己未", "六钱", 0, 6),
  YEAR_MONKEY_REN_SHEN(8,"猴", "壬申", "七钱", 0, 7),
  YEAR_MONKEY_JIA_SHEN(20,"猴", "甲申", "五钱", 0, 5),
  YEAR_MONKEY_BIN_SHEN(32, "猴", "丙申", "五钱", 0, 5),
  YEAR_MONKEY_WU_SHEN(44, "猴", "戊申", "一两四钱", 1, 4),
  YEAR_MONKEY_GEN_SHEN(56, "猴", "庚申", "八钱", 0 ,8),
  YEAR_ROOSTER_GUI_YOU(9, "鸡", "癸酉", "八钱", 0, 8),
  YEAR_ROOSTER_YI_YOU(21, "鸡", "乙酉", "一两五钱", 1, 5),
  YEAR_ROOSTER_DING_YOU(33,"鸡", "丁酉", "一两四钱", 1, 4),
  YEAR_ROOSTER_JI_YOU(45, "鸡", "己酉", "五钱", 0, 5),
  YEAR_ROOSTER_XIN_YOU(57, "鸡", "辛酉", "一两六钱", 1, 6),
  YEAR_DOG_JIA_XU(10, "狗", "甲戍", "一两五钱",1,5),
  YEAR_DOG_BIN_XU(22, "狗",  "丙戍", "六钱",0 ,6 ),
  YEAR_DOG_WU_XU(34,"狗",  "戊戍", "一两四钱" , 1,4),
  YEAR_DOG_GEN_XU(46, "狗",  "庚戍", "九钱",0, 9),
  YEAR_DOG_REN_XU(58, "狗", "壬戍", "一两",1, 0),
  YEAR_PIG_YI_HAI(11, "猪", "乙亥", "九钱", 0, 9),
  YEAR_PIG_DING_HAI(23, "猪", "丁亥", "一两六钱",1,6),
  YEAR_PIG_JI_HAI(35, "猪", "己亥", "九钱",0, 9),
  YEAR_PIG_XIN_HAI(47, "猪", "辛亥", "一两七钱", 1, 7),
  YEAR_PIG_GUI_HAI(59, "猪", "癸亥", "六钱", 0 , 6),
  ;
  private int    number;
  private String zodiac;
  private String yearName;
  private String weightName;
  private int liang;
  private int qian;

  private BoneYearEnum(int number, String zodiac, String yearName, String weightName, int liang, int qian) {
    this.number = number;
    this.zodiac = zodiac;
    this.yearName = yearName;
    this.weightName = weightName;
    this.liang = liang;
    this.qian = qian;
  }

  public static BoneYearEnum getByNumber(int number) {
    for (BoneYearEnum year : BoneYearEnum.values()) {
      if (year.number == number) {
        return year;
      }
    }
    return null;
  }

  public String getZodiac() {
    return zodiac;
  }

  public String getYearName() {
    return yearName;
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
