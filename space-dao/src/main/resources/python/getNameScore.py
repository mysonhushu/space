#!/usr/bin/python3
import requests
import json

url = 'https://www.sheup.com/xingming_dafen.php'
payload = {"xingx":"%BA%FA", "mingx":"%D7%D3%D0%A6","xingmingceshi":"%D0%D5%C3%FB%B2%E2%CA%D4%B4%F2%B7%D6"}

headers = {
"Host": "www.sheup.com",
"Connection": "keep-alive",
"Content-Length": 82,
"Cache-Control": "max-age=0",
"Origin": "https://www.sheup.com",
"Upgrade-Insecure-Requests": 1,
"Content-Type": "application/x-www-form-urlencoded",
"User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36",
"Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
"Referer": "https://www.sheup.com/xingming_dafen.php",
"Accept-Encoding": "gzip, deflate, br",
"Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7"
        }


r = requests.post(url, files=payload, headers=headers)
#page = r.text.encode('GB2312', 'ignore')
content = str(r.content)
print(content)
print(bytes(content,'iso-8859-1').decode('gb2312'))
print(str(r.apparent_encoding))
print(str(r.encoding))
