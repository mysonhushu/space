#!/usr/bin/python3

list1 = None
list2 = None
with open('convert.sh') as f:
    list1 = f.readlines()
with open('convert2.sh') as f:
    list2 = f.readlines()

file3 = open('convert3.sh','w') 

for line in list2:
    if line not in list1:
       file3.write(line) 
file3.close()
