package com.huyouxiao.space.zhouyi.enums;

import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public enum EarthTableEnum {
  zi_yue_zi_gui("子月","子","癸",  1.2),
  zi_yue_chou_gui("子月","丑","癸", 0.36),
  zi_yue_chou_xin("子月","丑","辛", 0.2),
  zi_yue_chou_ji("子月","丑","己", 0.5),
  zi_yue_yin_bing("子月","寅","丙", 0.3),
  zi_yue_yin_jia("子月","寅","甲", 0.84),
  zi_yue_mao_yi("子月","卯","乙", 1.2),
  zi_yue_chen_yi("子月","辰","乙", 0.36),
  zi_yue_chen_gui("子月","辰","癸", 0.24),
  zi_yue_chen_wu("子月","辰","戊", 0.5),
  zi_yue_si_geng("子月","巳","庚", 0.3),
  zi_yue_si_bing("子月","巳","丙", 0.7),
  zi_yue_wu_ding("子月","午","丁", 1.0),
  zi_yue_wei_ding("子月","未","丁", 0.3),
  zi_yue_wei_yi("子月","未","乙", 0.24),
  zi_yue_wei_ji("子月","未","己", 0.5),
  zi_yue_shen_ren("子月","申","壬", 0.36),
  zi_yue_shen_geng("子月","申","庚", 0.7),
  zi_yue_you_xin("子月","酉","辛", 1.0),
  zi_yue_xu_xin("子月","戌","辛", 0.3),
  zi_yue_xu_ding("子月","戌","丁", 0.2),
  zi_yue_xu_wu("子月","戌","戊", 0.5),
  zi_yue_hai_jia("子月","亥","甲", 0.36),
  zi_yue_hai_ren("子月","亥","壬", 0.84),


  chou_yue_zi_gui("丑月","子","癸",  1.1),
  chou_yue_chou_gui("丑月","丑","癸", 0.33),
  chou_yue_chou_xin("丑月","丑","辛", 0.228),
  chou_yue_chou_ji("丑月","丑","己", 0.55),
  chou_yue_yin_bing("丑月","寅","丙", 0.3),
  chou_yue_yin_jia("丑月","寅","甲", 0.742),
  chou_yue_mao_yi("丑月","卯","乙", 1.06),
  chou_yue_chen_yi("丑月","辰","乙", 0.318),
  chou_yue_chen_gui("丑月","辰","癸", 0.22),
  chou_yue_chen_wu("丑月","辰","戊", 0.55),
  chou_yue_si_geng("丑月","巳","庚", 0.342),
  chou_yue_si_bing("丑月","巳","丙", 0.7),
  chou_yue_wu_ding("丑月","午","丁", 1.0),
  chou_yue_wei_ding("丑月","未","丁", 0.3),
  chou_yue_wei_yi("丑月","未","乙", 0.212),
  chou_yue_wei_ji("丑月","未","己", 0.55),
  chou_yue_shen_ren("丑月","申","壬", 0.33),
  chou_yue_shen_geng("丑月","申","庚", 0.798),
  chou_yue_you_xin("丑月","酉","辛", 1.14),
  chou_yue_xu_xin("丑月","戌","辛", 0.342),
  chou_yue_xu_ding("丑月","戌","丁", 0.2),
  chou_yue_xu_wu("丑月","戌","戊", 0.55),
  chou_yue_hai_jia("丑月","亥","甲", 0.318),
  chou_yue_hai_ren("丑月","亥","壬", 0.77),


  yin_yue_zi_gui("寅月","子","癸",  1.0),
  yin_yue_chou_gui("寅月","丑","癸", 0.3),
  yin_yue_chou_xin("寅月","丑","辛", 0.2),
  yin_yue_chou_ji("寅月","丑","己", 0.53),
  yin_yue_yin_bing("寅月","寅","丙", 0.36),
  yin_yue_yin_jia("寅月","寅","甲", 0.798),
  yin_yue_mao_yi("寅月","卯","乙", 1.14),
  yin_yue_chen_yi("寅月","辰","乙", 0.342),
  yin_yue_chen_gui("寅月","辰","癸", 0.2),
  yin_yue_chen_wu("寅月","辰","戊", 0.53),
  yin_yue_si_geng("寅月","巳","庚", 0.3),
  yin_yue_si_bing("寅月","巳","丙", 0.84),
  yin_yue_wu_ding("寅月","午","丁", 1.2),
  yin_yue_wei_ding("寅月","未","丁", 0.36),
  yin_yue_wei_yi("寅月","未","乙", 0.228),
  yin_yue_wei_ji("寅月","未","己", 0.53),
  yin_yue_shen_ren("寅月","申","壬", 0.3),
  yin_yue_shen_geng("寅月","申","庚", 0.7),
  yin_yue_you_xin("寅月","酉","辛", 1.0),
  yin_yue_xu_xin("寅月","戌","辛", 0.3),
  yin_yue_xu_ding("寅月","戌","丁", 0.24),
  yin_yue_xu_wu("寅月","戌","戊", 0.53),
  yin_yue_hai_jia("寅月","亥","甲", 0.342),
  yin_yue_hai_ren("寅月","亥","壬", 0.7),


  mao_yue_zi_gui("卯月","子","癸",  1.0),
  mao_yue_chou_gui("卯月","丑","癸", 0.3),
  mao_yue_chou_xin("卯月","丑","辛", 0.2),
  mao_yue_chou_ji("卯月","丑","己", 0.5),
  mao_yue_yin_bing("卯月","寅","丙", 0.36),
  mao_yue_yin_jia("卯月","寅","甲", 0.84),
  mao_yue_mao_yi("卯月","卯","乙", 1.2),
  mao_yue_chen_yi("卯月","辰","乙", 0.36),
  mao_yue_chen_gui("卯月","辰","癸", 0.2),
  mao_yue_chen_wu("卯月","辰","戊", 0.5),
  mao_yue_si_geng("卯月","巳","庚", 0.3),
  mao_yue_si_bing("卯月","巳","丙", 0.84),
  mao_yue_wu_ding("卯月","午","丁", 1.2),
  mao_yue_wei_ding("卯月","未","丁", 0.36),
  mao_yue_wei_yi("卯月","未","乙", 0.24),
  mao_yue_wei_ji("卯月","未","己", 0.5),
  mao_yue_shen_ren("卯月","申","壬", 0.3),
  mao_yue_shen_geng("卯月","申","庚", 0.7),
  mao_yue_you_xin("卯月","酉","辛", 1.0),
  mao_yue_xu_xin("卯月","戌","辛", 0.3),
  mao_yue_xu_ding("卯月","戌","丁", 0.24),
  mao_yue_xu_wu("卯月","戌","戊", 0.5),
  mao_yue_hai_jia("卯月","亥","甲", 0.36),
  mao_yue_hai_ren("卯月","亥","壬", 0.7),


  chen_yue_zi_gui("辰月","子","癸",  1.04),
  chen_yue_chou_gui("辰月","丑","癸", 0.312),
  chen_yue_chou_xin("辰月","丑","辛", 0.23),
  chen_yue_chou_ji("辰月","丑","己", 0.55),
  chen_yue_yin_bing("辰月","寅","丙", 0.318),
  chen_yue_yin_jia("辰月","寅","甲", 0.77),
  chen_yue_mao_yi("辰月","卯","乙", 1.1),
  chen_yue_chen_yi("辰月","辰","乙", 0.33),
  chen_yue_chen_gui("辰月","辰","癸", 0.208),
  chen_yue_chen_wu("辰月","辰","戊", 0.55),
  chen_yue_si_geng("辰月","巳","庚", 0.33),
  chen_yue_si_bing("辰月","巳","丙", 0.742),
  chen_yue_wu_ding("辰月","午","丁", 1.06),
  chen_yue_wei_ding("辰月","未","丁", 0.318),
  chen_yue_wei_yi("辰月","未","乙", 0.22),
  chen_yue_wei_ji("辰月","未","己", 0.55),
  chen_yue_shen_ren("辰月","申","壬", 0.312),
  chen_yue_shen_geng("辰月","申","庚", 0.77),
  chen_yue_you_xin("辰月","酉","辛", 1.1),
  chen_yue_xu_xin("辰月","戌","辛", 0.33),
  chen_yue_xu_ding("辰月","戌","丁", 0.212),
  chen_yue_xu_wu("辰月","戌","戊", 0.55),
  chen_yue_hai_jia("辰月","亥","甲", 0.33),
  chen_yue_hai_ren("辰月","亥","壬", 0.728),


  si_yue_zi_gui("巳月","子","癸",  1.06),
  si_yue_chou_gui("巳月","丑","癸", 0.318),
  si_yue_chou_xin("巳月","丑","辛", 0.212),
  si_yue_chou_ji("巳月","丑","己", 0.57),
  si_yue_yin_bing("巳月","寅","丙", 0.342),
  si_yue_yin_jia("巳月","寅","甲", 0.7),
  si_yue_mao_yi("巳月","卯","乙", 1.0),
  si_yue_chen_yi("巳月","辰","乙", 0.3),
  si_yue_chen_gui("巳月","辰","癸", 0.2),
  si_yue_chen_wu("巳月","辰","戊", 0.6),
  si_yue_si_geng("巳月","巳","庚", 0.3),
  si_yue_si_bing("巳月","巳","丙", 0.84),
  si_yue_wu_ding("巳月","午","丁", 1.14),
  si_yue_wei_ding("巳月","未","丁", 0.342),
  si_yue_wei_yi("巳月","未","乙", 0.22),
  si_yue_wei_ji("巳月","未","己", 0.57),
  si_yue_shen_ren("巳月","申","壬", 0.318),
  si_yue_shen_geng("巳月","申","庚", 0.742),
  si_yue_you_xin("巳月","酉","辛", 1.06),
  si_yue_xu_xin("巳月","戌","辛", 0.318),
  si_yue_xu_ding("巳月","戌","丁", 0.228),
  si_yue_xu_wu("巳月","戌","戊", 0.57),
  si_yue_hai_jia("巳月","亥","甲", 0.3),
  si_yue_hai_ren("巳月","亥","壬", 0.742),


  wu_yue_zi_gui("午月","子","癸",  1.0),
  wu_yue_chou_gui("午月","丑","癸", 0.3),
  wu_yue_chou_xin("午月","丑","辛", 0.2),
  wu_yue_chou_ji("午月","丑","己", 0.6),
  wu_yue_yin_bing("午月","寅","丙", 0.36),
  wu_yue_yin_jia("午月","寅","甲", 0.7),
  wu_yue_mao_yi("午月","卯","乙", 1.0),
  wu_yue_chen_yi("午月","辰","乙", 0.3),
  wu_yue_chen_gui("午月","辰","癸", 0.2),
  wu_yue_chen_wu("午月","辰","戊", 0.6),
  wu_yue_si_geng("午月","巳","庚", 0.3),
  wu_yue_si_bing("午月","巳","丙", 0.84),
  wu_yue_wu_ding("午月","午","丁", 1.2),
  wu_yue_wei_ding("午月","未","丁", 0.36),
  wu_yue_wei_yi("午月","未","乙", 0.2),
  wu_yue_wei_ji("午月","未","己", 0.6),
  wu_yue_shen_ren("午月","申","壬", 0.3),
  wu_yue_shen_geng("午月","申","庚", 0.7),
  wu_yue_you_xin("午月","酉","辛", 1.0),
  wu_yue_xu_xin("午月","戌","辛", 0.3),
  wu_yue_xu_ding("午月","戌","丁", 0.24),
  wu_yue_xu_wu("午月","戌","戊", 0.6),
  wu_yue_hai_jia("午月","亥","甲", 0.3),
  wu_yue_hai_ren("午月","亥","壬", 0.7),


  wei_yue_zi_gui("未月","子","癸",  1.0),
  wei_yue_chou_gui("未月","丑","癸", 0.3),
  wei_yue_chou_xin("未月","丑","辛", 0.22),
  wei_yue_chou_ji("未月","丑","己", 0.58),
  wei_yue_yin_bing("未月","寅","丙", 0.33),
  wei_yue_yin_jia("未月","寅","甲", 0.728),
  wei_yue_mao_yi("未月","卯","乙", 1.04),
  wei_yue_chen_yi("未月","辰","乙", 0.312),
  wei_yue_chen_gui("未月","辰","癸", 0.2),
  wei_yue_chen_wu("未月","辰","戊", 0.58),
  wei_yue_si_geng("未月","巳","庚", 0.33),
  wei_yue_si_bing("未月","巳","丙", 0.798),
  wei_yue_wu_ding("未月","午","丁", 1.1),
  wei_yue_wei_ding("未月","未","丁", 0.33),
  wei_yue_wei_yi("未月","未","乙", 0.208),
  wei_yue_wei_ji("未月","未","己", 0.58),
  wei_yue_shen_ren("未月","申","壬", 0.3),
  wei_yue_shen_geng("未月","申","庚", 0.77),
  wei_yue_you_xin("未月","酉","辛", 1.1),
  wei_yue_xu_xin("未月","戌","辛", 0.33),
  wei_yue_xu_ding("未月","戌","丁", 0.22),
  wei_yue_xu_wu("未月","戌","戊", 0.58),
  wei_yue_hai_jia("未月","亥","甲", 0.312),
  wei_yue_hai_ren("未月","亥","壬", 0.7),


  shen_yue_zi_gui("申月","子","癸",  1.2),
  shen_yue_chou_gui("申月","丑","癸", 0.36),
  shen_yue_chou_xin("申月","丑","辛", 0.228),
  shen_yue_chou_ji("申月","丑","己", 0.5),
  shen_yue_yin_bing("申月","寅","丙", 0.3),
  shen_yue_yin_jia("申月","寅","甲", 0.742),
  shen_yue_mao_yi("申月","卯","乙", 1.06),
  shen_yue_chen_yi("申月","辰","乙", 0.318),
  shen_yue_chen_gui("申月","辰","癸", 0.24),
  shen_yue_chen_wu("申月","辰","戊", 0.5),
  shen_yue_si_geng("申月","巳","庚", 0.342),
  shen_yue_si_bing("申月","巳","丙", 0.7),
  shen_yue_wu_ding("申月","午","丁", 1.0),
  shen_yue_wei_ding("申月","未","丁", 0.3),
  shen_yue_wei_yi("申月","未","乙", 0.212),
  shen_yue_wei_ji("申月","未","己", 0.5),
  shen_yue_shen_ren("申月","申","壬", 0.36),
  shen_yue_shen_geng("申月","申","庚", 0.798),
  shen_yue_you_xin("申月","酉","辛", 1.14),
  shen_yue_xu_xin("申月","戌","辛", 0.342),
  shen_yue_xu_ding("申月","戌","丁", 0.2),
  shen_yue_xu_wu("申月","戌","戊", 0.5),
  shen_yue_hai_jia("申月","亥","甲", 0.318),
  shen_yue_hai_ren("申月","亥","壬", 0.84),


  you_yue_zi_gui("酉月","子","癸",  1.2),
  you_yue_chou_gui("酉月","丑","癸", 0.36),
  you_yue_chou_xin("酉月","丑","辛", 0.248),
  you_yue_chou_ji("酉月","丑","己", 0.5),
  you_yue_yin_bing("酉月","寅","丙", 0.3),
  you_yue_yin_jia("酉月","寅","甲", 0.7),
  you_yue_mao_yi("酉月","卯","乙", 1.0),
  you_yue_chen_yi("酉月","辰","乙", 0.3),
  you_yue_chen_gui("酉月","辰","癸", 0.24),
  you_yue_chen_wu("酉月","辰","戊", 0.5),
  you_yue_si_geng("酉月","巳","庚", 0.36),
  you_yue_si_bing("酉月","巳","丙", 0.7),
  you_yue_wu_ding("酉月","午","丁", 1.0),
  you_yue_wei_ding("酉月","未","丁", 0.3),
  you_yue_wei_yi("酉月","未","乙", 0.2),
  you_yue_wei_ji("酉月","未","己", 0.5),
  you_yue_shen_ren("酉月","申","壬", 0.36),
  you_yue_shen_geng("酉月","申","庚", 0.84),
  you_yue_you_xin("酉月","酉","辛", 1.2),
  you_yue_xu_xin("酉月","戌","辛", 0.36),
  you_yue_xu_ding("酉月","戌","丁", 0.2),
  you_yue_xu_wu("酉月","戌","戊", 0.5),
  you_yue_hai_jia("酉月","亥","甲", 0.3),
  you_yue_hai_ren("酉月","亥","壬", 0.84),


  xu_yue_zi_gui("戌月","子","癸",  1.06),
  xu_yue_chou_gui("戌月","丑","癸", 0.318),
  xu_yue_chou_xin("戌月","丑","辛", 0.232),
  xu_yue_chou_ji("戌月","丑","己", 0.57),
  xu_yue_yin_bing("戌月","寅","丙", 0.342),
  xu_yue_yin_jia("戌月","寅","甲", 0.7),
  xu_yue_mao_yi("戌月","卯","乙", 1.0),
  xu_yue_chen_yi("戌月","辰","乙", 0.3),
  xu_yue_chen_gui("戌月","辰","癸", 0.212),
  xu_yue_chen_wu("戌月","辰","戊", 0.57),
  xu_yue_si_geng("戌月","巳","庚", 0.348),
  xu_yue_si_bing("戌月","巳","丙", 0.728),
  xu_yue_wu_ding("戌月","午","丁", 1.04),
  xu_yue_wei_ding("戌月","未","丁", 0.312),
  xu_yue_wei_yi("戌月","未","乙", 0.2),
  xu_yue_wei_ji("戌月","未","己", 0.57),
  xu_yue_shen_ren("戌月","申","壬", 0.318),
  xu_yue_shen_geng("戌月","申","庚", 0.812),
  xu_yue_you_xin("戌月","酉","辛", 1.16),
  xu_yue_xu_xin("戌月","戌","辛", 0.348),
  xu_yue_xu_ding("戌月","戌","丁", 0.208),
  xu_yue_xu_wu("戌月","戌","戊", 0.57),
  xu_yue_hai_jia("戌月","亥","甲", 0.3),
  xu_yue_hai_ren("戌月","亥","壬", 0.724),


  hai_yue_zi_gui("亥月","子","癸",  1.14),
  hai_yue_chou_gui("亥月","丑","癸", 0.342),
  hai_yue_chou_xin("亥月","丑","辛", 0.2),
  hai_yue_chou_ji("亥月","丑","己", 0.5),
  hai_yue_yin_bing("亥月","寅","丙", 0.318),
  hai_yue_yin_jia("亥月","寅","甲", 0.84),
  hai_yue_mao_yi("亥月","卯","乙", 1.2),
  hai_yue_chen_yi("亥月","辰","乙", 0.36),
  hai_yue_chen_gui("亥月","辰","癸", 0.228),
  hai_yue_chen_wu("亥月","辰","戊", 0.5),
  hai_yue_si_geng("亥月","巳","庚", 0.3),
  hai_yue_si_bing("亥月","巳","丙", 0.742),
  hai_yue_wu_ding("亥月","午","丁", 1.06),
  hai_yue_wei_ding("亥月","未","丁", 0.318),
  hai_yue_wei_yi("亥月","未","乙", 0.24),
  hai_yue_wei_ji("亥月","未","己", 0.5),
  hai_yue_shen_ren("亥月","申","壬", 0.342),
  hai_yue_shen_geng("亥月","申","庚", 0.7),
  hai_yue_you_xin("亥月","酉","辛", 1.0),
  hai_yue_xu_xin("亥月","戌","辛", 0.3),
  hai_yue_xu_ding("亥月","戌","丁", 0.212),
  hai_yue_xu_wu("亥月","戌","戊", 0.5),
  hai_yue_hai_jia("亥月","亥","甲", 0.36),
  hai_yue_hai_ren("亥月","亥","壬", 0.798),
  ;
  private String monthName;
  private String earthName;
  private String hiddenHeavenName;
  private Double value;

  private EarthTableEnum(String monthName, String earthName, String hiddenHeavenName, Double value) {
    this.monthName = monthName;
    this.earthName = earthName;
    this.hiddenHeavenName = hiddenHeavenName;
    this.value = value;
  }

  public static List<String> getHiddenHeavenNames(String monthName, String earthName) {
    List<String> result = new ArrayList<>();
    for(EarthTableEnum value : EarthTableEnum.values()) {
      if(value.monthName.contains(monthName) && value.earthName.equals(earthName)) {
        result.add(value.hiddenHeavenName);
      }
    }
    return result;
  }


  public static Double getValue(String monthName, String earthName, String hiddenHeavenName) {
    for(EarthTableEnum value : EarthTableEnum.values()) {
      if(value.monthName.contains(monthName)
          && value.earthName.equals(earthName)
          && value.hiddenHeavenName.equals(hiddenHeavenName)) {
        return value.value;
      }
    }
    throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER,
        "can't get value by monthName:"+monthName+" earthName:"+earthName+" hiddenHeavenName:"+hiddenHeavenName);
  }


  public String getMonthName() {
    return monthName;
  }

  public String getEarthName() {
    return earthName;
  }

  public String getHiddenHeavenName() {
    return hiddenHeavenName;
  }

  public Double getValue() {
    return value;
  }
}
