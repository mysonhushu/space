package com.huyouxiao.space.common.enums;

public enum CredentialTypeEnum {
  PASSWORD("PASSWORD", "user password"),
  ONE_TIME_PASSWORD("ONE_TIME_PASSWORD", "one time password"),
  ACTIVE_CODE("ACTIVE_CODE", "mail active code"),
  AUTHORIZATION_CODE("AUTHORIZATION_CODE", "authorization code"),
  ACCESS_TOKEN("ACCESS_TOKEN", "access token"),
  REFRESH_TOKEN("REFRESH_TOKEN", "refresh token");
  private String code;
  private String name;
  private CredentialTypeEnum(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
