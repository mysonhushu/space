package com.huyouxiao.space.bookworm;

import com.huyouxiao.space.model.bookworm.IndexWords;

import java.io.File;
import java.util.Map;

public interface SplitWordService {
  //TODO: fixme! don't know exact response structure.
  void splitWords(File file);
}
