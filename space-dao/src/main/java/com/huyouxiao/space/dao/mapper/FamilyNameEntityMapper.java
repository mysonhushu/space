package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.FamilyNameEntity;
import org.apache.ibatis.annotations.Param;

public interface FamilyNameEntityMapper extends GenericMapper<FamilyNameEntity, Long> {
  FamilyNameEntity selectByFamilyName(@Param("familyName") String familyName);
}