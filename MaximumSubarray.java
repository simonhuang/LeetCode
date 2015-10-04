package leetCode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max_i = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
        	max_i = Math.max(max_i + nums[i], nums[i]);
        	max = Math.max(max, max_i);
        }
        return max;
    }
}
