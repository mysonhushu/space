package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import com.huyouxiao.space.zhouyi.FortuneService;
import com.huyouxiao.space.zhouyi.bean.request.LunarCharacterRequest;
import com.huyouxiao.space.zhouyi.bean.request.NameScoreRequest;
import com.huyouxiao.space.zhouyi.bean.response.FortuneResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class FortuneController {

  @Autowired
  private FortuneService fortuneService;

  @EscapeSessionCheck
  @PostMapping("/web/fortune/character")
  @ApiOperation(value = "getCharacter", response = ApiResult.class)
  public ApiResult<FortuneResponse> getCharacter(@RequestBody LunarCharacterRequest request) {
    request.check();

    return ApiResult.success(fortuneService.getCharacter(request.getBirthday()));
  }


  @EscapeSessionCheck
  @PostMapping("/web/fortune/name-score")
  @ApiOperation(value = "getNameScore", response = ApiResult.class)
  public ResponseEntity<Resource> getNameScore(@RequestBody NameScoreRequest request)  {

    // Load file as Resource
    Resource resource =  fortuneService.getNameScorePdf(request.getName());

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }
}
