package com.huyouxiao.space.poetry;

import com.huyouxiao.space.model.poetry.Poetry;


public interface PoetryService {
  Poetry getPoetry(String name);

  Poetry getPoetry(Long id);
}
