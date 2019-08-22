package com.huyouxiao.space.zhouyi;


import com.huyouxiao.space.dao.entity.CalendarEntity;
import com.huyouxiao.space.zhouyi.bean.BoneWeight;
import com.huyouxiao.space.zhouyi.bean.response.FortuneResponse;
import com.huyouxiao.space.zhouyi.bean.response.NameScoreResponse;
import org.springframework.core.io.Resource;

import java.util.Date;

public interface FortuneService {
  FortuneResponse getCharacter(Date date);

  BoneWeight getBoneWeight(Date date, CalendarEntity calendarEntity);

  /**
   * 计算每个汉字的笔画数
   *
   * 姓名拆分为姓和名，尤其要注意单姓和复姓
   * 将简体姓和名转换为繁体姓和名
   * 将繁体姓和名映射为康熙字典中的姓和名
   * 将康熙字典中的姓和名的笔画数检出
   *
   *
   * 根据笔画数计算五格（数字）
   *
   * 天格：姓氏笔划再加一数即是天格数（若是复姓，将姓之笔划合计）
   * 人格：将姓氏与第一个名字相加即是人格数（若复姓双名，则姓氏的第二个字笔画加名的第一个字的笔画； 复姓单名则姓氏的第二个字加名的笔画）
   * 地格：将第一个名字与第二个名字相加即是地格数（若是单名，将名字再加一数）
   * 外格：将名字最后一字加一数即是外格数
   * 总格：将姓与名相加即是总格
   * @param name
   * @return
   */
  NameScoreResponse getNameScore(String name);

  Resource getNameScorePdf(String name);
}
