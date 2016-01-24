# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        merged = None

        if l1 is None or l2 is None:
        	if l1 is None:
        		return l2
        	if l2 is None:
        		return l1

        if l1.val < l2.val:
        	merged = l1
        	l1 = l1.next
        else:
        	merged = l2
        	l2 = l2.next

        merged_tail = merged

        while l1 is not None and l2 is not None:
        	if l1.val < l2.val:
        		merged_tail.next = l1
        		l1 = l1.next
        	else:
        		merged_tail.next = l2
        		l2 = l2.next
        	merged_tail = merged_tail.next

        if l1 is None:
        	merged_tail.next = l2
        else:
        	merged_tail.next = l1
        return merged
