class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        N = len(nums)
        nums = [1] + nums + [1]
        def cache(f):
            print "cache called"
            c = {}
            def g(*args):
                print "g called"
                if args not in c:
                    c[args] = f(*args)
                return c[args]
            return g
        @cache
        def coins(L, R):
            print "coins called"
            if L > R:
                return 0
            if L == R:
                return nums[L-1] * nums[R+1] * nums[L]
            best = 0
            for mid in range(L, R+1):
                best = max(best, coins(L, mid-1) + coins(mid+1, R) + nums[L-1] * nums[R+1] * nums[mid])
            return best
        
        return coins(1, N)

print Solution().maxCoins([3, 1, 5, 8])