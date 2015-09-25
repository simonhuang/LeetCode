package leetCode;
import java.util.*;

public class ThreeSum {
	public static void main (String [] args){
		int a[] = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(a));
	}
	
	public static List<List<Integer>> threeSum(int[] num) {
		
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
