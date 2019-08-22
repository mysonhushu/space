package com.huyouxiao.space.common.utils;



import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
public class FileUtils {
  public static String readFile(File file) {
    CharSource source = Files.asCharSource(file, Charsets.UTF_8);
    try {
      return source.read();
    } catch (IOException e) {
      log.warn("read content from file: {} failed", file.getName(), e);
      e.printStackTrace();
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
  }

  public static List<String> readFileLines(String fileName) {
    File file = new File(
        Thread.currentThread().getContextClassLoader().getResource(fileName).getFile()
    );
    try {
      List<String> result = Files.readLines(file, Charsets.UTF_8);
      return result;
    } catch (IOException e) {
      log.warn("read content from file: {} failed", fileName, e);
      e.printStackTrace();
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
  }

  public static List<String> readFileLines(File file) {
    try {
      List<String> result = Files.readLines(file, Charsets.UTF_8);
      return result;
    } catch (IOException e) {
      log.warn("read content from file: {} failed", file.getName(), e);
      e.printStackTrace();
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
  }

  public static File writeFile(String fileName, String content) {
    File file = new File(fileName);
    try {
      Files.write(content, file, Charsets.UTF_8);
    } catch (IOException e) {
      log.warn("write content to file: {} failed", fileName, e);
      e.printStackTrace();
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER);
    }
    return file;
  }
}
