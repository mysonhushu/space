package com.huyouxiao.space.zhouyi.enums;

import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;

/**
 * 甲 乙 丙 丁 戊 己 庚 辛 壬 癸
 * 天干强度：即八字中的4个天干，若其五行属性恰好是这一行，那么就有相应的贡献值，可查表如下：
 */
public enum HeavenTableEnum {

  jia_zi_yue("甲", "子月", 1.2),
  yi_zi_yue("乙", "子月", 1.2),
  bing_zi_yue("丙", "子月", 1.0),
  ding_zi_yue("丁", "子月", 1.0),
  wu_zi_yue("戊", "子月", 1.0),
  ji_zi_yue("己", "子月", 1.0),
  geng_zi_yue("庚", "子月", 1.0),
  xin_zi_yue("辛", "子月", 1.0),
  ren_zi_yue("壬", "子月", 1.2),
  gui_zi_yue("癸", "子月", 1.2),

  jia_chou_yue("甲", "丑月", 1.01),
  yi_chou_yue("乙", "丑月", 1.06),
  bing_chou_yue("丙", "丑月", 1.0),
  ding_chou_yue("丁", "丑月", 1.0),
  wu_chou_yue("戊", "丑月", 1.1),
  ji_chou_yue("己", "丑月", 1.1),
  geng_chou_yue("庚", "丑月", 1.14),
  xin_chou_yue("辛", "丑月", 1.14),
  ren_chou_yue("壬", "丑月", 1.1),
  gui_chou_yue("癸", "丑月", 1.1),

  jia_yin_yue("甲", "寅月", 1.14),
  yi_yin_yue("乙", "寅月", 1.14),
  bing_yin_yue("丙", "寅月", 1.2),
  ding_yin_yue("丁", "寅月", 1.2),
  wu_yin_yue("戊", "寅月", 1.06),
  ji_yin_yue("己", "寅月", 1.06),
  geng_yin_yue("庚", "寅月", 1.0),
  xin_yin_yue("辛", "寅月", 1.0),
  ren_yin_yue("壬", "寅月", 1.0),
  gui_yin_yue("癸", "寅月", 1.0),

  jia_mao_yue("甲", "卯月", 1.2),
  yi_mao_yue("乙", "卯月", 1.2),
  bing_mao_yue("丙", "卯月", 1.2),
  ding_mao_yue("丁", "卯月", 1.2),
  wu_mao_yue("戊", "卯月", 1.0),
  ji_mao_yue("己", "卯月", 1.0),
  geng_mao_yue("庚", "卯月", 1.0),
  xin_mao_yue("辛", "卯月", 1.0),
  ren_mao_yue("壬", "卯月", 1.0),
  gui_mao_yue("癸", "卯月", 1.0),

  jia_chen_yue("甲", "辰月", 1.1),
  yi_chen_yue("乙", "辰月", 1.1),
  bing_chen_yue("丙", "辰月", 1.06),
  ding_chen_yue("丁", "辰月", 1.06),
  wu_chen_yue("戊", "辰月", 1.1),
  ji_chen_yue("己", "辰月", 1.1),
  geng_chen_yue("庚", "辰月", 1.1),
  xin_chen_yue("辛", "辰月", 1.1),
  ren_chen_yue("壬", "辰月", 1.04),
  gui_chen_yue("癸", "辰月", 1.04),

  jia_si_yue("甲", "巳月", 1.0),
  yi_si_yue("乙", "巳月", 1.0),
  bing_si_yue("丙", "巳月", 1.14),
  ding_si_yue("丁", "巳月", 1.14),
  wu_si_yue("戊", "巳月", 1.14),
  ji_si_yue("己", "巳月", 1.14),
  geng_si_yue("庚", "巳月", 1.06),
  xin_si_yue("辛", "巳月", 1.06),
  ren_si_yue("壬", "巳月", 1.06),
  gui_si_yue("癸", "巳月", 1.06),


