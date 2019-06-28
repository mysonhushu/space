package com.huyouxiao.space.web.controller;


import com.huyouxiao.space.iam.UserService;
import com.huyouxiao.space.iam.request.SignUpRequest;
import com.huyouxiao.space.iam.response.SignUpResponse;
import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {

  @Autowired
  private UserService userService;

  @EscapeSessionCheck
  @RequestMapping(value={"/web/account/sign-up", "/app/account/sign-up"}, method = RequestMethod.POST)
  @ApiOperation(value = "signUp", response = ApiResult.class)
  public ApiResult<SignUpResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
    signUpRequest.check();

    userService.signUp(signUpRequest);
    return ApiResult.success();
  }


  @EscapeSessionCheck
  @RequestMapping(value = "/web/account/email/retrieve", method = RequestMethod.GET)
  public ApiResult<String> retrieveMail(@RequestParam(value="email") String mail) {
    log.info("call retrieveMail with mail:{}", mail);
    //TODO: huxing.
    return ApiResult.success("working continue ...");
  }
}
