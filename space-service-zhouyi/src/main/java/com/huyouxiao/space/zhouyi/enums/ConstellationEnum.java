package com.huyouxiao.space.zhouyi.enums;

import java.util.Calendar;
import java.util.Date;

/**
 * 十二星座简表
 * 星 座  属性  形态  守护行星  关 键 字 眼  太阳星座周期
 * 白羊座  阳性  火象  火 星  独断独行性急  3.21～4.20
 * 金牛座  阴性  地象  金 星  占有欲持久永恒  4.21～5.21
 * 双子座  阳性  风象  水 星  沟通适应力强  5.22～6.21
 * 巨蟹座  阴性  水象  月 亮  敏感安全感  6.22～7.22
 * 狮子座  阳性  火象  太 阳  创造力出众强猛  7.23～8.23
 * 处女座  阴性  土象  水 星  挑剔分析能力  8.24～9.23
 * 天秤座  阳性  风象  金 星  和谐团结      9.24～10.23
 * 天蝎座  阴性  水象  冥 王 星  专注热情      10.24～11.22
 * 射手座  阳性  火象  木 星  自由开拓精神广阔  11.23～12.21
 * 摩羯座  阴性  土象  土 星  审慎有抱负功心计  12.22～1.20
 * 水瓶座  阳性  风象  天 王 星  独立人道主义  1.21～2.18
 * 双鱼座  阴性  水象  海 王 星  暧暧昧易受影响 2.19～3.20
 *
 * 星座	符號	拉丁文	英文
 * 水瓶座(1/20-2/18)	♒	Aquarius	Water Carrier / Water Bearer
 * 雙魚座(2/19-3/20)	♓	Pisces	Fish / Fishes
 * 牧羊座(3/21-4/20)	♈	Aries	Ram
 * 金牛座(4/21-5/20)	♉	Taurus	Bull
 * 雙子座(5/21-6/21)	♊	Gemini	Twins
 * 巨蟹座(6/22-7/22)	♋	Cancer	Crab
 * 獅子座(7/23-8/22)	♌	Leo	Lion
 * 處女座(8/23-9/22)	♍	Virgo	Virgin
 * 天秤座(9/23-10/23)	♎	Libra	Scales / Balance
 * 天蠍座(10/24-11/22)	♏	Scorpio	Scorpion
 * 射手座(11/23-12/21)	♐	Sagittarius	Archer
 * 摩羯座(12/22-1/20)	♑	Capricorn	Goat / Sea Goat
 */
public enum ConstellationEnum {
  AQUARIUS_WATER_CARRIER("水瓶座", "阳性", "风象", "天王星", "独立人道主义", "♒", "AQUARIUS_WATER_CARRIER", 1, 21, 2, 18),
  PISCES_FISHES("双鱼座", "阴性", "水象", "海王星", "暧昧易受影响", "♓", "PISCES_FISH", 2, 19, 3, 20),
  ARIES_RAM("白羊座", "阳性", "火象", "火星", "独断独行性急", "♈", "ARIES_RAM", 3, 21, 4, 20),
  TAURUS_BULL("金牛座", "阳性", "地象", "金星", "占有欲持久永恒", "♉", "TAURUS_BULL", 4, 21, 5, 20),
  GEMINI_TWINS("双子座", "阳性", "风象", "水星", "沟通适应力强", "♊	", "GEMINI_TWINS", 5, 21, 6, 21),
  CANCER_CRAB("巨蟹座", "阴性", "水象", "月亮", "敏感安全感", "♋", "CANCER_CRAB", 6, 22, 7, 22),
  LEO_LION("狮子座", "阳性", "火象", "太阳", "创造力出众强猛", "♌", "LEO_LION", 7, 23, 8, 23),
  VIRGO_VIRGIN("处女座", "阴性", "土象", "水星", "挑剔分析能力", "♍", "VIRGO_VIRGIN", 8, 24, 9, 23),
  LIBRA_SCALES("天秤座", "阳性", "风象", "金星", "和谐团结", "♎", "LIBRA_SCALES",9, 24, 10, 23),
  SCORPIO_SCORPION("天蝎座", "阴性", "水象", "冥王星", "专注热情", "♏", "SCORPIO_SCORPION",10, 24, 11, 22),
  SAGITTARIUS_ARCHER("射手座", "阳性", "火象", "木星", "自由开拓精神广阔", "♐	", "SAGITTARIUS_ARCHER",11, 23, 12, 21),
  CAPRICORN_GOAT("摩羯座", "阴性", "土象", "土星", "审慎有抱负功心计", "♑	", "CAPRICORN_GOAT",12, 22, 1, 20),

  ;
  private String constellation;
  private String type;
  private String element;
  private String luckStar;
  private String description;
  private String symbol;
  private String code;
  private int beginMonth;
  private int beginDay;
  private int endMonth;
  private int endDay;

  private ConstellationEnum(String constellation, String type, String element, String luckStar, String description,
      String symbol, String code, int beginMonth, int beginDay, int endMonth, int endDay) {
    this.constellation = constellation;
    this.type = type;
    this.element = element;
    this.luckStar = luckStar;
    this.description = description;
    this.symbol = symbol;
    this.code = code;
    this.beginMonth = beginMonth;
    this.beginDay = beginDay;
    this.endMonth = endMonth;
    this.endDay = endDay;
  }

  public static ConstellationEnum getByDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day   = calendar.get(Calendar.DAY_OF_MONTH);
    for (ConstellationEnum value : ConstellationEnum.values()) {
      if (value.beginMonth == month && value.beginDay <= day) {
        return value;
      } else if (value.endMonth == month && value.endDay >= day) {
        return value;
      }
    }
    return null;
  }

  public String getConstellation() {
    return constellation;
  }

  public String getType() {
    return type;
  }

  public String getElement() {
    return element;
  }

  public String getLuckStar() {
    return luckStar;
  }

  public String getDescription() {
    return description;
  }

  public String getSymbol() {
    return symbol;
  }

  public String getCode() {
    return code;
  }

  public int getBeginMonth() {
    return beginMonth;
  }

  public int getBeginDay() {
    return beginDay;
  }

  public int getEndMonth() {
    return endMonth;
  }

  public int getEndDay() {
    return endDay;
  }}
