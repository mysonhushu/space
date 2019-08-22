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


sql = " update wait.poetry_index set is_name='1' where id = "

filePath = '/home/huxing/my-repo/poetry/poetry'

with open('./temp.csv') as f:
    lines = f.read().splitlines()
    start = 1  
    for line in lines:
        mycursor.execute(sql+line)
        mydb.commit()
        print(start)
        start += 1
print(mycursor.rowcount, "was inserted.")

