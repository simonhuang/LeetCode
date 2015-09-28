package leetCode;

import leetCode.DeleteNodeInALinkedList.ListNode;

public class Test {
	public static void main (String [] args){
		LargestRectangleInHistogram a = new LargestRectangleInHistogram();
		int [] height = {2, 1, 2};
		System.out.println(a.largestRectangleArea(height));
	}
}