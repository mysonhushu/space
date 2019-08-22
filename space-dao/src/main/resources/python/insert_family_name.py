#! /usr/bin/python3

import mysql.connector
import json

mydb = mysql.connector.connect(
        host = "127.0.0.1",
        user = "root",
        passwd = "rootroot",
        database = "wait"
        )

print (mydb)


mycursor = mydb.cursor()


sql = " insert ignore into wait.family_name(pinyin_letter,pinyin,family_name,family_first_letter) values (%s, %s, %s, %s)"

lines = None
val = []
with open('./Chinese_Family_Name_pinyin.txt') as f:
    lines = f.read().splitlines()
    for line in lines:
        print(line)
        fields = line.split(',') 
        tul = (fields[0],fields[1],fields[2],fields[3])
        val.append(tul)
        mycursor.executemany(sql, val)
        mydb.commit()
        val = []

print(mycursor.rowcount, "was inserted.")

