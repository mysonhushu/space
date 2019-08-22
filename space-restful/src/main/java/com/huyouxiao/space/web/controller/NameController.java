package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import com.huyouxiao.space.model.bookworm.IndexWords;
import com.huyouxiao.space.poetry.NameService;
import com.huyouxiao.space.poetry.bean.request.GenerateNameRequest;
import com.huyouxiao.space.poetry.bean.response.GenerateNameResponse;
import com.huyouxiao.space.poetry.bean.response.NameInstance;
import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import com.huyouxiao.space.zhouyi.FortuneService;
import com.huyouxiao.space.zhouyi.bean.request.NameScoreRequest;
import com.huyouxiao.space.zhouyi.bean.response.NameScoreResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


@RestController
@Slf4j
public class NameController {

  @Autowired
  private NameService nameService;

  @Autowired
  private FortuneService fortuneService;


  @EscapeSessionCheck
  @PostMapping("/web/name/generate")
  @ApiOperation(value = "generate", response = ApiResult.class)
  public ApiResult<GenerateNameResponse> generate(@RequestBody GenerateNameRequest request) {
    request.check();

    return ApiResult.success(nameService.generateName(request));
  }

  @EscapeSessionCheck
  @PostMapping("/web/name/download")
  @ApiOperation(value = "download", response = ApiResult.class)
  public ResponseEntity<Resource> download(@RequestBody GenerateNameRequest request) throws IOException {
    request.check();

    File file = nameService.downloadName(request);
    Path path = Paths.get(file.getAbsolutePath());
    ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
    return ResponseEntity.ok()
        .headers(headers)
        .contentLength(file.length())
        .contentType(MediaType.parseMediaType("application/octet-stream"))
        .body(resource);
  }


  @EscapeSessionCheck
  @RequestMapping(value = "/web/name/statistic", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
  @ApiOperation(value = "statisticName", response = ApiResult.class)
  public ApiResult<Map<String, IndexWords>> statistic(
      @ApiParam(value="file", required = true) @RequestParam(value="file") MultipartFile file) {
    if(null == file || file.isEmpty()) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }

    try {
      byte[] bytes = file.getBytes();
      String fileName =  System.currentTimeMillis()+"_"+file.getOriginalFilename();
      File tempFile = new File(fileName);
      Files.write(tempFile.toPath(), bytes);
      Map<String, NameInstance> result = nameService.statisticsName(tempFile);

      nameService.storeInDb(result);
      //delete temp file.
      tempFile.delete();
      return ApiResult.success(result);
    } catch (IOException e) {
      e.printStackTrace();
      throw new BusinessException(ResultEnum.SYSTEM_ERROR);
    }
  }

  @EscapeSessionCheck
  @PostMapping("/web/name/score")
  @ApiOperation(value = "getNameScore", response = ApiResult.class)
  public ApiResult<NameScoreResponse> getNameScore(@RequestBody NameScoreRequest request) {
    request.check();

    return ApiResult.success(fortuneService.getNameScore(request.getName()));
  }

  @EscapeSessionCheck
  @PostMapping("/web/name/score-pdf")
  @ApiOperation(value = "getNameScorePdf", response = ApiResult.class)
  public ApiResult<NameScoreResponse> getNameScorePdf(@RequestBody NameScoreRequest request) {
    request.check();

    return ApiResult.success(fortuneService.getNameScore(request.getName()));
  }

  @EscapeSessionCheck
  @RequestMapping(value = "/web/name/score-file", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
  @ApiOperation(value = "generateNameScoreFile", response = ApiResult.class)
  public ApiResult<Void> generateNameScoreFile(@ApiParam(value="file", required = true) @RequestParam(value="file") MultipartFile file) {
    try {
      byte[] bytes = file.getBytes();
      String fileName =  System.currentTimeMillis()+"_"+file.getOriginalFilename();
      File tempFile = new File(fileName);
      Files.write(tempFile.toPath(), bytes);
      fortuneService.generateNameScoreFile(tempFile);

      //delete temp file.
      tempFile.delete();
    } catch (IOException e) {
      e.printStackTrace();
      throw new BusinessException(ResultEnum.SYSTEM_ERROR);
    }
    return ApiResult.success();
  }

  @EscapeSessionCheck
  @GetMapping("/web/name/list")
  @ApiOperation(value = "list", response = ApiResult.class)
  public ApiResult<Void> list() {
    nameService.listName();
    return ApiResult.success();
  }
}
