package leetCode;
import java.util.*;
public class MinimumSizeSubarraySum {
	public static void main (String [] args){
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
		int [] a = {1, 2, 3, 4, 5};
		System.out.println(m.minSubArrayLen(11, a));
	}
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums.length == 0){
    		return 0;
    	}
    	int sum = 0;
    	int low = 0;
    	int high = 0;
    	int n = nums.length;
        for (int i=0;i<n;i++){
        	sum += nums[i];
        	if (sum >= s){
        		high = i;
        		break;
        	}
        	if (i == n){
        		return 0;
        	}
        }
        
        if (high == n-1){
        	while (sum - nums[low] >= s){
        		sum -= nums[low];
        		low ++;
        	}
        } else {
	        while (true){
	        	while (sum - nums[low] >= s){
	        		sum -= nums[low];
	        		low ++;
	        	}
	        	if (high + 1 >= n){
	        		break;
	        	}
	        	high ++;
	        	low ++;
	        	sum += nums[high];
	        	sum -= nums[low-1];
	        }
	    }
        return high - low + 1; 
    }
}
