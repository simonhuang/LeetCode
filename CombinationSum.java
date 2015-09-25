package leetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public static void main (String [] args){
		int [] candidates = {5, 6, 3, 2, 1, 6};
		int target = 6;
		List<List<Integer>> combs = combinationSum2(candidates, target);
		System.out.println(combs);
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		List<Integer> builder = new ArrayList<Integer>();
		create_combinations(combinations, candidates, 0, target, builder, 0);
		for (int i=0;i<combinations.size();i++){
			for (int j=i+1;j<combinations.size();j++){
				if (equivalent_list(combinations.get(i), combinations.get(j))){
					combinations.remove(j);
					j--;
				}
			}
		}
		return combinations;
    }
	public static boolean equivalent_list(List<Integer> list1, List<Integer> list2){
		if (list1.size() != list2. size()){
			return false;
		}
		for (int i=0;i<list1.size();i++){
			if (list1.get(i) != list2.get(i)){
				return false;
			}
		}
		return true;
	}
	private static void create_combinations(List<List<Integer>> combinations,int[] candidates, int i, int target, List<Integer> builder, int sum) {
		if (sum == target){
			combinations.add(builder);
		} else if (i >= candidates.length || sum > target){
			return;
		} else {
			List<Integer> builder2 = new ArrayList<Integer>(builder);
			List<Integer> builder3 = new ArrayList<Integer>(builder);
			builder.add(candidates[i]);
			builder3.add(candidates[i]);
			create_combinations(combinations, candidates, i+1, target, builder, sum+candidates[i]);
			create_combinations(combinations, candidates, i+1, target, builder2, sum);
			create_combinations(combinations, candidates, i  , target, builder3, sum+candidates[i]);
		}
	}
}
