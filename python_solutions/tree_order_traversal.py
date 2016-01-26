
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if root is None:
            return []

        tree_level = [root]
        next_level = []

        num_level = []
        levels = []

        while tree_level:
            node = tree_level.pop(0)
            num_level.append(node.val)

            if node.left is not None:
                next_level.append(node.left)
            if node.right is not None:
                next_level.append(node.right)

            if not tree_level:
                tree_level = next_level
                next_level = []
                levels.append(num_level)
                num_level = []
        return levels