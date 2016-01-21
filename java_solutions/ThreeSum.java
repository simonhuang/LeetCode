package leetCode;
import java.util.*;

public class ThreeSum {
	public static void main (String [] args){
		int a[] = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(a));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<3) return result;
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int low = i+1;
            int high = nums.length - 1;
            while(low<high){
                if(nums[i] + nums[low] + nums[high] == 0){
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while(i+1<nums.length && nums[i+1]==nums[i]) i++;
                    while(low+1<nums.length && nums[low]==nums[low+1]) low++;
                    while(high-1>=0 && nums[high]==nums[high-1]) high--;
                    low++;
                    high--;
                } else if(nums[i]+nums[low]+nums[high]>0) high--;
                else low++;
            }
        }
        return result;
    }
	
	public static List<List<Integer>> threeSumSlow(int[] num) {
		
        Set<List<Integer>> triplets = new HashSet<List<Integer>>();
        
        HashMap<Integer,Integer> num_set = new HashMap<Integer,Integer>();
        
        for (int i=0;i<num.length;i++){
            num_set.put(num[i], i);
        }
        
        for (int i=0;i<num.length-1;i++){
            for (int j=i+1;j<num.length;j++){
                if (num_set.containsKey(-1 * (num[i]+num[j]))){
                    int cur_index = num_set.get(-1 * (num[i]+num[j]));
                    if (cur_index != i && cur_index != j){

                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(num[i]);
                        triplet.add(num[j]);
                        triplet.add(num[cur_index]);
                        
                        Collections.sort(triplet);
                        triplets.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(triplets);
    }
}
