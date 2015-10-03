package leetCode;
import java.util.*;

public class UglyNumber2 {
	public static void main (String [] args){
		System.out.println(nthUglyNumber(56));
	}

    public static int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];

    		System.out.println(ugly[i]);
        }
        return ugly[n-1];
    }
    public static int nthUglyNumber(int n) {
    	if (n == 1){
    		return 1;
    	}
    	n --;
    	int [] a = new int [n];
    	a[0] = 1;
    	int min_index = 0;
    	for (int i=1;i<n;i++){
    		while (true){
	    		if (a[min_index] * 2 > a[i-1]){
	    			a[i] = a[min_index] * 2;
	    			break;
	    		} else if (a[min_index] * 3 > a[i-1]){
	    			a[i] = a[min_index] * 3;
	    			break;
	    		} else if (a[min_index] * 4 > a[i-1]){
	    			a[i] = a[min_index] * 4;
	    			break;
	    		} else if (a[min_index] * 5 > a[i-1]){
	    			a[i] = a[min_index] * 5;
	    			break;
	    		} else {
	    			min_index ++;
	    		}
    		}
    		System.out.println(a[i]);
    	}
    	
        return a[n-1];
    }
}
