class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return self.generate_permutation(nums, [])
    
    def generate_permutation(self, nums, sequence):
    	if not nums:
    		return sequence

    	permutations = []
    	for i in range(len(nums)):
    		new_sequence = sequence[:].append(nums[i])
    		new_nums = nums[:i].append(nums[i+1:])
    		permutations.append(generate_permutation(new_nums, new_sequence))

    	return permutations
