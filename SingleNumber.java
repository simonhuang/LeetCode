package leetCode;
import java.util.*;

public class SingleNumber {
	public static void main (String [] args){
		int a[] = {3, 5, 2, 3, 5, 4, 4, 6, 2};
		
		System.out.println(singleNumber(a));
	}		
	public static int singleNumber(int[] a) {
		int n = a[0];
		for (int i=1;i<a.length;i++){
			n ^= a[i];
		}
        return n;
    }
	public static int singleNumber2(int[] A) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		
		for (int i=0;i<A.length;i++){
			if (numbers.contains(A[i])){
				numbers.remove(A[i]);
			} else {
				numbers.add(A[i]);
			}
		}
		
		for (int i=0;i<A.length;i++){
			if (numbers.contains(A[i])){
				return A[i];
			}
		}
		
		return -1;
        
    }
	public static int singleNumberSlow(int[] A) {
		boolean duplicate = false;
		for (int i=0;i<A.length;i++){
			duplicate = false;
			for (int j=0;j<A.length;j++){
				if (j != i && A[j] == A[i]){
					duplicate = true;
				}
			}
			if (duplicate){
				duplicate = false;
			} else {
				return A[i];
			}
		}
		return -1;
	}
}
