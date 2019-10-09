#!/usr/bin/python3
import operator
import re

pattern = r'。|；|！'
frequency = {}
wordSentency = {}
with open('shijin.txt') as f:
    lineList = f.readlines()
    for line in lineList:
        if "=" in line:
            continue
        else:
            sens = re.split(pattern, line)
            for sen in sens: 
                for word in sen:
                    if word not in frequency:
                        frequency[word] = 1
                    else:
                        frequency[word] += 1
                    if word not in wordSentency:
                        sentency = []
                        sentency.append(sen)
                        wordSentency[word] = sentency 
                    else:
                        sentency = wordSentency[word]
                        sentency.append(sen)
                        wordSentency[word] = sentency 
                    
sorted_x = sorted(frequency.items(), key=operator.itemgetter(1))
for k,v in sorted_x:
    print(str(v)+'#'+ k + '#' + str(wordSentency[k]) + '\r')
