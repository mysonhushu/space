package com.huyouxiao.space.poetry.bean.request;

import com.google.common.base.Strings;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import com.huyouxiao.space.poetry.enums.FrequencyLevel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Date;


@Data
public class GenerateNameRequest {
  @ApiModelProperty("pageNo")
  Integer pageNo;

  @ApiModelProperty("pageSize")
  Integer pageSize;

  @ApiModelProperty("family name")
  private String familyName;

  @ApiModelProperty("required pinyin abridge")
  private String pinyinAbridge;

  @ApiModelProperty("name length")
  private Integer nameLength;

  @ApiModelProperty("want field")
  private String wantField;

  @ApiModelProperty("frequency level")
  private FrequencyLevel frequencyLevel;

  @ApiModelProperty("birthday")
  private Date birthday;

  @ApiModelProperty("selectAll")
  private boolean paged = false;

  public void check() {
    if(null == pageNo || pageNo < 1) {
      pageNo = 1;
    }

    if(null == pageSize || pageSize>10) {
      pageSize = 10;
    }

    if(StringUtils.isEmpty(wantField)) {
      wantField = null;
    }
    if(StringUtils.isEmpty(pinyinAbridge)) {
      pinyinAbridge = null;
    }

    if(Strings.isNullOrEmpty(familyName)) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "familyName is null");
    }

    if(Strings.isNullOrEmpty(pinyinAbridge) && StringUtils.isEmpty(wantField)) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "pinyinAbridge and wantField is null");
    }

    if(!StringUtils.isEmpty(pinyinAbridge)) {
      char[] letters = pinyinAbridge.toCharArray();
      if(letters.length>4){
        throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "pinyinAbridge to long");
      }
      for(int i=0; i<letters.length; i++) {
        if(Character.isLetter(letters[i])) {
          continue;
        }
        throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "pinyinAbridge value is invalid");
      }
    }

    if(null != nameLength && (nameLength<2 || nameLength>5)) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "nameLength is limit between 2 and 5");
    }
  }

  public boolean isPaged() {
    return paged;
  }
}
