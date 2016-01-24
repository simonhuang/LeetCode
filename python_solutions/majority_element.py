class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        num_count = {}

        for n in nums:
        	if n in num_count:
        		num_count[n] += 1
        	else:
        		num_count[n] = 1

        threshold = len(nums) / 2
        for key in num_count:
        	if num_count[key] > threshold:
        		return key

        return None
