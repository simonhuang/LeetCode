# Definition for binary tree with next pointer.
# class TreeLinkNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution(object):
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        def connect_node(node, next):
        	node.next = next
        	if node.left is not None and node.right is not None:
        		connect_node(node.left, node.right)
        		if next is not None:
        			if next.left is not None:
        				connect_node(node.right, next.left)
        			else:
        				connect_node(node.right, next.right)
        		else:
        			connect_node(node.right, None)
        	elif node.left is not None or node.right is not None:
        		child = node.left
        		if node.right is not None:
        			child = node.right

        		if next is not None:
        			if next.left is not None:
        				connect_node(child, next.left)
    				elif next.right is not None:
        				connect_node(child, next.right)
        			else:
        				
        		else:
        			connect_node(child, None)

        if root is not None:
        	connect_node(root, None)