class Solution(object):
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        if n <= 0:
        	return []

        init = ''.join(['0' for i in range(n)])

        gray_codes = set([init])
        gray_list = [int(init, 2)]

        last_code = init
        while len(gray_codes) < 2 ** n:
        	for i in range(len(last_code) - 1, -1, -1):
        		new_bit = "0" if last_code[i] == "1" else "1"
        		print last_code[:i] + new_bit + last_code[i+1:]
        		if last_code[:i] + new_bit + last_code[i+1:] not in gray_codes:
        			last_code = last_code[:i] + new_bit + last_code[i+1:]
        			gray_codes.add(last_code)
        			gray_list.append(int(last_code, 2))

        return gray_list