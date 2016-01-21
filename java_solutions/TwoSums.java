package leetCode;
import java.util.*;
public class TwoSums {
	public static void main (String [] args){
		int a[] = {3, 5, 2, 3, 5, 4, 4, 6, 2};
		
		System.out.println(twoSum(a, 10));
	}
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> differences = new HashMap<Integer,Integer>();
        for (int i=0;i<numbers.length;i++){
            differences.put(target - numbers[i], i);
        }
        
        int lower_index = -1;
        int higher_index = -1;
        for (int i=0;i<numbers.length;i++){
            
            if (differences.containsKey(numbers[i]) && i != differences.get(numbers[i])){
                
                if (i < differences.get(numbers[i])){
                    lower_index = i;
                    higher_index = differences.get(numbers[i]);
                } else {
                    lower_index = differences.get(numbers[i]);
                    higher_index = i;
                }
                break;
            }
        }
        int ret [] = {lower_index+1, higher_index+1};
        return ret;
    }
}
