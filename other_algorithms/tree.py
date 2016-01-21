from collections import deque

class Tree:
	def __init__(self, x, left = None, right = None):
		self.val = x
		self.left = left
		self.right = right

	def bfs(self):
		queue = deque([])
		queue.append(self)
		while queue:
			tree = queue.popleft()
			print tree.val
			if tree.left is not None:
				queue.append(tree.left)
			if tree.right is not None:
				queue.append(tree.right)

	def preorder(self):
		print self.val
		if self.left is not None:
			self.left.preorder()
		if self.right is not None:
			self.right.preorder()

	def inorder(self):
		if self.left is not None:
			self.left.inorder()
		print self.val
		if self.right is not None:
			self.right.inorder()

	def postorder(self):
		if self.left is not None:
			self.left.postorder()
		if self.right is not None:
			self.right.postorder()
		print self.val


t0 = Tree(4)
t1 = Tree(5)
t2 = Tree(2, t0, t1)

t3 = Tree(6)
t4 = Tree(7)
t5 = Tree(3, t3, t4)

tree = Tree(1, t2, t5)
if __name__ == '__main__':
	tree.bfs()