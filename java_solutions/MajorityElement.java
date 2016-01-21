package leetCode;
import java.util.*;
public class MajorityElement {
    public int majorityElement(int[] nums) {
    	if (nums.length <= 2){
    		return nums[0];
    	}
    	HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
    	for (int i=0;i<nums.length;i++){
    		if (elements.containsKey(nums[i])){
    			int count = elements.get(nums[i]);
    			if (count+1 > nums.length / 2){
    				return nums[i];
    			}
    			elements.put(nums[i], count+1);
    		} else {
    			elements.put(nums[i], 1);
    		}
    	}
    	return -1;
    }
}
