package com.huyouxiao.space.common.validate;

import com.google.common.base.Strings;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;

import java.util.regex.Pattern;

public class AccountValidator {
  public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,20}$";

  public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

  public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

  public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

  public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

  public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

  public static void validateUsername(String username) {
    boolean inValid = Strings.isNullOrEmpty(username) || !Pattern.matches(REGEX_USERNAME, username);
    if(inValid) {
      throw new BusinessException(ResultEnum.INVALID_USER_NAME);
    }
  }

  public static void validatePassword(String password) {
    boolean inValid = Strings.isNullOrEmpty(password) || !Pattern.matches(REGEX_PASSWORD, password);
    if(inValid) {
      throw new BusinessException(ResultEnum.INVALID_USER_PASSWORD);
    }
  }

  public static void validateMobile(String mobile) {
    boolean inValid = Strings.isNullOrEmpty(mobile) || !Pattern.matches(REGEX_MOBILE, mobile);
    if(inValid) {
      throw new BusinessException(ResultEnum.INVALID_USER_PHONE);
    }
  }

  public static void validateEmail(String email) {
    boolean inValid = Strings.isNullOrEmpty(email) || !Pattern.matches(REGEX_EMAIL, email);
    if(inValid) {
      throw new BusinessException(ResultEnum.INVALID_USER_EMAIL);
    }
  }

  public static boolean validateChinese(String chinese) {
    return Pattern.matches(REGEX_CHINESE, chinese);
  }

  public static boolean validateIDCard(String idCard) {
    return Pattern.matches(REGEX_ID_CARD, idCard);
  }
}