package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.WordEntity;
import org.apache.ibatis.annotations.Param;


public interface WordEntityMapper  extends GenericMapper<WordEntity, Long> {
  WordEntity selectByWord(@Param("word") String word, @Param("pinyinLetter") String pinyinLetter);

}