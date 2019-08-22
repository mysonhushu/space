#!/usr/bin/python3

heavenlyStreams = ["甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"]
earthlyBranches = ["子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"] 

m = 0
n = 0
for i in range(0,60):
   print('"'+heavenlyStreams[m%10] + earthlyBranches[n%12]  + '",', end =' ')
   m = m + 1
   n = n + 1
