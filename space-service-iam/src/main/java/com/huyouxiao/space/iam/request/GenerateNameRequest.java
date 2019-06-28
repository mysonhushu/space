package com.huyouxiao.space.iam.request;

import com.google.common.base.Strings;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GenerateNameRequest {
  @ApiModelProperty("family name")
  private String familyName;

  @ApiModelProperty("birthday")
  private Date birthday;

  @ApiModelProperty("required pinyin abridge")
  private String pinyinAbridge;

  @ApiModelProperty("name length")
  private int nameLength = 2;

  @ApiModelProperty("want field")
  private String wantField;

  public void check() {
    if(Strings.isNullOrEmpty(familyName)) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }

    if(Strings.isNullOrEmpty(pinyinAbridge)) {
      return;
    }

    char[] letters = pinyinAbridge.toCharArray();
    if(letters.length>4){
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
    for(int i=0; i<letters.length; i++) {
      if(Character.isLetter(letters[i])) {
        continue;
      }
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }

    if(nameLength<2 || nameLength>5) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
  }
}
