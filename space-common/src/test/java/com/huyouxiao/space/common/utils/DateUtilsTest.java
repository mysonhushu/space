package com.huyouxiao.space.common.utils;

import org.junit.Test;

import java.util.Date;

public class DateUtilsTest {
  @Test
  public void getTimeTest() {
    Date date = new Date();
    System.out.println(DateUtils.getTime(date));
  }
}
