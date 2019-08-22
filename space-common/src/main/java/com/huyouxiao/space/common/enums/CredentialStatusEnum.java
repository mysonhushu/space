package com.huyouxiao.space.common.enums;

public enum CredentialStatusEnum {
  PASSWORD_NOT_ACTIVE("PASSWORD_NOT_ACTIVE", CredentialTypeEnum.PASSWORD),
  PASSWORD_EXPIRED("PASSWORD_EXPIRED", CredentialTypeEnum.PASSWORD),
  PASSWORD_ACTIVE("PASSWORD_ACTIVE", CredentialTypeEnum.PASSWORD),
  ACTIVE_CODE_NOT_USED("ACTIVE_CODE_NOT_USED", CredentialTypeEnum.ACTIVE_CODE),
  ACTIVE_CODE_USED("ACTIVE_CODE_USED", CredentialTypeEnum.ACTIVE_CODE),
  OTP_NOT_USED("OTP_NOT_USED", CredentialTypeEnum.ONE_TIME_PASSWORD),
  OTP_USED("OPT_USED", CredentialTypeEnum.ONE_TIME_PASSWORD);

  private String status;
  private CredentialTypeEnum credentialType;

  CredentialStatusEnum(String status, CredentialTypeEnum credentialType) {
    this.status = status;
    this.credentialType = credentialType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CredentialTypeEnum getCredentialType() {
    return credentialType;
  }

  public void setCredentialType(CredentialTypeEnum credentialType) {
    this.credentialType = credentialType;
  }
}
