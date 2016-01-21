package leetCode;
import java.util.*;

public class TrappingRainWater {
	public static void main (String [] args){
		int height [] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
    public static int trap(int[] height) {
        Stack<Integer> left_walls = new Stack<Integer>();
        for (int i=0;i<height.length;i++){
        	if (left_walls.isEmpty()){
        		if (height[i] > 0){
        			left_walls.push(i);
        		}
        	} else {
        		if (height[i] >= height[left_walls.peek()]){
        			left_walls.push(i);
        		}
        	}
        }

        Stack<Integer> right_walls = new Stack<Integer>();
        for (int i=height.length-1;i>=0;i--){
        	if (right_walls.isEmpty()){
        		if (height[i] > 0){
        			right_walls.push(i);
        		}
        		if (!left_walls.isEmpty() && height[i] == height[left_walls.peek()]){
        			break;
        		}
        	} else {
        		if (height[i] >= height[right_walls.peek()]){
        			right_walls.push(i);
        		}
        		if (height[i] == height[left_walls.peek()]){
        			break;
        		}
        	}
        }
        
        int water = 0;
        for (int i=0;i<left_walls.size()-1;i++){
        	int start = left_walls.get(i);
        	int end = left_walls.get(i+1);
        	for (int j=start+1;j<end;j++){
        		water += height[start] - height[j];
        	}
        }
        for (int i=0;i<right_walls.size()-1;i++){
        	int end = right_walls.get(i);
        	int start = right_walls.get(i+1);
        	for (int j=start+1;j<end;j++){
        		water += height[end] - height[j];
        	}
        }
        System.out.println(left_walls);
        System.out.println(right_walls);
        return water;
    }
}
