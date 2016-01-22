class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        factor = 5
        zeros = 0

        while factor <= n:
            zeros += n / factor
            factor *= 5
        return zeros
s = Solution()
print s.trailingZeroes(1000)