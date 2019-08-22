package com.huyouxiao.space.zhouyi.bean.response;

import com.huyouxiao.space.model.poetry.enums.SensitiveTypeEnum;
import com.huyouxiao.space.zhouyi.bean.NameScore;
import com.huyouxiao.space.zhouyi.enums.FiveGridEnum;
import com.huyouxiao.space.zhouyi.enums.StrokeSecondEnum;
import lombok.Data;

@Data
public class NameScoreResponse {
  private NameScore heaven;
  private NameScore earth;
  private NameScore person;
  private NameScore total;
  private NameScore out;
  private int score;
  private String name;
  private String familyNamePinYin;
  private String namePinYin;
  private int plusScore = 0;

  public void count() {
    score = heaven.getScore() + earth.getScore() + person.getScore() + total.getScore() + out.getScore() + plusScore;

    if (score > 100) {
      score = 100 - score%10;
    }

    if (score < 0) {
      score = 0;
    }

    if (name.equals("毛泽东")|| name.equals("习近平") || name.equals("孙中山")) {
      heaven = StrokeSecondEnum.get(FiveGridEnum.HEAVEN_GRID, heaven);
      earth = StrokeSecondEnum.get(FiveGridEnum.EARTH_GRID, earth);
      person = StrokeSecondEnum.get(FiveGridEnum.PERSON_GRID, person);
      total = StrokeSecondEnum.get(FiveGridEnum.TOTAL_GRID, person);
      out = StrokeSecondEnum.get(FiveGridEnum.OUTSIDE_GRID, out);
      score = 100;
      plusScore = 100;
    }

  }

  public void addPlusScore(String sensitive, int score) {
    if (SensitiveTypeEnum.NEGATIVE.name().equals(sensitive)) {
      plusScore = plusScore - 30;
    } else if (SensitiveTypeEnum.POSITIVE.name().equals(sensitive)) {
      plusScore = plusScore + 15;
    }
  }
}
