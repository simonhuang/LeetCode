package leetCode;

public class ClimbingStairs {
	public static int climbStairs(int n) {
		
		int a[] = new int [n + 1];
		a[0] = 1;
		a[1] = 1;
		for (int i=2;i<n+1;i++){
			a[i] = a[i - 2] + a[i - 1];
		}
        return a[n];
    }
	public static void main (String[] args){
		System.out.println(climbStairs(5));
	}
}
