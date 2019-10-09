#!/usr/bin/python3
import requests
from lxml import etree
import json

url = "http://127.0.0.1:8080/web/name/score"

#定义核心方法
def nameGrade(name,sentency,fileOut):
        params = {}
        params['name'] =str(name) #默认值为1

        #print(params)
        response = requests.post(url,json=params)
        response.encoding = 'UTF-8'

        #print(response.text)
        todos = json.loads(response.text)
        score = todos['content']['score']
        #print(name + ":"+str(score))
        fileOut.write('\n')
        if score > 95:
            fileOut.write("☆ ☆ ☆ ☆ ☆ ")
        elif score > 90:
            fileOut.write("  ☆ ☆ ☆   ")
        elif score > 85:
            fileOut.write("  ☆  ☆    ")
        elif score > 80:
            fileOut.write("    ☆     ")
        if score > 80:
            fileOut.write("姓名：" + name + '\t' + "五格数理分数:" + str(score) + '\n')
            fileOut.write("姓名批注:"+todos['content']['heaven']['description']+'\n')
            fileOut.write("         "+todos['content']['earth']['description']+'\n')
            fileOut.write("         "+todos['content']['person']['description']+'\n')
            fileOut.write("         "+todos['content']['total']['description']+'\n')
            fileOut.write("         "+todos['content']['out']['description']+'\n')
            fileOut.write("引用诗句:"+str(sentency) + '\n')

#读取txt文件，循环调用
file = open("wordsIndexOfPoetry.txt")
list = []
familyNames = '王李张刘陈杨赵黄周吴徐孙胡朱高林何郭马罗梁宋郑谢韩唐冯于董萧程曹袁邓许傅沈曾彭吕苏卢蒋蔡贾丁魏薛叶阎余潘杜戴夏钟汪田任姜范方石姚谭廖邹熊金陆郝孔白崔康毛邱秦江史顾侯邵孟龙万段漕钱汤尹黎易常武乔贺赖龚文庞樊兰殷施陶洪翟安颜倪严牛温芦季俞章鲁葛伍韦申尤毕聂丛焦向柳邢路岳齐沿梅莫庄辛管祝左涂谷祁时舒耿牟卜路詹关苗凌费纪靳盛童欧甄项曲成游阳裴席卫查屈鲍位覃霍翁隋植甘景薄单包司柏宁柯阮桂闵欧阳解强柴华车冉房边辜吉饶刁瞿戚丘古米池滕晋苑邬臧畅宫来嵺苟全褚廉简娄盖符奚木穆党燕郎邸冀谈姬屠连郜晏栾郁商蒙计喻揭窦迟宇敖糜鄢冷卓花仇艾蓝都巩稽井练仲乐虞卞封竺冼原官衣楚佟栗匡宗应台巫鞠僧桑荆谌银扬明沙薄伏岑习胥保和'
# 读取txt文件，循环调用
lines = file.readlines()
for familyName in familyNames:
    print(familyName)
    fileOut = open("诗经高分名字_"+familyName+".txt","w+")
    for line in lines:
        lineconten = line.split('#')
        #1#柴#['射夫既同，助我举柴']
        #1#不骏#['浩浩昊天，不骏其德']
        nameGrade(familyName +lineconten[1], lineconten[2], fileOut)
