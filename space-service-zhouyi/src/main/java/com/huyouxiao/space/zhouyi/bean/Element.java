package com.huyouxiao.space.zhouyi.bean;

import com.huyouxiao.space.zhouyi.enums.EarthEnum;
import com.huyouxiao.space.zhouyi.enums.EarthTableEnum;
import com.huyouxiao.space.zhouyi.enums.HeavenEnum;
import com.huyouxiao.space.zhouyi.enums.HeavenTableEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Element {
  private String position;
  private String name;
  private String element;
  private BigDecimal value;
  private String hiddenName;

  public static List<Element> generate(String bazhi){
    List<Element> response = new ArrayList<>();
    if (null == bazhi) {
      return response;
    }

    String[] names = {"年干","年支","月干","月支","日干","日支","时干","时支"};
    String monthName = bazhi.substring(3,4);
    for (int i=0; i<bazhi.length(); i++) {
      // use gan table
      if(i%2 == 0) {
        Element element = new Element();
        element.position = names[i];
        element.name = String.valueOf(bazhi.charAt(i));
        element.element =  HeavenEnum.getByName(element.name).getElement().getName();
        element.value = BigDecimal.valueOf(HeavenTableEnum.getValue(element.name, monthName));
        response.add(element);
      } else { //use month table
        List<String> hiddenNames = EarthTableEnum.getHiddenHeavenNames(monthName, String.valueOf(bazhi.charAt(i)));
        for(String name : hiddenNames) {
          Element element = new Element();
          element.position = names[i];
          element.name = String.valueOf(bazhi.charAt(i));
          element.element =  EarthEnum.getByName(element.name).getElement().getName();
          // getValue(String monthName, String earthName, String hiddenHeavenName)
          element.value = BigDecimal.valueOf(EarthTableEnum.getValue(monthName, element.name, name));
          element.hiddenName = element.name+element.position+"藏"+name;
          response.add(element);
        }
      }
    }
    return response;
  }
}
