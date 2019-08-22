package com.huyouxiao.space.poetry.impl;

import com.huyouxiao.space.dao.entity.PoetryEntity;
import com.huyouxiao.space.dao.mapper.PoetryEntityMapper;
import com.huyouxiao.space.model.poetry.Poetry;
import com.huyouxiao.space.poetry.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PoetryServiceImpl implements PoetryService {
    @Autowired
    private PoetryEntityMapper poetryEntityMapper;

  @Override
  public Poetry getPoetry(String name) {
      PoetryEntity entity = poetryEntityMapper.selectByName(name);
      return Poetry.getPoetry(entity);
  }

  @Override
  public Poetry getPoetry(Long id) {
    return Poetry.getPoetry(poetryEntityMapper.selectByPrimaryKey(id));
  }
}