  jia_wu_yue("甲", "午月", 1.0),
  yi_wu_yue("乙", "午月", 1.0),
  bing_wu_yue("丙", "午月", 1.2),
  ding_wu_yue("丁", "午月", 1.2),
  wu_wu_yue("戊", "午月", 1.2),
  ji_wu_yue("己", "午月", 1.2),
  geng_wu_yue("庚", "午月", 1.0),
  xin_wu_yue("辛", "午月", 1.0),
  ren_wu_yue("壬", "午月", 1.0),
  gui_wu_yue("癸", "午月", 1.0),

  jia_wei_yue("甲", "未月", 1.04),
  yi_wei_yue("乙", "未月", 1.04),
  bing_wei_yue("丙", "未月", 1.1),
  ding_wei_yue("丁", "未月", 1.1),
  wu_wei_yue("戊", "未月", 1.16),
  ji_wei_yue("己", "未月", 1.16),
  geng_wei_yue("庚", "未月", 1.1),
  xin_wei_yue("辛", "未月", 1.1),
  ren_wei_yue("壬", "未月", 1.0),
  gui_wei_yue("癸", "未月", 1.0),

  jia_shen_yue("甲", "申月", 1.06),
  yi_shen_yue("乙", "申月", 1.06),
  bing_shen_yue("丙", "申月", 1.0),
  ding_shen_yue("丁", "申月", 1.0),
  wu_shen_yue("戊", "申月", 1.0),
  ji_shen_yue("己", "申月", 1.0),
  geng_shen_yue("庚", "申月", 1.14),
  xin_shen_yue("辛", "申月", 1.14),
  ren_shen_yue("壬", "申月", 1.2),
  gui_shen_yue("癸", "申月", 1.2),


  jia_you_yue("甲", "酉月", 1.0),
  yi_you_yue("乙", "酉月", 1.0),
  bing_you_yue("丙", "酉月", 1.0),
  ding_you_yue("丁", "酉月", 1.0),
  wu_you_yue("戊", "酉月", 1.0),
  ji_you_yue("己", "酉月", 1.0),
  geng_you_yue("庚", "酉月", 1.2),
  xin_you_yue("辛", "酉月", 1.2),
  ren_you_yue("壬", "酉月", 1.2),
  gui_you_yue("癸", "酉月", 1.2),


  jia_xu_yue("甲", "戌月", 1.0),
  yi_xu_yue("乙", "戌月", 1.0),
  bing_xu_yue("丙", "戌月", 1.04),
  ding_xu_yue("丁", "戌月", 1.04),
  wu_xu_yue("戊", "戌月", 1.14),
  ji_xu_yue("己", "戌月", 1.14),
  geng_xu_yue("庚", "戌月", 1.16),
  xin_xu_yue("辛", "戌月", 1.16),
  ren_xu_yue("壬", "戌月", 1.06),
  gui_xu_yue("癸", "戌月", 1.06),

  jia_hai_yue("甲", "亥月", 1.2),
  yi_hai_yue("乙", "亥月", 1.2),
  bing_hai_yue("丙", "亥月", 1.0),
  ding_hai_yue("丁", "亥月", 1.0),
  wu_hai_yue("戊", "亥月", 1.0),
  ji_hai_yue("己", "亥月", 1.0),
  geng_hai_yue("庚", "亥月", 1.0),
  xin_hai_yue("辛", "亥月", 1.0),
  ren_hai_yue("壬", "亥月", 1.14),
  gui_hai_yue("癸", "亥月", 1.14),
  ;
  private String heavenName;
  private String monthName;
  private Double value;

  private HeavenTableEnum(String heavenName, String monthName, Double value) {
    this.heavenName = heavenName;
    this.monthName = monthName;
    this.value = value;
  }

  public String getHeavenName() {
    return heavenName;
  }

  public String getMonthName() {
    return monthName;
  }

  public Double getValue() {
    return value;
  }

  public static Double getValue(String heavenName, String monthName) {
    for(HeavenTableEnum value : HeavenTableEnum.values()) {
      if(value.heavenName.equals(heavenName) && value.monthName.contains(monthName)) {
        return value.getValue();
      }
    }
    throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER,
        "can't find value by heavenName:"+heavenName+" and monthName:"+monthName);
  }
}
