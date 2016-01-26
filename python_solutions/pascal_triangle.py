class Solution(object):
    def generate(self, rows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if rows == 0:
        	return []

        triangle = [[1]]

        for i in range(1, rows):
        	level = [1] * (i + 1)
        	for j in range(1, len(level) - 1):
        		level[j] = triangle[i-1][j-1] + triangle[i-1][j]
        	triangle.append(level)

        return triangle