package com.huyouxiao.space.zhouyi.bean;

import com.huyouxiao.space.zhouyi.enums.BoneDayEnum;
import com.huyouxiao.space.zhouyi.enums.BoneHourEnum;
import com.huyouxiao.space.zhouyi.enums.BoneMonthEnum;
import com.huyouxiao.space.zhouyi.enums.BoneTableEnum;
import com.huyouxiao.space.zhouyi.enums.BoneYearEnum;
import lombok.Data;

@Data
public class BoneWeight {
  private BoneYearEnum boneYearEnum;
  private BoneMonthEnum boneMonthEnum;
  private BoneDayEnum boneDayEnum;
  private BoneHourEnum boneHourEnum;
  private String boneWeightName;
  private int boneLiang;
  private int boneQian;
  private String boneDescription;


  public void weightBone() {
    boneLiang = boneYearEnum.getLiang() + boneMonthEnum.getLiang() + boneDayEnum.getLiang() + boneHourEnum.getLiang();
    boneQian = boneYearEnum.getQian() + boneMonthEnum.getQian() + boneMonthEnum.getQian() + boneHourEnum.getQian();
    boneLiang = boneLiang + (boneQian / 10);
    boneQian = (boneQian%10);

    boneWeightName = boneLiang + "两" + boneQian + "钱";

    BoneTableEnum value = BoneTableEnum.getByWeight(boneLiang, boneQian);
    boneDescription = value.getDescription();
  }
}
