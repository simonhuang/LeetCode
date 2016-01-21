package leetCode;

public class InvertBinaryTree {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
    public TreeNode invertTree(TreeNode root) {
    	if (root == null){
    		return null;
    	}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
    }

}
