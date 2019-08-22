#!/usr/bin/python3

content = []
with open('shijin.txt') as f:
   content = f.readlines()
content = [x.strip() for x in content]


negativeDict = {} 
with open('negative.txt') as f:
    negative = f.readlines()
    for line in negative:
        values = line.split(",")
        negativeDict.update({values[0]: values[1]})

positiveDict = {} 
with open('positive.txt') as f:
    positive = f.readlines()
    for line in positive:
        values = line.split(",")
        positiveDict.update({values[0]: values[1]})

fileOut = open('shijinScore.txt', 'w')

for line in content:
    score = 0
    for word in line:
       #print(word)
       if word in negativeDict:
           score = score - 1  
       if word in positiveDict:
           score = score + 1 
    fileOut.write(line +","+str(score)+ "\n")
    if score > 2:
        print(str(score) +"   " +line)
