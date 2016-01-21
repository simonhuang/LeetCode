package leetCode;
import java.util.*;
public class MaximumProductSubarray {
	public static void main (String [] args){
		int a[] = {5, -2, 2, 3};
		
		System.out.println(maxProduct(a));
	}
	public static int maxProduct(int[] A) {
        if (A.length == 0){
        	return 0;
        }
        if (A.length == 1 && A[0] < 0){
        	return A[0];
        }
        int max_product = 0;
        
        int current_max = 0;
        int current_min = 0;
        
        int prev_max = 1;
        int prev_min = 1;
        
        for (int i=0;i<A.length;i++){
        	current_max = Math.max(Math.max(prev_max * A[i], prev_min * A[i]), A[i]);
        	current_min = Math.min(Math.min(prev_max * A[i], prev_max * A[i]), A[i]);
        	
        	max_product = Math.max(max_product, current_max);
        	
        	prev_max = current_max;
        	prev_min = current_min;
        }
        return max_product;
    }
}
