package com.huyouxiao.space.iam.request;

import com.huyouxiao.space.common.validate.AccountValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SignUpRequest {
  @ApiModelProperty("account phone")
  private String phone;
  @ApiModelProperty("account password")
  private String password;
  @ApiModelProperty("account email")
  private String email;


  public void check() {
    AccountValidator.validateMobile(phone);
    AccountValidator.validatePassword(password);
    AccountValidator.validateEmail(email);
  }

}
