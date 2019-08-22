package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.WordFrequencyEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordFrequencyEntityMapper  extends GenericMapper<WordFrequencyEntity, Long> {
  void batchInsert(@Param("list") List<WordFrequencyEntity> list);
  List<WordFrequencyEntity> selectByWord(@Param("word") String word);
}