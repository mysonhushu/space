package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Param;

public interface DictionaryEntityMapper extends GenericMapper<DictionaryEntity, Long> {
  DictionaryEntity selectByWord(@Param("hashCode") String hashCode,  @Param("word") String word);
}
