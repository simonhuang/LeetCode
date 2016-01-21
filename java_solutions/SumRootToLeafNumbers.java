package leetCode;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null){
        	return 0;
        } else {
        	return sumHelper(root, "");
        }
    }
    public int sumHelper(TreeNode root, String sum){
    	if (root == null){
    		return 0;
    	}
    	if (root.left == null && root.right == null){
    		return Integer.parseInt(root.val + sum);
    	} else if (root.left == null){
    		return sumHelper(root.right, root.val + sum);
    	} else if (root.right == null){
    		return sumHelper(root.left, root.val + sum);
    	} else {
    		return sumHelper(root.left, root.val + sum) + sumHelper(root.right, root.val + sum);
    	}
    }
}
