# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """


        if k < 2:
        	return head

        cur_head = head
        cur_tail = None
        head = None
        cur_node = cur_head

        while self.contains_k(cur_node, k):
        	new_head, new_tail, cur_node = self.reverse(cur_node, k)
        	if head is None:
        		head = new_head
        	if cur_tail is None:
        		cur_tail = new_tail
        	else:
        		cur_tail.next = new_head
        		cur_tail = new_tail
        	cur_tail.next = cur_node

        return cur_head if head is None else head

    def contains_k(self, head, k):
		count = 0
		while head is not None:
			count += 1
			head = head.next

		return count >= k
		
	def reverse(self, cur_node, k):
		next_node = cur_node.next
		next_next_node = next_node.next

		new_tail = cur_node
		new_tail.next = None

		while k > 2:
			next_node.next = cur_node
			cur_node = next_node
			next_node = next_next_node
			next_next_node = next_next_node.next
			k -= 1

		new_head = next_node
		next_node.next = cur_node

		return new_head, new_tail, next_next_node

		



