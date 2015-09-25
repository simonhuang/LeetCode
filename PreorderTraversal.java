package leetCode;
import java.util.*;
public class PreorderTraversal {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main (String [] args){
		
	}
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<Integer>();
        
        preorderFill (nodes, root);
        
        return nodes;
    }
	private void preorderFill(List<Integer> nodes, TreeNode node) {
		if (node == null){
			return;
		} 
		nodes.add(node.val);
		preorderFill(nodes, node.left);
		preorderFill(nodes, node.right);
	}
}
