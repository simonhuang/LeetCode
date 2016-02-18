class Solution(object):
    def countRangeSum(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        if not nums:
        	return 0

        def binary_search_upper(nums, n, start, end):
        	if end < start:
        		return end

        	middle = start + (end - start) / 2

        	if nums[middle] <= n:
        		return binary_search_upper(nums, n, middle + 1, end)
        	else:
        		return binary_search_upper(nums, n, start, middle - 1)

        def binary_search_lower(nums, n, start, end):
        	if end < start:
        		return start - 1

        	middle = start + (end - start) / 2

        	if nums[middle] >= n:
        		return binary_search_lower(nums, n, start, middle - 1)
        	else:
        		return binary_search_lower(nums, n, middle + 1 , end)

    	def merge(nums, start, end, upper, lower):
    		if end <= start + 1:
    			return 1 if nums[start] <= upper and nums[start] >= lower else 0

    		middle = start + (end - start) / 2
    		first = nums[start:middle]
    		second = nums[middle:end]

    		first_sums = list(first)
    		for i in range(len(first) - 2, -1, -1):
    			first_sums[i] += first_sums[i + 1]

    		second_sums = list(second)
    		for i in range(1, len(second)):
    			second_sums[i] += second_sums[i - 1]
    		print second_sums, second

    		second_sums.sort()

    		ranges = 0
    		for f in first_sums:
    			higher_index = binary_search_upper(second_sums, upper - f, 0, len(second_sums) - 1)
    			lower_index = binary_search_lower(second_sums, lower - f, 0, len(second_sums) - 1)
    			ranges += higher_index - lower_index

    		print first_sums, second_sums, ranges

    		return (ranges 
    			+ merge(nums, start, middle, upper, lower) 
    			+ merge(nums, middle, end, upper, lower))

    	return merge(nums, 0, len(nums), upper, lower)
