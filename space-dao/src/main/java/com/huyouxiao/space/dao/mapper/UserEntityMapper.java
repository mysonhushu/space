package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

public interface UserEntityMapper extends GenericMapper<UserEntity, Long> {
  UserEntity selectByUserPhone(@Param("phone") String phone);
}