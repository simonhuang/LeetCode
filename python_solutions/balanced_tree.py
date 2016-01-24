# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	def isBalanced(self, root):
		return self.checkHeight(root) != -1

	def checkHeight(self, root):
		if root == None:
			return 0

		left_height = self.checkHeight(root.left)
		if left_height == -1:
			return -1
		right_height = self.checkHeight(root.right)
		if right_height == -1:
			return -1

		if abs(left_height - right_height) > 1:
			return -1

		return 1 + max(left_height, right_height)

    def isBalancedTopDown(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
        	return True
        left_height = self.checkHeightTopDown(root.left)
        right_height = self.checkHeightTopDown(root.right)

        if abs(left_height - right_height) > 1:
        	return False
        else:
        	return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def checkHeightTopDown(self, root):
    	if root == None:
    		return 0

    	return 1 + max(self.checkHeight(root.left), self.checkHeight(root.right))