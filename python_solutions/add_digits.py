class Solution(object):
    def addDigitsOrig(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num < 10:
        	return num

        num = str(num)
        total = 0
        for d in num:
        	total += int(d)
        return self.addDigits(total)

    def addDigits(self, num):
    	if num < 10:
            return num
        
        total = 0
        while num > 0:
        	total += num % 10
        	num /= 10

        return self.addDigits(total)

s = Solution()
print s.addDigits(10)