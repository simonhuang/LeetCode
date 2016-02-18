# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
        	return 0

        max_path, max_child = max_sum(root)

        return max(max_path, max_child)

        def max_sum(root):
        	if root.left is None and root.right is None:
        		return root.val
        	elif root.left is None:
        		max_path, max_child = max_sum(root.right)
        		max_path += root.val
        		max_child = max(max_path, max_child)
        		return max_path, max_child
        	elif root.right is None:
        		max_path, max_child = max_sum(root.left)
        		max_path += root.val
        		max_child = max(max_path, max_child)
        		return max_path, max_child

        	max_path_left, max_child_left = max_sum(root.left)
        	max_path_right, max_child_right = max_sum(root.left)

        	max_path = max(max_path_left, max_path_right) + root.val
        	max_child = max(max_child_left, max_child_right, 
        		max_path_left + max_path_right + root.val)

        	return max_path, max_child
