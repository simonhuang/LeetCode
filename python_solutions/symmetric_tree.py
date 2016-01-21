from collections import deque
import copy

class Tree(object):
    def __init__(self, x, left = None, right = None):
        self.val = x
        self.left = left
        self.right = right

class Solution(object):
	 def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
        	return True

        return isFlipped(root.left, root.right)

    def isFlipped(self, t1, t2):
    	if t1 is None or t2 is None:
    		return t1 is None and t2 is None
    		
    	if t1.val != t2.val:
    		return False

    	return self.isFlipped(t1.left, t2.right) and self.isFlipped(t1.right, t2.left)


    def isSymmetric_orig(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        flipped = self.flip(copy.deepcopy(root))
        return isEqual(root, flipped)

    def isEqual(self, root, flipped):
    	if root is None or flipped is None:
    		return root is None and flipped is None

    	if root.val != flipped.val:
    		return False

    	return isEqual(root.left, flipped.left) and isEqual(root.right, flipped.right)

    def flip(self, root):
    	if root is None:
    		return None
    	left = root.left
    	right = root.right
    	root.left = self.flip(right)
    	root.right = self.flip(left)
    	return root

    def bfs(self,root):
    	queue = deque()
    	if root is None:
    		return
    	queue.append(root)

    	while queue:
    		cur_tree = queue.popleft()
    		if cur_tree is None:
    			continue
    		print cur_tree.val
    		queue.append(cur_tree.left)
    		queue.append(cur_tree.right)


t0 = Tree(4)
t1 = Tree(5)
t2 = Tree(2, t0, t1)

t3 = Tree(6)
t4 = Tree(7)
t5 = Tree(3, t3, t4)

tree = Tree(1, t2, t5)

s = Solution()
s.isSymmetric(tree)