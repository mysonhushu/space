#! /usr/bin/python3

import mysql.connector
import json
import jieba

filePath = '/home/huxing/my-repo/poetry/poetry'

executePoetryName = open('./executePoetryName.txt', 'w')
poetrySplitResult = open('./poetrySplitResult.txt', 'w')

names = None
fields = []

with open('./allName.txt') as f:
    names = f.read().splitlines()

for name in names:
    executePoetryName.write(name+'\r\n')
    with open(filePath + '/' + name, 'r') as poetry_file:
        poetry_content = poetry_file.read()
        poetry_data = json.loads(poetry_content)

        content = poetry_data['content']
        id = poetry_data['id']
        words_list = jieba.cut(content, cut_all=True)
        poetrySplitResult.write(str(id)+',')
        poetrySplitResult.write(",".join(x for x in words_list if x.isalnum()))
        poetrySplitResult.write("\r\n")


