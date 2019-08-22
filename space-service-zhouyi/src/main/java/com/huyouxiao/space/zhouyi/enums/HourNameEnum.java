package com.huyouxiao.space.zhouyi.enums;

public enum HourNameEnum {
  JIA_ZI(23, 1, "子", "甲", "己", "甲子"),
  YI_COU(1, 3, "丑", "甲", "己", "乙丑"),
  BIN_YIN(3, 5, "寅", "甲", "己", "丙寅"),
  DING_MAO(5, 7, "卯", "甲", "己", "丁卯"),
  WU_CHEN(7, 9, "辰", "甲", "己", "戊辰"),
  JI_SI(9, 11, "巳", "甲", "己", "己巳"),
  GENG_WU(11, 13, "午", "甲", "己", "庚午"),
  XIN_WEI(13, 15, "未", "甲", "己", "辛未"),
  REN_SHENG(15, 17, "申", "甲", "己", "壬申"),
  GUI_YOU(17, 19, "酉", "甲", "己", "癸酉"),
  JIA_XU(19, 21, "戊", "甲", "己", "甲戌"),
  YI_HAI(21, 23, "亥", "甲", "己", "乙亥"),

  BING_ZI(23, 1, "子", "乙", "庚", "丙子"),
  DING_COU(1, 3, "丑", "乙", "庚", "丁丑"),
  WU_YIN(3, 5, "寅", "乙", "庚", "戊寅"),
  JI_MAO(5, 7, "卯", "乙", "庚", "己卯"),
  GENG__CHEN(7, 9, "辰", "乙", "庚", "庚辰"),
  XIN_SI(9, 11, "巳", "乙", "庚", "辛巳"),
  REN_WU(11, 13, "午", "乙", "庚", "壬午"),
  KUI_WEI(13, 15, "未", "乙", "庚", "癸未"),
  JIA_SHENG(15, 17, "申", "乙", "庚", "甲申"),
  YI_YOU(17, 19, "酉", "乙", "庚", "乙酉"),
  BIN_XU(19, 21, "戊", "乙", "庚", "丙戌"),
  DING_HAI(21, 23, "亥", "乙", "庚", "丁亥"),

  WU_ZI(23, 1, "子", "丙", "辛", "戊子"),
  JI_COU(1, 3, "丑", "丙", "辛", "己丑"),
  GENG_YIN(3, 5, "寅", "丙", "辛", "庚寅"),
  XIN_MAO(5, 7, "卯", "丙", "辛", "辛卯"),
  REN__CHEN(7, 9, "辰", "丙", "辛", "壬辰"),
  GUI_SI(9, 11, "巳", "丙", "辛", "癸巳"),
  JIA_WU(11, 13, "午", "丙", "辛", "甲午"),
  YI_WEI(13, 15, "未", "丙", "辛", "乙未"),
  BING_SHENG(15, 17, "申", "丙", "辛", "丙申"),
  DING_YOU(17, 19, "酉", "丙", "辛", "丁酉"),
  WU_XU(19, 21, "戊", "丙", "辛", "戊戌"),
  JI_HAI(21, 23, "亥", "丙", "辛", "己亥"),

  GENG_ZI(23, 1, "子", "丁", "壬", "庚子"),
  XIN_COU(1, 3, "丑", "丁", "壬", "辛丑"),
  REN_YIN(3, 5, "寅", "丁", "壬", "壬寅"),
  KUI_MAO(5, 7, "卯", "丁", "壬", "癸卯"),
  JIA__CHEN(7, 9, "辰", "丁", "壬", "甲辰"),
  YI_SI(9, 11, "巳", "丁", "壬", "乙巳"),
  BING_WU(11, 13, "午", "丁", "壬", "丙午"),
  DING_WEI(13, 15, "未", "丁", "壬", "丁未"),
  WU_SHENG(15, 17, "申", "丁", "壬", "戊申"),
  JI_YOU(17, 19, "酉", "丁", "壬", "己酉"),
  GENG_XU(19, 21, "戊", "丁", "壬", "庚戌"),
  XIN_HAI(21, 23, "亥", "丁", "壬", "辛亥"),

  REN_ZI(23, 1, "子", "戊", "癸", "壬子"),
  GUI_COU(1, 3, "丑", "戊", "癸", "癸丑"),
  JIA_YIN(3, 5, "寅", "戊", "癸", "甲寅"),
  YI_MAO(5, 7, "卯", "戊", "癸", "乙卯"),
  BING_CHEN(7, 9, "辰", "戊", "癸", "丙辰"),
  DING_SI(9, 11, "巳", "戊", "癸", "丁巳"),
  WU_WU(11, 13, "午", "戊", "癸", "戊午"),
  JI_WEI(13, 15, "未", "戊", "癸", "己未"),
  GENG_SHENG(15, 17, "申", "戊", "癸", "庚申"),
  XIN_YOU(17, 19, "酉", "戊", "癸", "辛酉"),
  REN_XU(19, 21, "戊", "戊", "癸", "壬戌"),
  GUI_HAI(21, 23, "亥", "戊", "癸", "癸亥"),

  ;

  private int start;
  private int end;
  private String earthName;
  private String firstHeavenName;
  private String secondHeavenName;
  private String value;

  private HourNameEnum(int start, int end, String earthName, String firstHeavenName, String secondHeavenName, String value) {
    this.start = start;
    this.end = end;
    this.earthName = earthName;
    this.firstHeavenName = firstHeavenName;
    this.secondHeavenName = secondHeavenName;
    this.value = value;
  }

  public static HourNameEnum getByHourHeavenName(int hour, String heavenName) {
    for(HourNameEnum item : HourNameEnum.values()) {
      if(hour >= item.start && hour < item.end &&
        (item.firstHeavenName.equals(heavenName) || item.secondHeavenName.equals(heavenName))) {
          return item;
      } else if((hour == 23 || hour == 0) && item.start == 23 && item.end == 1 &&
        (item.firstHeavenName.equals(heavenName) || item.secondHeavenName.equals(heavenName))) {
          return item;

      }
    }
    return null;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public String getEarthName() {
    return earthName;
  }

  public void setEarthName(String earthName) {
    this.earthName = earthName;
  }

  public String getFirstHeavenName() {
    return firstHeavenName;
  }

  public void setFirstHeavenName(String firstHeavenName) {
    this.firstHeavenName = firstHeavenName;
  }

  public String getSecondHeavenName() {
    return secondHeavenName;
  }

  public void setSecondHeavenName(String secondHeavenName) {
    this.secondHeavenName = secondHeavenName;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


}
