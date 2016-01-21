import sys

f = file('test.txt', 'r')
temp = f.read().splitlines()
print temp
f.close()