#!/usr/bin/python3
import requests
import json

url = 'https://m.shensuantang.com/xingming/index/xingming.html?xing=%E8%83%A1&ming=%E5%A4%A9%E7%8E%8B&bihua=1'
payload = {"xs":"胡", "mz":"薄","action":"test"}

headers = {
        "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
        "Accept-Encoding": "gzip, deflate, br",
        "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7",
        "Cache-Control": "max-age=0",
        "Connection": "keep-alive",
        "Content-Length": 37,
        "Content-Type": "application/x-www-form-urlencoded",
        "Cookie": "PHPSESSID=d8b4iftle7te1v2khejeos3nk25tco7o",
        "Host": "www.xingming.com",
        "Origin": "https://m.shensuantang.com",
        "Referer": "https://m.shensuantang.com/xingming/index/index.html",
        "Upgrade-Insecure-Requests": 1,
        "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36"
        }


r = requests.get(url, headers=headers)
#page = r.text.encode('GB2312', 'ignore')
content = str(r.content)
print(content)
print(bytes(content,'iso-8859-1').decode('gb2312'))
print(str(r.apparent_encoding))
print(str(r.encoding))
