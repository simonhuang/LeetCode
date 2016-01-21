import fileinput

def binary_search(low, high, value, list):
	print low, high
	if high < low:
		return -1

	middle = low + (high - low) / 2
	if value == list[middle]:
		return middle
	elif value < list[middle]:
		return binary_search(low, middle-1, value, list)
	else:
		return binary_search(middle+1, high, value, list)

a = [0, 3, 7, 8, 9, 10]

for line in fileinput.input()
	pass
	
print binary_search(0, len(a)-1, 5, a)