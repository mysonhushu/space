package com.huyouxiao.space.common.exception;

import com.huyouxiao.space.common.enums.ResultEnum;

import java.util.List;

public class BusinessException extends RuntimeException {
  private ResultEnum error;
  private List<String> parameters;

  public BusinessException(ResultEnum error) {
    this.error = error;
  }

  public BusinessException(ResultEnum error, List<String> parameters) {
    this.error = error;
    this.parameters = parameters;
  }

  public BusinessException(String message, ResultEnum error, List<String> parameters) {
    super(message);
    this.error = error;
    this.parameters = parameters;
  }

  public BusinessException(String message, Throwable cause, ResultEnum error, List<String> parameters) {
    super(message, cause);
    this.error = error;
    this.parameters = parameters;
  }

  public BusinessException(Throwable cause, ResultEnum error, List<String> parameters) {
    super(cause);
    this.error = error;
    this.parameters = parameters;
  }

  public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResultEnum error, List<String> parameters) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.error = error;
    this.parameters = parameters;
  }

  public ResultEnum getError() {
    return error;
  }

  public void setError(ResultEnum error) {
    this.error = error;
  }

  public List<String> getParameters() {
    return parameters;
  }

  public void setParameters(List<String> parameters) {
    this.parameters = parameters;
  }
}