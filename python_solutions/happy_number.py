class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        visited = set()

        visited.add(n)

        while True:
        	if n == 1:
        		return True
        	new_n = 0

        	for c in str(n):
        		new_n += int(c) ** 2

        	n = new_n
        	if n in visited:
        		return False
        	else:
        		visited.add(n)

        return False
