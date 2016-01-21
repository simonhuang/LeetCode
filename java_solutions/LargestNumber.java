package leetCode;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String [] s = new String [nums.length];
        for (int i=0;i<nums.length;i++){
        	s[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(s);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length;i--){
        	sb.append(s[i]);
        }
        return sb.toString();
    }
}
