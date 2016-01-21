package leetCode;

import java.util.*;

public class HouseRobber {
	public static void main (String [] args){
		int [] n = {0, 1, 6, 3 , 10, 100};
		System.out.println(rob(n));
	}
	
	public static int rob(int[] num) {
		if (num.length == 0){
			return 0;
		}
        int max_rob [] = new int [num.length];
        
        max_rob[0] = num[0];
        if (num.length == 1){
        	return max_rob[0];
        }
        
        max_rob[1] = Math.max(num[0], num[1]);
        if (num.length == 2){
        	return max_rob [1];
        }
        
        max_rob[2] = Math.max(num[0] + num[2], num[1]);
        if (num.length == 3){
        	return max_rob[2];
        }
        
        for (int i=3;i<num.length;i++){
    		max_rob[i] = Math.max(max_rob[i - 2] + num[i], max_rob[i - 3] + num[i]);
    		max_rob[i] = Math.max(max_rob[i - 1], max_rob[i]);
        }
        return max_rob[num.length - 1];
    }
	
	static int max = 0;
	public static int rob_recursive(int[] num) {
        rob_current(num, 0, 0);
        rob_current(num, 1, 0);
        
        return max;
    }
	
	static void rob_current(int[] num, int index, int money){
		if (index >= num.length){
			if (money > max){
				max = money;
			}
		} else {
			rob_current(num, index + 2, money + num[index]);
			rob_current(num, index + 3, money + num[index]);
		}
		
	}
}
