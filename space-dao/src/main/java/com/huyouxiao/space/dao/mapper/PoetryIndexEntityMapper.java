package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.PoetryIndexEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoetryIndexEntityMapper extends GenericMapper<PoetryIndexEntity, Long> {
  void batchInsert(@Param("list") List<PoetryIndexEntity> list);
  List<PoetryIndexEntity> selectByWordsLetter(@Param("wordsLetter") String word, @Param("wantField") String wantField);
}