package leetCode;
public class SameTree {

	public static class TreeNode {
		int val;
	    TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
			this.left = null;
			this.right = null;
		}
		TreeNode(int x, TreeNode left, TreeNode right){
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main (String [] args){
		TreeNode tree1 = new TreeNode(3, new TreeNode(2, new TreeNode(5), null), new TreeNode(10));
		TreeNode tree2 = new TreeNode(3, new TreeNode(2, new TreeNode(5), null), new TreeNode(10));
		System.out.println(isSameTree(tree1, tree2));
	}

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
        	return true;
        }
        if (p == null || q == null){
        	return false;
        }
        if (p.val == q.val){
        	return isSameTree(p.left, q.left)&& isSameTree(p.right, q.right); 
        } else {
        	return false;
        }
    }
}