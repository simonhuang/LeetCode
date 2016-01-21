package leetCode;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleAreaSlow(int[] height) {
    	int n = height.length;
    	
    	int max = 0;
    	
    	for (int i=0;i<n;i++){
    		int min = height[i];
    		for (int j=i;j<n;j++){
				if (height[j] < min){
					min = height[j];
				}
				int area = min * (j + 1 - i);
				if (area > max){
					max = area;
				}
    		}
    	}

    	
        return max;
    }
    public int largestRectangleArea(int[] height) {
    	Stack<Integer> best_height = new Stack<Integer>();
    	int max = 0;
    	for (int i=0;i<height.length;i++){
			while (!best_height.empty() && height[best_height.peek()] > height[i]) {
				int cur_height = best_height.pop();
				int area = height[cur_height] * (i - cur_height);
				if (area > max){
					max = area;
				}
			}
			best_height.push(i);
    	}
    	while (!best_height.isEmpty()){
    		int cur_height = best_height.pop();
    		int area = height[cur_height] * (height.length - (best_height.isEmpty() ? 0 : cur_height + 1));
    		if (area > max){
    			max = area;
    		}
    	}
    	return max;
    }
}
