package leetCode;

import java.util.Arrays;

public class KthLargest {
	public static void main (String [] args){
		int [] a = {3, 5, 7, 2, 1};
		System.out.println(findKthLargest(a, 2));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		for (int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
		return nums[nums.length - k];
    }
}
