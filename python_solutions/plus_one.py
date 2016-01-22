class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        index = len(digits) - 1
        while index >= 0:
            if digits[index] == 9:
                digits[index] = 0
            else:
                break
        if digits[0] == 0:
            digits.insert(0, 1)
        
        return digits