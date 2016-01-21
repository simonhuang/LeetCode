
f = open('knapsack.txt', 'r')

input = f.read().splitlines()

capacity = int(input[0])
items = int(input[1])
for i in range(items):
	