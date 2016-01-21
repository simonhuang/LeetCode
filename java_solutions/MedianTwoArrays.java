package leetCode;

public class MedianTwoArrays {
	public static void main (String [] args){
		int [] a = {1, 3, 5, 6, 7};
		int [] b = {2, 4, 6};
		int smallest = kth_smallest(a, 0, a.length, b, 0, b.length, 4);
		System.out.println(smallest);
	}
	public static int kth_smallest(int[] a, int start_a, int end_a, int[] b, int start_b, int end_b, int k) {
//		System.out.print("a: ");
//		for (int i=start_a;i< end_a; i++){
//			System.out.print(a[i] + " ");
//		}
//		System.out.print("b: ");
//		for (int i=start_b;i< end_b; i++){
//			System.out.print(b[i] + " ");
//		}
//		System.out.println();
		
		double length_a = end_a - start_a;
		double length_b = end_b - start_b;
//		System.out.println(length_a + " " + length_b);
		
		int i = (int) (length_a * (k - 1) / (length_a + length_b) + start_a);
		int j = k - 1 - i + start_b;
//		System.out.println(i + " " + j + " " + k);
		
		int a_i1 = i <= 0 ? Integer.MIN_VALUE : a[i-1];
		int b_j1 = j <= 0 ? Integer.MIN_VALUE : b[j-1];
		int a_i = i >= end_a - 1 ? Integer.MAX_VALUE : a[i];
		int b_j = j >= end_b - 1 ? Integer.MAX_VALUE : b[j];
		
		if (a_i <= b_j && a_i >= b_j1){
			return a_i;
		} else if (b_j <= a_i && b_j >= a_i1) {
			return b_j;
		}
		
		if (a_i < b_j){
			return kth_smallest(a, i + 1, end_a, b, start_b, j, k - i - 1);
		} else {
			return kth_smallest(a, start_a, i, b, j + 1, end_b, k - j - 1);
		}
    }
}
