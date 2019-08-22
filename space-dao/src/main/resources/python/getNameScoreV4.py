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

fileOut = None


# 定义核心方法
def nameGrade(lastName, firstName, sex, year, month, day, hour, minute, sentency):
    params = {}
    params['act'] = 'submit'  # 默认值
    params['data_type'] = '0'  # 日期类型，0表示公历，1表示农历
    params['RenYue'] = '0'  # 默认为0
    params['year'] = year  # 输入出生年份
    params['month'] = month  # 输入出生月份
    params['day'] = day  # 输入出生日
    params['hour'] = hour  # 输入出生时
    params['minute'] = minute  # 输入出生分
    params['zty'] = '0'  # 真太阳时，默认不使用为0
    params['wxxy'] = '0'  # 喜用五行，0表示自动分析，1表示自定喜用神
    params['xing'] = lastName  # 输入姓
    params['ming'] = firstName  # 输入名
    params['sex'] = sex  # 性别，0表示女孩，1表示男孩
    params['isbz'] = '1'  # 默认值为1
    print(url)
    response = requests.request("POST", url, data=params, headers=headers)
    response.encoding = 'UTF-8'

    selector = etree.HTML(response.text)
    # print(response.text)
    # 解析得到"五格数理"分数
    wuge_score = selector.xpath('//div[@class="mui-collapse-content hc-cha-content"]/div[1]/div/text()')
    # 解析得到"八字五行"分数
    bazi_score = selector.xpath('//div[@class="mui-collapse-content hc-cha-content"]/div[4]/div/text()')
    firstScore = int(float(str(wuge_score[0]).replace("'", "").replace("分", "")))
    secondScore = int(float(str(bazi_score[0]).replace("'", "").replace("分", "")))
    print("姓名：" + str(lastName) + str(firstName) + '\t' + "五格数理分数:" + str(wuge_score) + '\t' + "八字五行分数:" + str(bazi_score) + '\r')
    # print("      引用诗句："+str(sentency))
    if firstScore > 80 and secondScore > 80:
        if firstScore > 90 and secondScore > 90:
           fileOut.write("  ☆ ☆ ☆  ")
        elif firstScore > 95 and secondScore > 95:
           fileOut.write("☆ ☆ ☆ ☆ ☆ ")
        else:
            fileOut.write("         ")
        fileOut.write("姓名：" + str(lastName) + str(firstName) + '\t' + "五格数理分数:" + str(wuge_score) + '\t' + "八字五行分数:" + str(bazi_score) + '\r')
        fileOut.write("　　　　　引用诗句：" + str(sentency) + '\r\r')


# '李','王','张',
familyNames = '刘陈杨赵黄周吴徐孙胡朱高林何郭马罗梁宋郑谢韩唐冯于董萧程曹袁邓许傅沈曾彭吕苏卢蒋蔡贾丁魏薛叶阎余潘杜戴夏钟汪田任姜范方石姚谭廖邹熊金陆郝孔白崔康毛邱秦江史顾侯邵孟龙万段漕钱汤尹黎易常武乔贺赖龚文庞樊兰殷施陶洪翟安颜倪严牛温芦季俞章鲁葛伍韦申尤毕聂丛焦向柳邢路岳齐沿梅莫庄辛管祝左涂谷祁时舒耿牟卜路詹关苗凌费纪靳盛童欧甄项曲成游阳裴席卫查屈鲍位覃霍翁隋植甘景薄单包司柏宁柯阮桂闵欧阳解强柴华车冉房边辜吉饶刁瞿戚丘古米池滕晋苑邬臧畅宫来嵺苟全褚廉简娄盖符奚木穆党燕郎邸冀谈姬屠连郜晏栾郁商蒙计喻揭窦迟宇敖糜鄢冷卓花仇艾蓝都巩稽井练仲乐虞卞封竺冼原官衣楚佟栗匡宗应台巫鞠僧桑荆谌银扬明沙薄伏岑习胥保和'
# 读取txt文件，循环调用
file = open("wordIndexOfPoetry.txt")
list = []
index = 3
for familyName in familyNames:
    index = index + 1
    fileOut = open(str(index) + "诗经姓两字取名高分字典_" + familyName + "姓名.txt", "w+")
    while 1:
        line = file.readline()
        if not line:
            break
        pass
        # print(line.split(';'))
        lineconten = line.split('#')
        # 1#柴#['射夫既同，助我举柴']
        nameGrade(familyName, lineconten[1].replace("'", ""), 1, 2019, 9, 28, 4, 5, lineconten[2])
