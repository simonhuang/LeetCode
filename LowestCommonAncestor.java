package leetCode;

public class LowestCommonAncestor {
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q){
			return root;
		}
		if (p.val > root.val){
			if (q.val <= root.val){
				return root;
			} else {
				return lowestCommonAncestor(root.right, p, q);
			}
		} else if (p.val < root.val){
			if (q.val >= root.val){
				return root;
			} else {
				return lowestCommonAncestor(root.left, p, q);
			}
		}
        return null;
    }
}
