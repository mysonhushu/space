package com.huyouxiao.space.dao.mapper;

import com.huyouxiao.space.dao.GenericMapper;
import com.huyouxiao.space.dao.entity.UserCredentialEntity;
import org.apache.ibatis.annotations.Param;

public interface UserCredentialEntityMapper extends GenericMapper<UserCredentialEntity, Long> {
  UserCredentialEntity selectByType(@Param("credentialType") String credentialType, @Param("userId") Long userId);

  void obsoleteCredentialByType(@Param("userId") Long userId, @Param("credentialType") String credentialType);
}