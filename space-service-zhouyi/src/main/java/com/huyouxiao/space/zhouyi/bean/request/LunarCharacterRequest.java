package com.huyouxiao.space.zhouyi.bean.request;

import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import lombok.Data;

import java.util.Date;

@Data
public class LunarCharacterRequest {
  private Date birthday;

  public void check() {
    if (null == birthday) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "birthday can't be null.");
    }
  }
}
