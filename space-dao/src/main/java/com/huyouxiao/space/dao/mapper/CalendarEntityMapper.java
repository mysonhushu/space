package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.CalendarEntity;

public interface CalendarEntityMapper extends GenericMapper<CalendarEntity, Long> {
  CalendarEntity selectBySolarFull(String solarFull);
}