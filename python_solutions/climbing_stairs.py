class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
        	return 1
        
        ways_to_climb = [0] * (n+1)
        ways_to_climb[0] = 1
        ways_to_climb[1] = 1

        for i in range(2, n+1):
        	ways_to_climb[i] = ways_to_climb[i-1] + ways_to_climb[i-2]
        return ways_to_climb[n]