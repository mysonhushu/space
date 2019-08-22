package com.huyouxiao.space.poetry.bean.response;

import com.huyouxiao.space.poetry.bean.Name;
import com.huyouxiao.space.zhouyi.bean.response.FortuneResponse;
import lombok.Data;

import java.util.List;

@Data
public class GenerateNameResponse {
  private List<Name> names;
  private Integer total;
  private FortuneResponse baZhi;
  private Integer pageNo;
  private Integer pageSize;
}
