package com.huyouxiao.space.poetry.impl;

import com.huyouxiao.space.poetry.PoetryService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


@Service
public class PoetryServiceImpl implements PoetryService {
  @Override
  public BufferedReader getPoetry(String name) {
    InputStream  in = getClass().getResourceAsStream("/poetry/"+name);
    return new BufferedReader(new InputStreamReader(in));
  }
}
