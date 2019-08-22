#!/usr/bin/python3
import operator
import re

pattern = r'。|；|！'
frequency = {}
wordSentency = {}
prevousWord = None
with open('shijin.txt') as f:
    lineList = f.readlines()
    for line in lineList:
        prevousWord = None
        if "=" in line:
            continue
        else:
            sens = re.split(pattern, line)
            for sen in sens:
                sen = sen.replace('\\','').replace('n','')
                sentency = sen.replace('，','').replace('\n','').replace('n','').replace('？','').replace(' ','')
                for word in sentency:
                    value = word 
                    if prevousWord is None:
                        prevousWord = word
                        continue
                    else: 
                        value = prevousWord + word 
                    if value not in frequency:
                        frequency[value] = 1
                    else:
                        frequency[value] += 1
                    if value not in wordSentency:
                        sentency = []
                        sentency.append(sen)
                        wordSentency[value] = sentency
                    else:
                        sentency = wordSentency[value]
                        sentency.append(sen)
                        wordSentency[value] = sentency
                    prevousWord = word    
sorted_x = sorted(frequency.items(), key=operator.itemgetter(1))
for k,v in sorted_x:
    print(str(v)+'#'+k+'#'+str(wordSentency[k]) + '\r')
