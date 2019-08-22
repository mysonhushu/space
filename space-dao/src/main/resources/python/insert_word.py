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


mycursor = mydb.cursor()


sql = " insert ignore into wait.word(word,first_letter,pinyin,pinyin_letter,strokes,radicals,explanation,more) values (%s, %s, %s, %s, %s, %s, %s, %s)"

data = None
val = []
with open('./word.json', 'r') as f:
    data = f.read().replace('\n','').replace('\r', '').replace('<br>','').replace('<p>','').replace('<p/>','').replace('<br/>','')
    data_json = json.loads(data)
    for item in data_json:
        word = item.get('word')
        pinyin_letter = unicodedata.normalize('NFKD',item.get('pinyin')).encode('ascii', 'ignore')
        #BUG: I don't know why this method not work. so use sql to update directly: update wait.word set first_letter = left(pinyin_letter,1) where id>0;
        first_letter = str(pinyin_letter)[0] 
        tul = (item.get('word'),first_letter,str(item.get('pinyin')),pinyin_letter,item.get('strokes'),item.get('radicals'),item.get('explanation'),item.get('more'))
        val.append(tul)
        print(word)
        mycursor.executemany(sql, val)
        mydb.commit()
        val = []
        pinyin_letter = None
        first_letter = None

print(mycursor.rowcount, "was inserted.")

