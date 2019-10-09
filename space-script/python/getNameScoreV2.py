#!/usr/bin/python3
import requests
from lxml import etree

url = "http://m.life.httpcn.com/m/xingming/"

headers = {
    'accept': "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
    'accept-encoding': "gzip, deflate",
    'accept-language': "zh-CN,zh;q=0.8",
    'content-type': "application/x-www-form-urlencoded",
    'host': "m.life.httpcn.com",
    'origin': "http://m.life.httpcn.com",
    'referer': "http://m.life.httpcn.com/xingming/",
    'upgrade-insecure-requests': "1",
    'user-agent': "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1"
}

fileOut = open("诗经王姓美名大全.txt","w+")

#定义核心方法
def nameGrade(lastName,firstName,sex,year,month,day,hour,minute):
    params = {}
    params['act'] = 'submit' #默认值
    params['data_type'] = '0' #日期类型，0表示公历，1表示农历
    params['RenYue'] = '0' #默认为0
    params['year'] = year #输入出生年份
    params['month'] = month #输入出生月份
    params['day'] = day #输入出生日
    params['hour'] = hour #输入出生时
    params['minute'] = minute # 输入出生分
    params['zty'] = '0' #真太阳时，默认不使用为0
    params['wxxy'] = '0' #喜用五行，0表示自动分析，1表示自定喜用神
    params['xing'] = lastName #输入姓
    params['ming'] = firstName #输入名
    params['sex'] = sex #性别，0表示女孩，1表示男孩
    params['isbz'] = '1' #默认值为1

    response = requests.request("POST",url,data=params,headers=headers)
    response.encoding = 'UTF-8'

    selector = etree.HTML(response.text)
    # print(response.text)
    #解析得到"五格数理"分数
    wuge_score = selector.xpath('//div[@class="mui-collapse-content hc-cha-content"]/div[1]/div/text()')
    #解析得到"八字五行"分数
    bazi_score = selector.xpath('//div[@class="mui-collapse-content hc-cha-content"]/div[4]/div/text()')

    print("姓名：" + str(lastName) + str(firstName) + '\t' + "五格数理分数:" + str(wuge_score) + '\t' + "八字五行分数:" + str(bazi_score))
    fileOut.write("姓名：" + str(lastName) + str(firstName) + '\t' + "五格数理分数:" + str(wuge_score) + '\t' + "八字五行分数:" + str(bazi_score))

#读取txt文件，循环调用
file = open("word2Output.txt")
list = []
while 1:
    line = file.readline()
    if not line:
        break
    pass
    # print(line.split(';'))
    lineconten = line.split(',')
    nameGrade('王',lineconten[0].replace("'","").replace(" (",""),1,2019,9,28,4,5)
