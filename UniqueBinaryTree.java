package leetCode;
import java.util.*;
public class UniqueBinaryTree {
	public static void main (String [] args){
		System.out.println(numTrees(3));
	}
	public static int numTrees(int n){
		if (n == 0){
			return 0;
		} else if (n == 1){
			return 1;
		}
		
		int a[] = new int [n+1];
		a[0] = 0;
		a[1] = 1;
		for (int i=2;i<n+1;i++){
			int sum = 0;
			for (int j=0;j<i;j++){
				int left_count = a[j];
				int right_count = a[i-j-1];
				if (left_count == 0 || right_count == 0){
					sum += left_count + right_count;
				} else {
					sum += left_count * right_count;
				}
			}
			a[i] = sum;
		}
		return a[n];
	}
	public static int numTreesRecursive(int n) {
        if (n == 0){
        	return 0;
        } else if (n == 1){
        	return 1;
        }
        
    	int sum = 0;
    	for (int i=0;i<n;i++){
    		int left_count = numTrees(i);
    		int right_count = numTrees(n-i-1);
    		if (left_count == 0 || right_count == 0){
    			sum += left_count + right_count;
    		} else {
    			sum += left_count * right_count;
    		}
    		
    	}
    	return sum;
    }
}
