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
        if root is None:
        	return

        head = root

        while True:
        	next_head = None
        	cur_node = head
        	while cur_node is not None:
        		if cur_node.left is not None:
        			next_head = cur_node.left
        			break
        		elif cur_node.right is not None:
        			next_head = cur_node.right
        			break
        		cur_node = cur_node.next

        	if next_head is None:
        		break

        	cur_node = head
        	prev_node = None

        	while cur_node is not None:

        		if prev_node is None:
        			if cur_node.left is not None:
        				prev_node = cur_node.left
        				if cur_node.right is not None:
        					prev_node.next = cur_node.right
        					prev_node = cur_node.right
        			elif cur_node.right is not None:
        				prev_node = cur_node.right
        		else:
        			if cur_node.left is not None:
        				prev_node.next = cur_node.left
        				prev_node = cur_node.left
        			if cur_node.right is not None:
        				prev_node.next = cur_node.right
        				prev_node = cur_node.right

        		cur_node = cur_node.next

        	head = next_head
