package com.huyouxiao.space.bookworm;

import com.huyouxiao.space.model.bookworm.IndexWords;

import java.io.File;
import java.util.Map;

public interface IndexWordService {
  /**
   * Index poetry words.
   * the file contain line as below:
   * 10000,竹,窗,松,户,有,佳期,美酒,酒香,香茶,慰,所思,辅,嗣,外生,生还,解,易,惠,连,群,从,总能,诗,檐前,花落,春,深,后,谷,里,莺啼,日暮,时,去路,归程,仍,待,月,垂,缰,不,控,马行,马行
   迟
   * 10001,自,顾,衰,容,累,玉,除,忽,承,优,诏,赴,铜,鱼,江头,鸟,避,青,旄,节,城里,城里人,里人,迎,露,网,车,长沙,沙地,近,悲,才子,古,郡,山,多,忆旧,庐,更,枉,新诗,诗思,何苦,离骚,愁,处
   ,亦,无如
   * the words spilt by ",", and the first field is the poetry id.
   * the rest of words belong to this poetry.
   * @param file
   * @return
   */
  Map<String, IndexWords> indexWords(File file);

  void storeInDb(Map<String, IndexWords> words);
}
