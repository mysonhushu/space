package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.GenericMapper;
import com.huyouxiao.space.dao.entity.UserIdentityEntity;
import org.apache.ibatis.annotations.Param;

public interface UserIdentityEntityMapper extends GenericMapper<UserIdentityEntity, Long> {
  UserIdentityEntity selectByValue(@Param("identityType") String identityType, @Param("identityValue") String identityValue);
}