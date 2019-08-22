package com.huyouxiao.space.common.security.bean;

import lombok.Data;

@Data
public class EncryptionResult {
  private String salt;
  private String output;

  public EncryptionResult(String salt, String output) {
    this.salt = salt;
    this.output = output;
  }
}
