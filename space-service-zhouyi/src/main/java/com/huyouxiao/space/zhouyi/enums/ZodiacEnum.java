package com.huyouxiao.space.zhouyi.enums;

/**
 * 子鼠、丑牛、寅虎、卯兔、辰龙、巳蛇、午马、未羊、申猴、酉鸡、戌狗、亥猪
 * 鼠：千手观音菩萨
 * 牛：虚空藏菩萨
 * 虎：虚空藏菩萨
 * 兔：文殊菩萨
 * 龙：普贤菩萨
 * 蛇：普贤菩萨
 * 马：大势至菩萨
 * 羊：大日如来
 * 猴：大日如来
 * 鸡：不动明王
 * 狗：阿弥陀佛
 * 猪：阿弥陀佛
 */
public enum ZodiacEnum {
  AT(1,"鼠", "AT", "子鼠", "千手观音菩萨"),
  OX(2,"牛", "OX", "丑牛", "虚空藏菩萨"),
  TIGER(3,"虎", "TIGER", "寅虎", "虚空藏菩萨"),
  RABBIT(4,"兔", "RABBIT", "卯兔", "文殊菩萨"),
  DRAGON(5,"龙", "DRAGON", "辰龙", "普贤菩萨"),
  SNAKE(6,"蛇", "SNAKE", "巳蛇", "普贤菩萨"),
  HOURSE(7,"马", "HORSE", "午马", "大势至菩萨"),
  GOAT(8,"羊", "GOAT", "未羊", "大日如来"),
  MONKEY(9,"猴", "MONKEY", "申猴", "大日如来"),
  ROOSTER(10,"鸡", "ROOSTER", "酉鸡", "不动明王"),
  DOG(11,"狗", "DOG", "戌狗", "阿弥陀佛"),
  PIG(12,"猪", "PIG", "亥猪", "阿弥陀佛"),
  ;
  private int number;
  private String name;
  private String code;
  private String zhi;
  private String buddha;

  private ZodiacEnum(int number, String name, String code, String zhi, String buddha){
    this.number = number;
    this.name = name;
    this.code = code;
    this.zhi = zhi;
    this.buddha = buddha;
  }

  public static ZodiacEnum getByName(String name) {
    for (ZodiacEnum value : ZodiacEnum.values()) {
      if (value.name.contains(name)) {
        return value;
      }
    }
    return null;
  }

  public int getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }

  public String getZhi() {
    return zhi;
  }

  public String getBuddha() {
    return buddha;
  }}
