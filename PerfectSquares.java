package leetCode;

import java.util.*;

public class PerfectSquares {
	public int numSquares(int n) {
		if (n == 0){
			return 0;
		}
		ArrayList<Integer> sqrt = new ArrayList<Integer>();
		int a = 1;
		while (a*a <= n){
			sqrt.add(a);
			a++;
		}
		if (a*a == n){
			return 1;
		}
		int [] dp = new int [n+1];
		dp[1] = 1;
		for (int i=2;i<dp.length;i++){
			int min = Integer.MAX_VALUE;
			for (int s : sqrt){
				if (s == i){
					min = 1;
					break;
				} else if (s > i){
					break;
				} else {
					min = Math.min(min, dp[i-s] + 1);
				}
			}
			dp[i] = min;
		}
		return dp[n];
	}
}
