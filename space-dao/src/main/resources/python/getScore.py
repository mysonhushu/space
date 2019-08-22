#!/usr/bin/python3
import requests
from bs4 import BeautifulSoup

url = 'http://www.guabu.com/xingming/?name='

r = requests.get(url+'胡兴')
soup = BeautifulSoup(r.content, 'html.parser')
print(soup.find('font', {'color':"0000ff", 'face':"Broadway BT,楷体", 'size':"15"}).text)
