#! /usr/bin/python3
from pypinyin import pinyin,lazy_pinyin,Style
import mysql.connector
import json
import unicodedata

mydb = mysql.connector.connect(
        host = "127.0.0.1",
        user = "root",
        passwd = "rootroot",
        database = "wait"
        )

print (mydb)

jieqi = ["立春","惊蛰","清明","立夏","芒种","小暑","立秋","白露","寒露","立冬","大雪","小寒"]
ganzhiList = ["甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"] 

monthDicts = {'正月': 1,'二月': 2,'三月': 3,'四月': 4,'五月': 5,'六月': 6,'七月': 7,'八月': 8,'九月': 9,'十月': 10,'十一月': 11,'十二月': 12}

dayDicts = {'二十':20, '初一':1,'初二':2,'初三':3, '初四':4,'初五':5,'初六':6,'初七':7,'初八':8,'初九':9,'初十':10,'十一':11,'十二':12,'十三':13,'十四':14,'十五':15,'十六':16,'十七':17,'十八':18,'十九':19,'廿十':20, '廿一':21,'廿二':22,'廿三':23,'廿四':24,'廿五':25, '廿六':26, '廿七':27, '廿八':28,'廿九':29,'三十':30}

mycursor = mydb.cursor()
sql = " insert ignore into wait.calendar(solar_full, lunar, lunar_year, lunar_month, lunar_day, week, terms, lunar_year_name, lunar_month_name, lunar_day_name, lunar_year_number, lunar_month_number, lunar_day_number) values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) "

data = None
val = []
f =  open('./huxing_jian_3.txt', 'r')
lines = f.readlines()


cursorYear = 1900 
cursorYearNameIndex = 36
cursorMonth = 11
cursorMonthNameIndex = 24
cursorDayNameIndex = 15 
isRun = False
runValue = None
for line  in lines:
   item = line.replace('\n','').split(',')
   val.append(str(item[0])) # solar_full
   val.append(str(item[1])) # lunar
   if '正月' == str(item[1]):
       cursorYear = cursorYear + 1
       # add year if needed
       cursorYearNameIndex = cursorYearNameIndex + 1

   val.append(cursorYear) # lunar_year
   cursorMonth = monthDicts.get(item[1],cursorMonth)
   val.append(cursorMonth) # lunar_month
   val.append(dayDicts.get(item[1], 1)) # lunar_day
   val.append(str(item[2])) # week
   if '' == item[3]:
       item[3] = None
       val.append(None) # terms 
   else:
       val.append(str(item[3])) # terms 


   val.append(ganzhiList[cursorYearNameIndex%60])
   # item[1] is regurlar month, add one
   if monthDicts.get(item[1], 99) != 99:
       cursorMonthNameIndex = cursorMonthNameIndex + 1
       val.append(ganzhiList[cursorMonthNameIndex%60])
       isRun = False
   # item[1] is 闰月, remain empty
   elif '闰' in str(item[1]):
       runValue = ganzhiList[cursorMonthNameIndex%60]
       isRun = True
       val.append(runValue)
   elif isRun and item[3] in jieqi:
       runValue = ganzhiList[(cursorMonthNameIndex+1)%60]
       val.append(runValue)
   elif isRun:
       val.append(runValue)
   else:
       # use previous value.
       val.append(ganzhiList[cursorMonthNameIndex%60])
   val.append(ganzhiList[cursorDayNameIndex%60])
   val.append(cursorYearNameIndex%60)
   val.append(cursorMonthNameIndex%60)
   val.append(cursorDayNameIndex%60)
   print(val)
   cmdSql = sql % tuple(val)
   print(cmdSql)
   mycursor.execute(sql, val)
   mydb.commit()
   val = []
   cursorDayNameIndex = cursorDayNameIndex + 1
print(mycursor.rowcount, "was inserted.")

