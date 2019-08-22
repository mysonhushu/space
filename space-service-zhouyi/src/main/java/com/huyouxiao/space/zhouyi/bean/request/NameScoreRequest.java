package com.huyouxiao.space.zhouyi.bean.request;

import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import lombok.Data;

@Data
public class NameScoreRequest {
  private String name;

  public void check() {
    if (name == null) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "required name parameter is null.");
    }
    if (name.length() > 4) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "required name parameter is too long for chinese name.");
    }
  }
}
