package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.model.poetry.Poetry;
import com.huyouxiao.space.poetry.PoetryService;
import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class PoetryController {

  @Autowired
  private PoetryService poetryService;

  @EscapeSessionCheck
  @RequestMapping(value="/web/poetry", method = RequestMethod.GET)
  @ApiOperation(value = "getPoetry", response = ApiResult.class)
  public ApiResult<Poetry> getPoetry(@RequestParam(value="name") String name) {
    log.info("call getPoetry with name:{}", name);

    return ApiResult.success(poetryService.getPoetry(name));
  }

  @EscapeSessionCheck
  @RequestMapping(value="/web/poetry/{id}", method = RequestMethod.GET)
  @ApiOperation(value = "getPoetryById", response = ApiResult.class)
  public ApiResult<Poetry> getPoetryById(@PathVariable(value="id") Long id) {
    log.info("call getPoetry with id:{}", id);

    return ApiResult.success(poetryService.getPoetry(id));
  }
}
