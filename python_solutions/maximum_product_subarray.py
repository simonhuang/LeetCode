class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        zero_indices = [-1]
        negatives = [0]
        for i, n in enumerate(nums):
        	if n == 0:
        		zero_indices.append(i)
        		negatives.append(0)
        	elif n < 0:
        		negatives[-1] += 1
        zero_indices.append(len(nums))
        print zero_indices, negatives
        
        max_product = nums[0]
        for i, zero_index in enumerate(zero_indices[:-1]):
        	start_index = zero_index + 1
        	end_index = zero_indices[i+1]

        	if negatives[i] % 2 == 0:
        		product = None
        		for j in range(start_index, end_index):
        		    if product is None:
        		        product = nums[j]
        		    else:
        			    product *= nums[j]
        		max_product = max(max_product, product)
        	else:
        		first_negative = -1
        		last_negative = -1

        		for j in range(start_index, end_index):
        			if nums[j] < 0:
        				first_negative = j
        				break

        		for j in range(end_index - 1, start_index - 1, -1):
        			if nums[j] < 0:
        				last_negative = j
        				break
                
        		product1 = None
        		product2 = None
        		print start_index, first_negative, last_negative, end_index
        		for j in range(first_negative + 1, end_index):
        		    if product1 is None:
        		        product1 = nums[j]
        		    else:
        			    product1 *= nums[j]

        		for j in range(start_index + 1, last_negative):
        		    if product2 is None:
        		        product2 = nums[j]
        		    else:
        			    product2 *= nums[j]
        		print product1, product2
        		max_product = max(max_product, product1, product2)

        return max_product 

