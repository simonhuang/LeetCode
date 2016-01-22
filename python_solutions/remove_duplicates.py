class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        index = 0
        cur_num = None
        for i, n in enumerate(nums):
        	if cur_num != n:
        		cur_num = n
        		nums[index] = n
        		index = index + 1

        for i in range(index, len(nums)):
        	print 'wtf'
        	nums[i] = None

        return index + 1

a = [1, 1, 1, 2, 2, 3, 4, 5, 5, 6]
a = []
s = Solution()
s.removeDuplicates(a)
print a