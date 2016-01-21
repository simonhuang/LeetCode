class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        length = len(nums) - 1
        index = 0

        while index <= length:
        	if nums[index] == val:
        		nums[index] = nums[length]
        		nums[length] = None
        		length = length - 1
        	else:
        		index = index + 1

        return length + 1

    def removeElementInplace(self, nums, val):
    	for i, n in enumerate(nums):
    		if n == val:
    			print n, val
    			nums[i] = None
    	index = 0
    	print nums
    	for i, n in enumerate(nums):
    		if n is None:
    			continue
    		else:
    			nums[i] = nums[index]
    			nums[index] = n
    			index = index + 1

    	return index

s = Solution()
nums = [2]
print s.removeElementInplace(nums, 3)
print nums