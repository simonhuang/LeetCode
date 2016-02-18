class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """

        def binary_search(nums, target, start, end):
        	if end < start:
        		return -1

        	middle = start + (end - start) / 2

        	if nums[middle] == target:
        		return middle

        	elif nums[middle] > target:
        		if nums[start] <= nums[middle]:
        			if nums[start] <= target:
        				return binary_search(nums, target, start, middle - 1)
        			else:
        				return binary_search(nums, target, middle + 1, end)
        		else:
        			return binary_search(nums, target, start, middle - 1)

        	else:
        		if nums[middle] <= nums[end]:
        			if nums[end] >= target:
        				return binary_search(nums, target, middle + 1, end)
        			else:
        				return binary_search(nums, target, start, middle - 1)
        		else:
        			return binary_search(nums, target, middle + 1, end)

    	return binary_search(nums, target, 0, len(nums) - 1)
