from collections import deque
class Stack(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.queue1 = deque()
        self.queue2 = deque()
        self.active = 1

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        if self.active == 1:
            self.queue1.append(x)
        else:
            self.queue2.append(x)
        

    def pop(self):
        """
        :rtype: nothing
        """
        if self.active == 1:
            while len(self.queue1) > 1:
                self.queue2.append(self.queue1.popleft())
            self.active = 2
            self.queue1.popleft()
        else:
            while len(self.queue2) > 1:
                self.queue1.append(self.queue2.popleft())
            self.active = 1
            self.queue2.popleft()
        

    def top(self):
        """
        :rtype: int
        """

        if self.active == 1:
            while len(self.queue1) > 1:
                self.queue2.append(self.queue1.popleft())
            self.active = 2
            n = self.queue1[0]
            self.queue2.append(self.queue1.popleft())
        else:
            while len(self.queue2) > 1:
                self.queue1.append(self.queue2.popleft())
            self.active = 1
            n = self.queue2[0]
            self.queue1.append(self.queue2.popleft())
        return n
        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.queue1 and not self.queue2

