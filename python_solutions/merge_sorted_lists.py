import heapq
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None



class Solution(object):
    class Node(object):
        def __init__(self, val, index):
            self.val = val
            self.index = index
        def __cmp__(self, other):
            return cmp(self.val, other.val)
        def __str__(self):
            return '%d %d' % (self.val, self.index)
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap = []

        for i, l in enumerate(lists):
            if l is not None:
                heapq.heappush(heap, self.Node(l.val, i))
                lists[i] = l.next

        merged = None
        cur_node = None
        while heap:
            node = heapq.heappop(heap)
            if merged is None:
                merged = ListNode(node.val)
                cur_node = merged
            else:
                cur_node.next = ListNode(node.val)
                cur_node = cur_node.next

            if lists[node.index] is not None:
                heapq.heappush(heap, self.Node(lists[node.index].val, node.index))
                lists[node.index] = lists[node.index].next
        return merged

a = [ListNode(1)]
s = Solution()
merged = s.mergeKLists(a)
print merged