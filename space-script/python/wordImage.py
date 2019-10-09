#!/usr/bin/python3

from wordcloud import WordCloud
import matplotlib.pyplot as plt 
import jieba

path_text = "/home/huxing/my-repo/space/space-script/shijin.txt"
f = open(path_text,'r', encoding='UTF-8').read()
cut_text = " ".join(jieba.cut(f))
print(cut_text)
wordcloud = WordCloud(font_path="/home/huxing/my-repo/space/space-script/chinese.stsong.ttf", width=1000, height=880).generate(cut_text)

plt.imshow(wordcloud, interpolation="bilinear")
plt.axis("off")
plt.show()
