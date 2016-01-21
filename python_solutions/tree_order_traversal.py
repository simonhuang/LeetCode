from collections import deque
class Tree(object):
    def __init__(self, x, left = None, right = None):
        self.val = x
        self.left = left
        self.right = right

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

t0 = Tree(4)
t1 = Tree(5)
t2 = Tree(2, t0, t1)

t3 = Tree(6)
t4 = Tree(7)
t5 = Tree(3, t3, t4)

tree = Tree(1, t2, t5)

s = Solution()
s.levelOrderBottom(tree)

        