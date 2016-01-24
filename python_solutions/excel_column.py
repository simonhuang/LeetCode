class Solution(object):
    def titleToNumber(self, s):
        """
        :type s: str
        :rtype: int
        """
        col = 0
        factor = 1
        for c in reversed(s):
        	col += (ord(c) - ord('A') + 1) * factor
        	factor *= 26

        return col