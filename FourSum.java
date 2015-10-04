package leetCode;
import java.util.*;
public class FourSum {
	public static void main (String [] args){
		FourSum f = new FourSum();
		int [] s = {1, 0, -1, 0, -2, 2};
		System.out.println(f.fourSum(s, 0));
	}
	class Pair {
		int index1;
		int index2;
		public Pair(int index1, int index2){
			this.index1 = index1;
			this.index2 = index2;
		}
		public int hashCode(){
			int hash = 17;
			hash = hash * 31 + index1;
			hash = hash * 31 + index2;;
			return hash;
		}
		public boolean equals(Object o){
			if (!(o instanceof Pair)){
				return false;
			} 
			if (o == this){
				return true;
			}
			Pair p = (Pair)o;
			return (p.index1 == this.index1 && p.index2 == this.index2)
					|| (p.index1 == this.index2 && p.index2 == this.index1);
		}
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Set<List<Integer>> results = new HashSet<List<Integer>>();
    	HashMap<Integer, List<Pair>> pairs = new HashMap<Integer, List<Pair>>();
        for (int i=0;i<nums.length;i++){
        	for (int j=i+1;j<nums.length;j++){
        		int sum = nums[i] + nums[j];
        		if (!pairs.containsKey(sum)){
        			pairs.put(sum, new ArrayList<Pair>());
        			List<Pair> list = pairs.get(sum);
        			list.add(new Pair(i, j));
        		} else {
        			List<Pair> list = pairs.get(sum);
        			list.add(new Pair(i, j));
        		}
        	}
        }
        for (Map.Entry<Integer, List<Pair>> entry : pairs.entrySet()){
        	int search = target - entry.getKey();
        	if (pairs.containsKey(search)){
        		List<Pair> list1 = entry.getValue();
        		List<Pair> list2 = pairs.get(search);
        		
        		for (Pair p1 : list1){
        			for (Pair p2 : list2){
        				
        				if (p1.index1 != p2.index1 
        					&& p1.index1 != p2.index2
        					&& p1.index2 != p2.index1
        					&& p1.index2 != p2.index2){
        					
        					List<Integer> combo = new ArrayList<Integer>();
        					combo.add(nums[p1.index1]);
        					combo.add(nums[p1.index2]);
        					combo.add(nums[p2.index1]);
        					combo.add(nums[p2.index2]);
        					
        					Collections.sort(combo);
        					results.add(combo);
        				}
        			}
        		}
        	}
        }
        return new ArrayList<List<Integer>>(results);
    }
}
