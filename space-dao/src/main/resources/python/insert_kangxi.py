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


sql = " insert ignore into wait.dictionary(code_point, hash_code, word, strokes) values (%s, %s, %s, %s) "

filePath = '/home/huxing/my-repo/poetry/poetry'

execute = open('./execute.txt', 'w')
lines = None
val = []
insert = 0
with open('./kangxi-strokecount.csv') as f:
    lines = f.read().splitlines()
    start = 1  
    for line in lines:
        execute.write(line+'\r\n')
        values = line.split(',')
        for value in values:
            val.append(str(value))
        #print(tuple(val))
        #cmdSql = sql % tuple(val)
        #print(cmdSql)
        mycursor.execute(sql, val)
        mydb.commit()
        insert = insert + 1
        print(str(insert))
        val = []

print(mycursor.rowcount, "was inserted.")

