class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
    	s = str(x)
    	if x < 0:
    		reverse = s[:0:-1]
    		reverse = int('-' + reverse)
    	else:
    		reverse = s[::-1]
    		reverse = int(reverse)


        if reverse > 2 ** 31 - 1 or reverse < -(2**31):
        	return 0
    	return reverse
