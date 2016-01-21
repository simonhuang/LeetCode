def mergesort(low, high, a):
	if high <= low + 1:
		return

	middle = low + (high - low) / 2
	mergesort(low, middle, a)
	mergesort(middle, high, a)

	merge(low, middle, high, a)

def merge(low, middle, high, a):
	a_copy = list(a)

	index = low
	index1 = low
	index2 = middle

	while index1 < middle and index2 < high:
		if a_copy[index1] < a_copy[index2]:
			a[index] = a_copy[index1]
			index1 = index1 + 1
		else:
			a[index] = a_copy[index2]
			index2 = index2 + 1
		index = index + 1

	while index1 < middle:
		a[index] = a_copy[index1]
		index1 = index1 + 1
		index = index + 1

foo = [5, 6, 2, 4, -5, 324, -23, 34 ,34 ,234 ,5, 2, 345, 12]
mergesort(0, len(foo), foo)
print foo