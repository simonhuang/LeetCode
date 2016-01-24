class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        weight = 0

        while n > 0:
        	weight += n % 2
        	n /= 2
        return weight