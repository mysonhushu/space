package com.huyouxiao.space.web.api;


import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;


public class ApiResult<T> {
  private T content;
  private String result;
  private List<String> messages;
  private List<String> errors;

  public static ApiResult success() {
    ApiResult<Object> success = new ApiResult<>();
    success.setResult(ResultEnum.SUCCESS.getCode());
    return success;
  }


  public static ApiResult success(String message) {
    ApiResult<Object> success = new ApiResult<>();
    success.setResult(ResultEnum.SUCCESS.getCode());
    success.messages = new ArrayList<>();
    success.messages.add(message);
    return success;
  }

  public static ApiResult exception(BusinessException exception) {
    ApiResult<Object> result = new ApiResult<>();
    result.setResult(exception.getError().getCode());
    result.addMessage(exception.getError().getMessage());
    return result;
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors)
  {
    this.errors = errors;
  }

  public void addMessage(String message) {
    if(null == messages) {
      messages = new ArrayList<>();
    }
    messages.add(message);
  }


  public void addError(String error) {
    if(null == errors) {
      errors = new ArrayList<>();
    }
    errors.add(error);
  }
}
