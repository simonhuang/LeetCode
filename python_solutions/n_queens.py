import copy
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [['.' for i in range(n)] for i in range(n)]
        print board
        return self.place_queens(board, n, n)
       
    def place_queens(self, board, n_left, n):
    	if n_left == 0:
    		rows = []
    		for i, row in enumerate(board):
    			board[i] = map(lambda x: '.' if x == '#' else x, row)
    		for row in board:
    			rows.append(''.join(row))
    		return [rows]


    	boards = []
    	row = n - n_left
    	for i in range(n):
    		if board[row][i] != '#':
    			new_board = copy.deepcopy(board)
    			new_board[row][i] = 'Q'
    			for j in range(row + 1, n):
    				new_board[j][i] = '#'

    			offset = 1
    			while row + offset < n and i - offset >= 0:
    				new_board[row + offset][i - offset] = '#'
    				offset += 1
    			offset = 1
    			while row + offset < n and i + offset < n:
    				new_board[row + offset][i + offset] = '#'
    				offset += 1

    			boards.extend(self.place_queens(new_board, n_left - 1, n))
    	return boards