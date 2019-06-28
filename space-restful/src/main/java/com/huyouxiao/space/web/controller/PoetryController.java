package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.poetry.PoetryService;
import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class PoetryController {

  @Autowired
  private PoetryService poetryService;

  @EscapeSessionCheck
  @RequestMapping(value="/web/poetry", method = RequestMethod.GET)
  @ApiOperation(value = "getPoetry", response = ApiResult.class)
  public ApiResult<String> getPoetry(@RequestParam(value="name") String name) {
    log.info("call getPoetry with name:{}", name);

    BufferedReader bufferedReader = poetryService.getPoetry(name);

    ApiResult result = ApiResult.success();
    result.setContent(bufferedReader.lines().collect(Collectors.joining()));
    return result;
  }
}
