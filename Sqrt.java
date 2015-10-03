package leetCode;

public class Sqrt {
	public static void main (String [] args){
		System.out.println(mySqrt(134500));
	}
    public static int mySqrt(int x) {
    	if (x == 0){
    		return 0;
    	}
    	int min = 1;
    	int max = x;
    	int middle = min + (max - min) / 2;
    	while (middle*middle != x){
    		if (middle*middle > x){
    			if ((middle-1)*(middle-1) <= x){
    				return middle - 1;
    			}
    			max = middle - 1;
    		} else if (middle*middle < x){
    			if ((middle+1)*(middle+1) >= x){
    				return middle;
    			}
    			min = middle + 1;
    		}
    		middle = min + (max - min) / 2;
    	}
		return middle;
    }
}
