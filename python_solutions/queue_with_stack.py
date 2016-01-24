class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.push_stack = []
        self.pop_stack = []
        

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.push_stack.append(x)
        

    def pop(self):
        """
        :rtype: nothing
        """
        if not self.pop_stack:
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())
        self.pop_stack.pop()
        

    def peek(self):
        """
        :rtype: int
        """
        if self.pop_stack:
            return self.pop_stack[-1]
        else:
            while self.push_stack:
                self.pop_stack.append(self.push_stack.pop())
            return self.pop_stack[-1]

        

    def empty(self):
        """
        :rtype: bool
        """
        return not self.push_stack and not self.pop_stack
        