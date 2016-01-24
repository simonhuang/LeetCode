class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        unique_nums = set(nums)

        return len(unique_nums) < len(nums)