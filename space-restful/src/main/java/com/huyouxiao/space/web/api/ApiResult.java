package com.huyouxiao.space.web.api;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
    return success(Maps.newHashMap());
  }

  public ApiResult(String result) {
    this.result = result;
    this.errors = Lists.newArrayList();
    this.messages = Lists.newArrayList();
  }

  public static ApiResult success(Object context) {
    return new ApiResult(ResultEnum.SUCCESS.getCode(), context);
  }

  public ApiResult(String result, T content) {
    this.result = result;
    this.content = content;
    this.errors = Lists.newArrayList();
    this.messages = Lists.newArrayList();
  }

  public ApiResult(String result, T content,  List<String> messages) {
    this.result = result;
    this.content = content;
    this.errors = messages;
  }

  public static ApiResult exception(BusinessException exception) {
    return new ApiResult<>(exception.getError().getCode(), exception.getError().getMessage(), exception.getParameters());
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
