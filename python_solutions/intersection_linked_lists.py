# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        pointer_a = headA
        pointer_b = headB

        length_a = 0
        length_b = 0

        while pointer_a is not None:
        	length_a += 1
        	pointer_a = pointer_a.next

        while pointer_b is not None:
        	length_b += 1
        	pointer_b = pointer_b.next

        pointer_a = headA
        pointer_b = headB

        for i in range(0, abs(length_b - length_a)):
        	if length_a > length_b:
        		pointer_a = pointer_a.next
        	else:
        		pointer_b = pointer_b.next

        while pointer_a is not None:
        	if pointer_a == pointer_b:
        		return pointer_a
        	else:
        		pointer_a = pointer_a.next
        		pointer_b = pointer_b.next

        return None