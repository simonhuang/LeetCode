package leetCode;
import java.util.*;
public class Permutation {
	public static void main (String [] args){
		Permutation p = new Permutation();
		int []nums = {1, 2, 3, 4};
		List<List<Integer>> test = p.permuteUnique(nums);
		System.out.println(test);
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
        List<List<Integer>> p = new ArrayList<List<Integer>>();
        Set<Integer> used = new HashSet<Integer>();
        List<Integer> current = new ArrayList<Integer>();
        permute_unique_helper(p, used, current, nums);
        return p;
    }
	public void permute_unique_helper(List<List<Integer>> p, Set<Integer> used, List<Integer> current, int []nums){
    	if (used.size() == nums.length){
    		p.add(current);
    		return;
    	}
    	for (int i=0;i<nums.length;i++){
    		if (!used.contains(i)){
    			Set<Integer> new_used = new HashSet<Integer>(used);
    			new_used.add(i);
    			
    			List<Integer> new_current = new ArrayList<Integer>(current);
    			new_current.add(nums[i]);
    			permute_unique_helper(p, new_used, new_current, nums);
    			
    			int index = 1;
    			if (i+index > nums.length - 1) return;
    			while (nums[i+index] == nums[i]){
    				index++;
    				if (i+index > nums.length - 1) return;
    			}
    			i = i+index-1;
    		}
    	}
    }
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> p = new ArrayList<List<Integer>>();
        Set<Integer> used = new HashSet<Integer>();
        List<Integer> current = new ArrayList<Integer>();
        permute_helper(p, used, current, nums);
        return p;
    }
    public void permute_helper(List<List<Integer>> p, Set<Integer> used, List<Integer> current, int []nums){
    	if (used.size() == nums.length){
    		p.add(current);
    		return;
    	}
    	for (int i=0;i<nums.length;i++){
    		if (!used.contains(i)){
    			Set<Integer> new_used = new HashSet<Integer>(used);
    			new_used.add(i);
    			
    			List<Integer> new_current = new ArrayList<Integer>(current);
    			new_current.add(nums[i]);
    			permute_helper(p, new_used, new_current, nums);
    		}
    	}
    }
}
