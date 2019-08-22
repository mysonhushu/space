package com.huyouxiao.space.common.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

  public static String getTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    return year + "年" + month + "月" + day + "日";
  }

  public static Integer getByField(Date date, int field) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(field);
  }

}
