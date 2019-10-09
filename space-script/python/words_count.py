#! /usr/bin/python3

import mysql.connector
import json
import jieba
import os, codes
from collections import Counter
import operator

c = Counter()

filePath = '/home/huxing/my-repo/poetry/poetry'

executePoetryName = open('./executePoetryName.txt', 'w')
poetryCountResult = open('./poetryCountResult.txt', 'w')
poetrySignleWordsResult = open('./poetrySignleWordsResult.txt', 'w')

names = None
fields = []

with open('./poetrySplitResult.txt') as f:
    lines = f.read().splitlines()
    for line in lines:
        words = line.split(',')
        poetry_id = words[0] 
        for word in words[1:]:
            if len(word)>1 and word != '\r\n':
                c[word] += 1

for k, v in c.items():
    poetryCountResult.write(''+str(v)+'='+str(k)+'\r\n')
    poetrySignleWordsResult.write(str(k)+'\r\n')

