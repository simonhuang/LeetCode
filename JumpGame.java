package leetCode;
import java.util.*;
public class JumpGame {
	public static void main (String [] args){
		int a[] = {2,0,0};
		System.out.println(canJump(a));
	}
	 public static boolean canJump(int[] A) {
        int index = A.length - 2;
        
        if (A[0] == 0){
        	if (A.length == 1){
        		return true;
        	} else {
        		return false;
        	}
        }
        
        int cur_dead_index = -1;
        while (index >= 0){
        	if (A[index] == 0 && cur_dead_index == -1){
        		cur_dead_index = index;
        		index --;
        	} else if (cur_dead_index != -1) {
        		if (index + A[index] > cur_dead_index){
        			cur_dead_index = -1;
        		}
    			index --;
        	} else {
        		index --;
        	}
        }
        if (cur_dead_index == -1){
        	return true;
        }
        return false;
    }
}
