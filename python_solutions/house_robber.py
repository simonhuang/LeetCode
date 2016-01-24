class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
        	return 0

        money = [0] * len(nums)

       	money[0] = nums[0]
       	if len(nums) == 1:
       		return money[0]

       	money[1] = max(nums[0], nums[1])

       	for i in range(2, len(nums)):
       		money[i] = max(money[i-1], money[i-2] + nums[i])

       	return money[-1]

    def rob_slow(self, nums):
    	return self.rob_recursive(self, nums, len(nums))

    def rob_recursive(self, nums, n):
    	if n == 0:
    		return 0

    	if n == 1:
    		return nums[0]
    	if n == 2:
    		return max(nums[0], nums[1])

    	else:
    		return max(self.rob_recursive(nums, n-1), nums[n-1] + self.rob_recursive(nums, n-2))