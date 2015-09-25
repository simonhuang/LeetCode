package leetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum3 {
	public static void main (String [] args){
		List<List<Integer>> combs = combinationSum3(3,9);
		System.out.println(combs);
	}
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		List<Integer> builder = new ArrayList<Integer>();
		create_combinations(combinations, k, n, builder, 1);
		return combinations;
    }
	private static void create_combinations(List<List<Integer>> combinations, int k, int n, List<Integer> builder, int cur) {
		if (k == 0){
			if (n == 0){
				combinations.add(builder);
			} else {
				return;
			}
		} else {
			if (cur > 9){
				return;
			}
			List<Integer> builder2 = new ArrayList<Integer>(builder);
			builder.add(cur);
			create_combinations(combinations, k-1, n-cur, builder, cur+1);
			create_combinations(combinations, k, n, builder2, cur+1);
		}
	}
}
