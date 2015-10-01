package leetCode;

import leetCode.DeleteNodeInALinkedList.ListNode;

public class Test {
	public static void main (String [] args){
		int [] n = {1, 2, 3, 4, 8, 3, 9, 1, 13, 10};
		System.out.println(second_largest(n));
	}
	static int second_largest(int []n){
		int largest = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i=0;i<n.length;i++){
			if (n[i] > largest){
				second = largest;
				largest = n[i];
			} else if (n[i] > second){
				second = n[i];
			}
		}
		return second;
	}
}