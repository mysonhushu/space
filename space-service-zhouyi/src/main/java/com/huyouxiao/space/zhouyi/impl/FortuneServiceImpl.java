package com.huyouxiao.space.zhouyi.impl;

import com.huyouxiao.space.common.context.FileStorageProperties;
import com.huyouxiao.space.common.enums.ResultEnum;
import com.huyouxiao.space.common.exception.BusinessException;
import com.huyouxiao.space.common.utils.DateUtils;
import com.huyouxiao.space.dao.entity.CalendarEntity;
import com.huyouxiao.space.dao.entity.DictionaryEntity;
import com.huyouxiao.space.dao.entity.FamilyNameEntity;
import com.huyouxiao.space.dao.entity.WordFrequencyEntity;
import com.huyouxiao.space.dao.mapper.CalendarEntityMapper;
import com.huyouxiao.space.dao.mapper.DictionaryEntityMapper;
import com.huyouxiao.space.dao.mapper.FamilyNameEntityMapper;
import com.huyouxiao.space.dao.mapper.WordFrequencyEntityMapper;
import com.huyouxiao.space.zhouyi.FortuneService;
import com.huyouxiao.space.zhouyi.bean.BoneWeight;
import com.huyouxiao.space.zhouyi.bean.Element;
import com.huyouxiao.space.zhouyi.bean.NameScore;
import com.huyouxiao.space.zhouyi.bean.response.FortuneResponse;
import com.huyouxiao.space.zhouyi.bean.response.NameScoreResponse;
import com.huyouxiao.space.zhouyi.enums.BoneDayEnum;
import com.huyouxiao.space.zhouyi.enums.BoneHourEnum;
import com.huyouxiao.space.zhouyi.enums.BoneMonthEnum;
import com.huyouxiao.space.zhouyi.enums.BoneYearEnum;
import com.huyouxiao.space.zhouyi.enums.ConstellationEnum;
import com.huyouxiao.space.zhouyi.enums.FiveElementEnum;
import com.huyouxiao.space.zhouyi.enums.FiveGridEnum;
import com.huyouxiao.space.zhouyi.enums.HeavenEnum;
import com.huyouxiao.space.zhouyi.enums.HourNameEnum;
import com.huyouxiao.space.zhouyi.enums.StrokeSecondEnum;
import com.huyouxiao.space.zhouyi.enums.ZodiacEnum;
import com.huyouxiao.space.zhouyi.enums.ZodiacYearEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class FortuneServiceImpl implements FortuneService {
  public static Map<Integer, DictionaryEntity> words = new HashMap<>();

  @Autowired
  CalendarEntityMapper calendarEntityMapper;


  @Autowired
  DictionaryEntityMapper dictionaryEntityMapper;


  @Autowired
  WordFrequencyEntityMapper wordFrequencyEntityMapper;

  @Autowired
  FamilyNameEntityMapper familyNameEntityMapper;

  private final Path fileStorageLocation;

  @Autowired
  public FortuneServiceImpl(FileStorageProperties fileStorageProperties) {
    this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
        .toAbsolutePath().normalize();

    try {
      Files.createDirectories(this.fileStorageLocation);
    } catch (Exception ex) {
      log.warn("create directories failed.", ex);
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "Could not create the directory where the uploaded files will be stored.");
    }
  }

  @Override
  public FortuneResponse getCharacter(Date date) {
    FortuneResponse response = new FortuneResponse();
    if(null == date) {
      return response;
    }

    CalendarEntity calendarEntity = getCalendarEntity(date);

    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(calendarEntity.getLunarYear() + "(" + calendarEntity.getLunarYearName() + ")年");
    stringBuffer.append(calendarEntity.getLunarMonth() + "(" + calendarEntity.getLunarMonthName() + ")月");
    stringBuffer.append(calendarEntity.getLunarDay() + "(" + calendarEntity.getLunarDayName() + ")日");
    if (null != calendarEntity.getTerms()) {
      stringBuffer.append("  " + calendarEntity.getTerms());
    }
    stringBuffer.append("   " + calendarEntity.getWeek());

    response.setSolarBirthday(calendarEntity.getSolarFull());
    response.setLunarBirthday(stringBuffer.toString());

    stringBuffer.setLength(0);
    stringBuffer.append(calendarEntity.getLunarYearName());
    stringBuffer.append(calendarEntity.getLunarMonthName());
    stringBuffer.append(calendarEntity.getLunarDayName());

    String fiveGan = calendarEntity.getLunarDayName().substring(0, 1);
    int hour = DateUtils.getByField(date, Calendar.HOUR_OF_DAY);
    HourNameEnum hourName = HourNameEnum.getByHourHeavenName(hour, fiveGan);

    stringBuffer.append(hourName.getValue());

    String bazhi = stringBuffer.toString();
    response.setCharacter(bazhi);

    List<Element> elements = Element.generate(bazhi);

    for(Element element : elements) {
      response.addScore(element.getElement(), element.getValue());
    }
    response.setElements(elements);

    String dayGanElement = HeavenEnum.getByName(bazhi.substring(4, 5)).getElement().getName();
    String relay = FiveElementEnum.getByName(dayGanElement).getProduce();

    response.calculate(dayGanElement, relay, bazhi.substring(4, 5));

    // calculate zodiac
    ZodiacYearEnum zodiacYearEnum = ZodiacYearEnum.getByYearName(calendarEntity.getLunarYearName());
    response.setZodiac(zodiacYearEnum);

    String zodiacName = zodiacYearEnum.getZodiac().substring(1);
    ZodiacEnum zodiacEnum = ZodiacEnum.getByName(zodiacName);
    response.setZodiacBuddha(zodiacEnum.getBuddha());

    // calculate constellation.
    ConstellationEnum constellation = ConstellationEnum.getByDate(date);
    response.setConstellation(constellation);

    // calculate bone weight.
    BoneWeight boneWeight = getBoneWeight(date, calendarEntity);
    response.setBoneWeight(boneWeight);
    return response;
  }

  @Override
  public BoneWeight getBoneWeight(Date date, CalendarEntity calendarEntity) {
    BoneWeight response = new BoneWeight();
    if (null == calendarEntity) {
      calendarEntity = getCalendarEntity(date);
    }
    response.setBoneYearEnum(BoneYearEnum.getByNumber(calendarEntity.getLunarYearNumber()));
    response.setBoneMonthEnum(BoneMonthEnum.getByMonth(calendarEntity.getLunarMonth()));
    response.setBoneDayEnum(BoneDayEnum.getByDay(calendarEntity.getLunarDay()));
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    response.setBoneHourEnum(BoneHourEnum.getByHour(hour));

    response.weightBone();
    return response;
  }

  /**
   * 计算每个汉字的笔画数
   * <p>
   * 姓名拆分为姓和名，尤其要注意单姓和复姓
   * 将简体姓和名转换为繁体姓和名
   * 将繁体姓和名映射为康熙字典中的姓和名
   * 将康熙字典中的姓和名的笔画数检出
   * <p>
   * <p>
   * 根据笔画数计算五格（数字）
   * <p>
   * 天格：姓氏笔划再加一数即是天格数（若是复姓，将姓之笔划合计）
   * 人格：将姓氏与第一个名字相加即是人格数（若复姓双名，则姓氏的第二个字笔画加名的第一个字的笔画； 复姓单名则姓氏的第二个字加名的笔画）
   * 地格：将第一个名字与第二个名字相加即是地格数（若是单名，将名字再加一数）
   * 外格：将名字最后一字加一数即是外格数
   * 总格：将姓与名相加即是总格
   *
   * @param name
    @return
   */
  @Override
  public NameScoreResponse getNameScore(String name) {
    NameScoreResponse response = new NameScoreResponse();
    response.setName(name);
    char[] values = name.toCharArray();
    String familyName = String.valueOf(values[0]);
    int size = values.length;
    String first = null;
    String second = null;
    String third = null;
    if (size == 4) {
      third = String.valueOf(values[3]);
      processPlusScore(third, response);
    }
    if (size >= 3) {
      second = String.valueOf(values[2]);
      processPlusScore(second, response);
    }
    if (size >= 2) {
      first = String.valueOf(values[1]);
      processPlusScore(first, response);
    }

    // check family name
    FamilyNameEntity familyNameEntity = familyNameEntityMapper.selectByFamilyName(familyName);
    if (null == familyNameEntity) {
      response.setScore(0);
      return response;
    }
    response.setFamilyNamePinYin(familyNameEntity.getPinyin());

    // heaven
    DictionaryEntity heavenWord = getDictionaryEntity(familyName);
    if(null == heavenWord) {
      return response;
    }

    int familyStroke = heavenWord.getStrokes();
    NameScore heaven = getNameScore(familyStroke + 1, FiveGridEnum.HEAVEN_GRID);
    response.setHeaven(heaven);

    // person
    DictionaryEntity personWord = getDictionaryEntity(first);
    if (null == personWord) {
      return response;
    }
    int personStroke = familyStroke + personWord.getStrokes();
    NameScore person = getNameScore(personStroke, FiveGridEnum.PERSON_GRID);
    response.setPerson(person);


    // earth
    int earthStroke = personStroke + 1;
    DictionaryEntity earthWord = personWord;
    if (null != second) {
      earthWord = getDictionaryEntity(second);
      if(null == earthWord) {
        return response;
      }
      earthStroke = familyStroke + earthWord.getStrokes();
    }
    NameScore earth = getNameScore(earthStroke, FiveGridEnum.EARTH_GRID);
    response.setEarth(earth);

    // out
    int outStroke = earthWord.getStrokes() + 1;

    DictionaryEntity outWord = null;
    if( null != third) {
      outWord = getDictionaryEntity(third);
      if (null == outWord) {
        return response;
      }
      outStroke = outWord.getStrokes() + 1;
    }

    NameScore out = getNameScore(outStroke, FiveGridEnum.OUTSIDE_GRID);
    response.setOut(out);


    // total
    int totalStroke = familyStroke + personWord.getStrokes();

    if(null != second) {
      totalStroke = totalStroke + earthWord.getStrokes();
    }

    if(null != third) {
      totalStroke = totalStroke + outWord.getStrokes();
    }

    if (totalStroke == personStroke) {
      totalStroke = totalStroke + (totalStroke % 3);
    }
    NameScore total = getNameScore(totalStroke, FiveGridEnum.TOTAL_GRID);
    response.setTotal(total);

    response.count();

    return response;
  }

  @Override
  public Resource getNameScorePdf(String name) {
    try {
      Path filePath = this.fileStorageLocation.resolve(name).normalize();
      Resource resource = new UrlResource(filePath.toUri());
      if(resource.exists()) {
        return resource;
      } else {
        throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "File not found " + name);
      }
    } catch (MalformedURLException ex) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "File not found " + name);
    }
  }

  private void processPlusScore(String second, NameScoreResponse response) {
    List<WordFrequencyEntity> wordFrequencyList = wordFrequencyEntityMapper.selectByWord(second);
    if (null == wordFrequencyList) {
      return;
    }

    int maxFrequency = 0;
    String maxSensitive = "";
    for (WordFrequencyEntity word : wordFrequencyList) {
      if (word.getFrequency() > maxFrequency) {
        maxFrequency = word.getFrequency();
        maxSensitive = word.getSensitiveType();
      }
    }
    response.addPlusScore(maxSensitive, maxFrequency);
  }

  private NameScore getNameScore(int stroke, FiveGridEnum grid) {
    StrokeSecondEnum secondEnum = StrokeSecondEnum.getByIndex(stroke);

    NameScore score = new NameScore();
    score.setGrid(grid);
    score.setScore(secondEnum.getScore());
    score.setStrokes(stroke);

    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(secondEnum.getDescription()).append(" ");

    score.setDescription(stringBuffer.toString());
    score.setFierce(secondEnum.getFierce());

    return score;
  }

  private CalendarEntity getCalendarEntity(Date date) {
    String dateZh = DateUtils.getTime(date);

    CalendarEntity calendarEntity = calendarEntityMapper.selectBySolarFull(dateZh);
    if(null == calendarEntity) {
      throw new BusinessException(ResultEnum.INVALID_REQUEST_PARAMETER, "天机不可泄漏");
    }
    return calendarEntity;
  }

  private DictionaryEntity getDictionaryEntity(String word) {
    if (null == word) {
      return null;
    }

    if (null == words.get(word.hashCode())) {
      String hashCode = String.valueOf(word.hashCode());
      DictionaryEntity entity = dictionaryEntityMapper.selectByWord(hashCode, word);
      words.put(word.hashCode(), entity);
      return entity;
    }
    return words.get(word.hashCode());
  }

}
