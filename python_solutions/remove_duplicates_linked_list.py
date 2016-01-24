# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
        	return None
        tail = head
        node = head.next

        while node is not None:
        	if tail.val != node.val:
        		tail.next = node
        		tail = tail.next
    		node = node.next
    	tail.next = None

    	return head
