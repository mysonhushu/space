package com.huyouxiao.space.bookworm;

import com.google.common.collect.Lists;
import com.huyouxiao.space.bookworm.impl.StatisticsWordServiceImpl;
import com.huyouxiao.space.common.utils.FileUtils;
import com.huyouxiao.space.dao.entity.WordEntity;
import com.huyouxiao.space.dao.mapper.WordEntityMapper;
import com.huyouxiao.space.model.bookworm.StatisticsWord;
import com.huyouxiao.space.model.poetry.enums.SensitiveTypeEnum;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsWordServiceTest {
  @Before
  public void setUp()
  {
    wordEntityMapper= Mockito.mock(WordEntityMapper.class);
  }


  private StatisticsWordServiceImpl statisticsWordService = new StatisticsWordServiceImpl();

  @MockBean
  private WordEntityMapper wordEntityMapper;

  @Test
  public void statistics_success() throws NoSuchFieldException {
    statisticsWordService.setWordEntityMapper(wordEntityMapper);

    Mockito.when(wordEntityMapper.selectByWord(Mockito.anyString(), Mockito.anyString())).thenReturn(new WordEntity());


    String fileName = "ntusd-negative.txt";
    String outFileName = "negative-count.txt";
    File negativeFile = new File(
        Thread.currentThread().getContextClassLoader().getResource(fileName).getFile()
    );
    File positiveFile = new File(
        Thread.currentThread().getContextClassLoader().getResource(fileName).getFile()
    );

    Map<Character, StatisticsWord> negative =  statistic(negativeFile, outFileName, SensitiveTypeEnum.NEGATIVE);
    Map<Character, StatisticsWord> positive =  statistic(positiveFile, "positive-count.txt", SensitiveTypeEnum.POSITIVE);

    Iterator iter = positive.entrySet().iterator();
    StringBuffer stringBuffer = new StringBuffer();
    StringBuffer remainBuffer = new StringBuffer();
    while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      Object key = entry.getKey();
      StatisticsWord pos = (StatisticsWord) entry.getValue();
      if(negative.containsKey(key)) {
        StatisticsWord neg = negative.get(key);
        if(neg.getFrequency() < pos.getFrequency() && pos.getFrequency()>=10L) {
          stringBuffer.append(key+", neg="+neg.getFrequency()+", pos="+pos.getFrequency()+"\r\n");
          negative.remove(key);
          continue;
        }else {
          remainBuffer.append(key+", neg="+neg.getFrequency()+", pos="+pos.getFrequency()+"\r\n");
        }
      }
    }

    StringBuffer realNegBuffer = new StringBuffer();
    List<StatisticsWord> values = Lists.newArrayList(negative.values());
    for(StatisticsWord item : values) {
      realNegBuffer.append(item.getWord()+","+item.getFrequency()+"\r\n");
    }

    FileUtils.writeFile("remove-negative.txt", stringBuffer.toString());
    FileUtils.writeFile("remain-negative.txt", remainBuffer.toString());
    FileUtils.writeFile("real-negative.txt", realNegBuffer.toString());
  }

  private Map<Character, StatisticsWord>   statistic(File inputFile, String outputFileName, SensitiveTypeEnum sensitiveTypeEnum) {
    Map<Character, StatisticsWord> result = statisticsWordService.statistics(inputFile, sensitiveTypeEnum);

    List<StatisticsWord> values = Lists.newArrayList(result.values());
    values.sort((StatisticsWord a, StatisticsWord b) -> b.getFrequency().compareTo(a.getFrequency()));

    StringBuffer content = new StringBuffer();

    for(StatisticsWord item : values) {
      content.append(item.getWord()+","+item.getFrequency()+"\r\n");
    }

    FileUtils.writeFile(outputFileName, content.toString());
    return result;
  }
}
