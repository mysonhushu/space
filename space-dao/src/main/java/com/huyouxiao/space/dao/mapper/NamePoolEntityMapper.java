package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.NamePoolEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NamePoolEntityMapper extends GenericMapper<NamePoolEntity, Long> {
  void batchInsert(@Param("list") List<NamePoolEntity> list);

  List<NamePoolEntity> selectNames(@Param("pinyinAbridge") String pinyinAbridge,
                                   @Param("nameLength") Integer nameLength,
                                   @Param("wantField") String wantField,
                                   @Param("frequencyStart") Integer frequencyStart,
                                   @Param("frequencyEnd") Integer frequencyEnd);

  Integer selectNamesCount(@Param("pinyinAbridge") String pinyinAbridge,
      @Param("nameLength") Integer nameLength,
      @Param("wantField") String wantField,
      @Param("frequencyStart") Integer frequencyStart,
      @Param("frequencyEnd") Integer frequencyEnd);
}