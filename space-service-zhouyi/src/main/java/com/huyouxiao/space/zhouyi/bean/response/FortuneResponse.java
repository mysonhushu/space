package com.huyouxiao.space.zhouyi.bean.response;

import com.huyouxiao.space.zhouyi.bean.BoneWeight;
import com.huyouxiao.space.zhouyi.bean.Element;
import com.huyouxiao.space.zhouyi.enums.ConstellationEnum;
import com.huyouxiao.space.zhouyi.enums.FiveElementEnum;
import com.huyouxiao.space.zhouyi.enums.ZodiacYearEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FortuneResponse {
  private String character;
  private BigDecimal water = BigDecimal.valueOf(0L);
  private BigDecimal fire = BigDecimal.valueOf(0L);
  private BigDecimal wood = BigDecimal.valueOf(0L);
  private BigDecimal gold = BigDecimal.valueOf(0L);
  private BigDecimal earth = BigDecimal.valueOf(0L);
  private BigDecimal positive = BigDecimal.valueOf(0L);
  private BigDecimal negative = BigDecimal.valueOf(0L);
  private String description;
  List<Element> elements;
  private String yearName;
  private String zodiac;
  private String zodiacBuddha;
  private String god;
  private String godName;
  private String constellationName;
  private String constellationType;
  private String constellationElement;
  private String constellationLuckStar;
  private String constellationDescription;
  private String constellationSymbol;
  private String constellationCode;

  private BoneWeight boneWeight;
  private String lunarBirthday;
  private String solarBirthday;



  public void addScore(String name, BigDecimal value) {
    if ("金".equals(name)) {
      gold = gold.add(value);
    } else if ("火".equals(name)) {
      fire = fire.add(value);
    } else if ("木".equals(name)) {
      wood = wood.add(value);
    } else if ("水".equals(name)) {
      water = water.add(value);
    } else if("土".equals(name)) {
      earth = earth.add(value);
    }
  }


  public void calculate(String ganName, String relayName, String gan) {
    if ("金".equals(ganName) || "金".equals(relayName)) {
      positive = positive.add(gold);
    } else {
      negative = negative.add(gold);
    }

    if ("火".equals(ganName) || "火".equals(relayName)) {
      positive = positive.add(fire);
    } else {
      negative = negative.add(fire);
    }

    if ("木".equals(ganName) || "木".equals(relayName)) {
      positive = positive.add(wood);
    } else {
      negative = negative.add(wood);
    }

    if ("水".equals(ganName) || "水".equals(relayName)) {
      positive = positive.add(water);
    } else {
      negative = negative.add(water);
    }

    if ("土".equals(ganName) || "土".equals(relayName)) {
      positive = positive.add(earth);
    } else {
      negative = negative.add(earth);
    }

    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("日干为").append(gan).append(", 属").append(ganName).append(",故命属水\n");
    stringBuffer.append(" 同类数值:").append(positive.doubleValue()).append("\n");
    stringBuffer.append(" 异类数值:").append(negative.doubleValue()).append("\n");

    FiveElementEnum lifeGan = FiveElementEnum.getByName(ganName);
    if(positive.compareTo(negative) > 0) {
      // 日主强，以火为用神。宜补火。
      stringBuffer.append(" 日主强,以").append(lifeGan.getKill()).append("为用神.").append("宜补").append(lifeGan.getKill()).append("\n");
    } else {
      stringBuffer.append(" 日主弱,以").append(lifeGan.getProduce()).append("为用神.").append("宜补").append(lifeGan.getProduce()).append("\n");
    }
    description = stringBuffer.toString();
  }


  public void setZodiac(ZodiacYearEnum zodiac) {
    this.zodiac = zodiac.getZodiac();
    this.god = zodiac.getGod();
    this.yearName = zodiac.getYearName();
    this.godName = zodiac.getGodName();
  }

  public void setConstellation(ConstellationEnum constellation) {
    this.constellationName = constellation.getConstellation();
    this.constellationType = constellation.getType();
    this.constellationElement = constellation.getElement();
    this.constellationLuckStar = constellation.getLuckStar();
    this.constellationDescription = constellation.getDescription();
    this.constellationSymbol = constellation.getSymbol();
    this.constellationCode = constellation.getCode();
  }
}
