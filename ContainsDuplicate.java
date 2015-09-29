package leetCode;
import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i=0;i<nums.length;i++){
        	if (set.contains(nums[i])){
        		return false;
        	} else {
        		set.add(nums[i]);
        	}
        }
        return true;
    }
}
