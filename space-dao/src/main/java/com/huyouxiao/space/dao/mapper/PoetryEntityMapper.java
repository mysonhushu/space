package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.PoetryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PoetryEntityMapper extends GenericMapper<PoetryEntity, Long> {
    PoetryEntity selectByName(@Param("name") String name);
    List<PoetryEntity> selectByPoetryIds(@Param("poetryIds") List<Long> poetryIds);
}