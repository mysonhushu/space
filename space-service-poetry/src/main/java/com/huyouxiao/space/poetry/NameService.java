package com.huyouxiao.space.poetry;

import com.huyouxiao.space.poetry.bean.request.GenerateNameRequest;
import com.huyouxiao.space.poetry.bean.response.GenerateNameResponse;
import com.huyouxiao.space.poetry.bean.response.NameInstance;

import java.io.File;
import java.util.Map;

public interface NameService {
  GenerateNameResponse generateName(GenerateNameRequest request);
  Map<String, NameInstance> statisticsName(File file);
  void storeInDb(Map<String, NameInstance> words);
  File downloadName(GenerateNameRequest request);
  void listName();
}
