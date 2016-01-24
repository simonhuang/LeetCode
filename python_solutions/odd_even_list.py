# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def oddEvenList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
        	return head

        elif head.next is None:
        	return head

        odds = head
        odds_tail = odds

        evens = head.next
        evens_tail = evens

       	head = head.next.next

       	count = 1
       	while head is not None:
       		if count % 2 == 1:
       			odds_tail.next = head
       			odds_tail = odds_tail.next
       		else:
       			evens_tail.next = head
       			evens_tail = evens_tail.next
       		head = head.next
       		count += 1

        evens_tail.next = None
       	odds_tail.next = evens
       	return odds