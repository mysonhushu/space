#!/usr/bin/python3

import urllib.request


headers = {
        'accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8',
        'accept-encoding': 'gzip, deflate, br',
        'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8,zh-TW;q=0.7',
        'cache-control': 'max-age=0',
        'cookie': 'abgroup=control; __cfduid=dc00d0022a6189975e5cfc9f454ec5d5c1565948380; country=CN; campaign=google.com; visited=1; _ga=GA1.2.33082111.1565948388; _gid=GA1.2.300761756.1565948388; _ga=GA1.1.33082111.1565948388; _gid=GA1.1.300761756.1565948388; _gat=1',
        'upgrade-insecure-requests': 1,
        'user-agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36'
        }

url = r'https://newsapi.org/v2/everything?q=bitcoin&from=2019-07-16&sortBy=publishedAt&apiKey=API_KEY'
req = urllib.request.Request(url=url, headers=headers)
res = urllib.request.urlopen(req)
html = res.read().decode('utf-8')
print(html)
