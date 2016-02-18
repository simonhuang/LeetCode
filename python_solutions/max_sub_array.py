class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        best = nums[0]
        best_current = nums[0]

       	for n in nums[1:]:
       		best_current = max(best_current + n, n)
       		best = max(best, best_current)
       	return best