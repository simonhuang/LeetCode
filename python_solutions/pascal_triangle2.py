class Solution(object):
    def getRow(self, row):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        level = [1]
        if row == 0:
        	return level

        for i in range(row):
        	next_level = [1] * (len(level) + 1)
        	for j in range(1, len(next_level) - 1):
        		next_level[j] = level[j-1] + level[j]
        	level = next_level

        return level
