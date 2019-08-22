package com.huyouxiao.space.model.poetry.enums;


public enum SensitiveTypeEnum {
  POSITIVE(1,"POSITIVE"),
  NEGATIVE(-1,"NEGATIVE");
  private int value;

  private String code;

  private SensitiveTypeEnum(int value, String code) {
    this.value = value;
    this.code = code;
  }
  public static SensitiveTypeEnum getByCode(String param) {
    String code = param.toUpperCase();
    for(SensitiveTypeEnum item : SensitiveTypeEnum.values()) {
      if(item.code.equals(code)) {
        return item;
      }
    }
    return null;
  }

  public int getValue() {
    return value;
  }

  public String getCode() {
    return code;
  }
}
