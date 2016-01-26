# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        queue = []
        next_level = []

        if root is None:
            return []

        in_order_list = []

        queue.append(root)


        while True:
            cur_level = []
            while queue:
                node = queue.pop(0)
                print node
                cur_level.append(node.val)
                if node.left is not None:
                    next_level.append(node.left)
                if node.right is not None:
                    next_level.append(node.right)
            print cur_level
            in_order_list.append(cur_level)
            if not next_level:
                break
            queue = next_level
            next_level = []
        in_order_list.reverse()
        return in_order_list
        