package com.huyouxiao.space.common.enums;

public enum DataStatusEnum {
  NORMAL("0","NORMAL"),
  DELETED("1","DELETED"),
  OBSOLETE("2","OBSOLETE");
  private String code;
  private String name;

  private DataStatusEnum(String code, String name) {
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
