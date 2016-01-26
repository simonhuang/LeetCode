# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if root is None:
        	return False

        return self.hasPath(root, sum)

    def hasPath(self, root, sum):
        if root is None:
        	return sum == 0

        if root.left and root.right is None:
    		return self.hasPath(root.left, sum - root.val) 
    	elif root.left is None:
    		return self.hasPath(root.right, sum - root.val)
    	elif root.right is None:
    		return self.hasPath(root.left, sum - root.val)
    	else:
    		return (
    			self.hasPath(root.left, sum - root.val)
    			or self.hasPath(root.right, sum - root.val)
    			)