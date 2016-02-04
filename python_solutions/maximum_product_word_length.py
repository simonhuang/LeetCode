class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        max_product = 0

        for i, w1 in enumerate(words):
        	for j, w2 in enumerate(words[i+1:]):
        		if not self.commonLetters(w1, w2):
        			max_product = max(len(w1) * len(w2), max_product)
        
        return max_product



    def commonLetters(self, s1, s2):
    	letters = set()
    	for c in s1:
    		letters.add(c)

    	for c in s2:
    		if c in letters:
    			return True

    	return False