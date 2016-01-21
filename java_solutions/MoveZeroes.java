package leetCode;
import java.util.*;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        List<Integer> zero_indices = new ArrayList<Integer>();
        
        for (int i=0;i<nums.length;i++){
        	if (nums[i] == 0){
        		zero_indices.add(i);
        	}
        }
        if (zero_indices.size() == 0){
        	return;
        }
        
        for (int i=0;i<zero_indices.size()-1;i++){
        	for (int j=zero_indices.get(i)-i;j<zero_indices.get(i+1)-i-1;j++){
        		nums[j] = nums[j+i+1];
        	}
        }
        for (int i=zero_indices.get(zero_indices.size()-1)-zero_indices.size()+1;i<nums.length-zero_indices.size();i++){
        	nums[i] = nums[i+zero_indices.size()];
        }
        for (int i=0;i<zero_indices.size();i++){
        	nums[nums.length-i-1] = 0;
        }
    }
}
