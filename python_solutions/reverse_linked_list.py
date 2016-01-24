# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
        	return head

        new_head = head
        head = head.next
        new_head.next = None

        while head is not None:
        	next_head = head.next
        	head.next = new_head
        	new_head = head
        	head = head.next

        return new_head
