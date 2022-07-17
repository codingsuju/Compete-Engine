#!/usr/bin/python3
out=open('output.txt','r')
lines=out.readlines()
out.close()
out=open('output.txt','w+')
n=len(lines)
for i in range(6,n-2):
   out.write(lines[i])
out.close()
