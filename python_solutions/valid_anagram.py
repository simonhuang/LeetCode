class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        chars = {}

        for s in p:
        	if s in chars:
        		chars[s] += 1
        	else:
        		chars[s] = 1

        for s in q:
        	if s in chars:
        		if chars[s] > 1:
        			chars[s] -= 1
        		else:
        			chars.pop(s)
        	else:
        		return False

        return len(chars) == 0