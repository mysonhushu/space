package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.iam.request.GenerateNameRequest;
import com.huyouxiao.space.iam.response.SignUpResponse;
import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ChineseNameController {


  @EscapeSessionCheck
  @PostMapping(value={"/web/chinese/name/generate", "/app/chinese/name/generate"})
  @ApiOperation(value = "generate", response = ApiResult.class)
  public ApiResult<SignUpResponse> generate(@RequestBody GenerateNameRequest generateNameRequest) {
    generateNameRequest.check();

    return ApiResult.success();
  }
}
