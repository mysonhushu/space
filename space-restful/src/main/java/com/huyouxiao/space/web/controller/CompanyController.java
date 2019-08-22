package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.web.api.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "company operate apis")
public class CompanyController {

  @RequestMapping(value="/web/company/create", method = RequestMethod.GET)
  @ApiOperation("create company")
  public ApiResult<Void> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    //TODO: huxing
    return ApiResult.success();
  }

}