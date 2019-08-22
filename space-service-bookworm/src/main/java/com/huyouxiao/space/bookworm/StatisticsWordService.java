package com.huyouxiao.space.bookworm;

import com.huyouxiao.space.model.bookworm.StatisticsWord;
import com.huyouxiao.space.model.poetry.enums.SensitiveTypeEnum;

import java.io.File;
import java.util.Map;

public interface StatisticsWordService {
   Map<Character, StatisticsWord> statistics(File file, SensitiveTypeEnum type);
   void storeInDb(Map<Character, StatisticsWord> words);
}
