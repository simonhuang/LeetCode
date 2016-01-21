package leetCode;
import java.util.*;
public class JumpGame {
	public static void main (String [] args){
		int a[] = {2,3,1,1,1,4};
		System.out.println(jump(a));
	}
    public static boolean canJump(int[] nums) {
        boolean reachable [] = new boolean [nums.length];
        
        reachable[0] = true;
        
        for (int i=0;i<nums.length-1;i++){
            int index = i + nums[i] > nums.length - 1 ? nums.length - 1 : i + nums[i];
            while (!reachable[index]){
                reachable[index] = true;
                index --;
            }
        }
        return reachable[nums.length - 1];
    }
	 public static int jump(int[] n) {
		 int reach = 0;
		 int last_reach = 0;
		 int count = 0;
		 while (reach < n.length-1){
			 int start = last_reach;
			 last_reach = reach;
			 for (int i=start;i<last_reach+1;i++){
				 if (n[i] + i > reach) reach = n[i] + i;
			 }
			 count ++;
		 }
		 return count;
    }
}
