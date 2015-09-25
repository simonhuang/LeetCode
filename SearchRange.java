package leetCode;
import java.util.*;
public class SearchRange {
	public static void main (String [] args){
		int a[] = {1};
		
		int ret [] = searchRange(a, 0);
		System.out.println(ret[0] + " " + ret[1]);
		
	}
	public static int[] searchRange(int[] A, int target) {
        int pos = binarySearch(A, target, 0, A.length-1);
        
        if (pos == -1){
        	int bounds [] = {-1, -1};
        	return bounds;
        }

        int bounds [] = new int [2];
        
        int index = pos;
        while (index >= 0){
        	if (A[index] == target){
        		bounds[0] = index;
        		index --;
        	} else {
        		break;
        	}
        }
        
        index = pos;
        while (index < A.length){
        	if (A[index] == target){
        		bounds[1] = index;
        		index ++;
        	} else {
        		break;
        	}
        }
        return bounds;
    }
	public static int binarySearch(int[] a, int target, int low, int high){
		if (high < low){
			return -1;
		}
		int middle = (high + low) / 2;
		
		if (a[middle] == target){
			return middle;
		} else if (a[middle] > target){
			return binarySearch(a, target, low, middle - 1);
		} else {
			return binarySearch(a, target, middle + 1, high);
		}
	}
}
