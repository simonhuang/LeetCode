package leetCode;

import java.util.ArrayList;

public class RecoverBST {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main (String [] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(7);
		
		t2.left = t1;
		t2.right = t4;
		t4.left = t3;
		t4.right = t5;
		//printTree(t2);
		recoverTree(t2);
		printTree(t2);
	}
	public static void printTree(TreeNode root){
		if (root == null){
			return;
		} else {
			printTree(root.left);
			System.out.println(root.val);
			printTree(root.right);
		}
	}
	public static void recoverTree(TreeNode root){
		ArrayList<Integer> a = new ArrayList<Integer>();
		
	}
	static void flattenTree(TreeNode t, ArrayList<Integer> a){
		if (t != null){
			a.add(t.val);
			flattenTree(t.left, a);
		} else {
			a.add(-1);
		}
	}
}
