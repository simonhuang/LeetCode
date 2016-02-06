class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [1] + [n for n in nums if n > 0] + [1]
        cache = {}
        def popBalloons(nums, left, right):
        	if (left, right) in cache:
        		return cache[(left, right)]

        	if left > right:
        		return 0

        	if left == right:
        		return nums[left-1] * nums[right+1] * nums[left]

        	best = 0
        	for i in range(left, right+1):
        		best = max(best, 
        			popBalloons(nums, left, i-1) + popBalloons(nums, i+1, right)
        			+ nums[left-1] * nums[i] * nums[right+1])
        	cache[(left, right)] = best
        	return best
        return popBalloons(nums, 1, len(nums)-2)