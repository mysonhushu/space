package com.huyouxiao.space.web.controller;

import com.huyouxiao.space.bookworm.IndexWordService;
import com.huyouxiao.space.bookworm.StatisticsWordService;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import com.huyouxiao.space.model.bookworm.IndexWords;
import com.huyouxiao.space.model.bookworm.StatisticsWord;
import com.huyouxiao.space.model.poetry.enums.SensitiveTypeEnum;
import com.huyouxiao.space.web.annontation.EscapeSessionCheck;
import com.huyouxiao.space.web.api.ApiResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

@RestController
@Slf4j
public class WordStatisticController {
  @Autowired
  private StatisticsWordService statisticsWordService;

  @Autowired
  private IndexWordService indexWordService;

  @EscapeSessionCheck
  @RequestMapping(value = "/web/word/statistic", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
  @ApiOperation(value = "statisticWord", response = ApiResult.class)
  public ApiResult<Map<Character, StatisticsWord>> statisticWord(
        @ApiParam(value="file", required = true) @RequestParam(value="file") MultipartFile file,
        @ApiParam(value="sensitiveType", required = true)  @RequestParam(value = "sensitiveType") String sensitiveType) {
    if(null == file || file.isEmpty()) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }

    try {
      byte[] bytes = file.getBytes();
      String fileName =  System.currentTimeMillis()+"_"+file.getOriginalFilename();
      File tempFile = new File(fileName);
      Files.write(tempFile.toPath(), bytes);
      Map<Character, StatisticsWord> result = statisticsWordService.statistics(tempFile, SensitiveTypeEnum.getByCode(sensitiveType));

      statisticsWordService.storeInDb(result);
      //delete temp file.
      tempFile.delete();
      return ApiResult.success(result);
    } catch (IOException e) {
      e.printStackTrace();
      throw new BusinessException(ResultEnum.SYSTEM_ERROR);
    }
  }

  @EscapeSessionCheck
  @RequestMapping(value = "/web/word/index", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
  @ApiOperation(value = "indexWords", response = ApiResult.class)
  public ApiResult<Map<String, IndexWords>> indexWords(
      @ApiParam(value="file", required = true) @RequestParam(value="file") MultipartFile file) {
    if(null == file || file.isEmpty()) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }

    try {
      byte[] bytes = file.getBytes();
      String fileName =  System.currentTimeMillis()+"_"+file.getOriginalFilename();
      File tempFile = new File(fileName);
      Files.write(tempFile.toPath(), bytes);
      Map<String, IndexWords> result = indexWordService.indexWords(tempFile);

      indexWordService.storeInDb(result);
      //delete temp file.
      tempFile.delete();
      return ApiResult.success(result);
    } catch (IOException e) {
      e.printStackTrace();
      throw new BusinessException(ResultEnum.SYSTEM_ERROR);
    }
  }
}
