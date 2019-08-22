#!/usr/bin/python3
import requests
from bs4 import BeautifulSoup

url = 'http://www.guabu.com/xingming/?name='
#url = 'http://www.guabu.com/xingming/?name='


outFile = open('allNameScoreOut.txt','w')
with open('allName.txt') as f:
    content = f.readlines()
    for line in content:
        print(line)
        values = line.split(',')
        temp = url+'胡'+values[0].replace(' ','').replace('\'','')
        print(temp)
        r = requests.get(url+'胡'+values[0].replace(' ','').replace('\'',''))
        soup = BeautifulSoup(r.content, 'html.parser')
        print(soup.find('font', {'color':"0000ff", 'face':"Broadway BT,楷体", 'size':"15"}).text)
        score = soup.find('font', {'color':"0000ff", 'face':"Broadway BT,楷体", 'size':"15"}).text
        outFile.write(line+','+str(score))
        
outFile.close()
