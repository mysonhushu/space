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


sql = " insert ignore into wait.poetry(id,name,dynasty,content) values (%s, %s, %s, %s)"

filePath = '/home/huxing/my-repo/poetry/poetry'

execute = open('./execute.txt', 'w')
lines = None
val = []
with open('./allName.txt') as f:
    lines = f.read().splitlines()
  
start = 1  
for line in lines:
    execute.write(line+'\r\n')
    with open(filePath + '/' + line, 'r') as content_file:
        content = content_file.read() 
        json_data = json.loads(content)
        
        tul = (json_data['id'],json_data['name'], json_data['dynasty'],str(json_data['content']).replace('<br>','').replace('<p>','').replace('<p/>',''))
        val.append(tul)
        mycursor.executemany(sql, val)
        mydb.commit()
        val = []

print(mycursor.rowcount, "was inserted.")

