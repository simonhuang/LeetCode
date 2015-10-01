package leetCode;

public class RotateArray {
    public void rotate(int[] n, int k) {
    	int a [] = new int [n.length];
    	for (int i=0;i<n.length;i++){
    		a[i] = n[i];
    	}
    	k = k%n.length;
    	
    	for (int i=0;i<n.length;i++){
    		int index = i-k;
    		if (index < 0) index += n.length;
    		n[i] = a[index];
    	}
    }
}
