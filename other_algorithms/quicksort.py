def quicksort(low, high, a):
	if high <= low:
		return

	pivot = a[low]
	index = high - 1
	final_index = high - 1

	while index > 0:
		if a[index] > pivot:
			temp = a[index]
			a[index] = a[final_index]
			a[final_index] = temp
			final_index = final_index - 1
		index = index - 1

	a[low] = a[final_index]
	a[final_index] = pivot

	quicksort(low, final_index, a)
	quicksort(final_index + 1, high, a)

foo = [5, 6, 2, 4, -5, 324, -23, 34 ,34 ,234 ,5, 2, 345, 12]
quicksort(0, len(foo), foo)
print foo