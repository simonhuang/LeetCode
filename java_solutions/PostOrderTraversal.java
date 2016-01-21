package leetCode;
import java.util.*;
public class PostOrderTraversal {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
		List<Integer> nodes = new LinkedList<Integer>();
		
		if (root == null){
			return nodes;
		}
		nodes.addAll(postorderTraversalRecursive(root.left));
		nodes.addAll(postorderTraversalRecursive(root.right));
		nodes.add(root.val);
		return nodes;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> nodes = new LinkedList<Integer>();
		if (root == null) return nodes;
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		
		while (!s.empty()){
			TreeNode n = s.peek();
			if (n.left == null || visited.contains(n.left)){
				if (n.right == null){
					visited.add(s.peek());
					nodes.add(s.pop().val);
				} else {
					if (visited.contains(n.right)){
						visited.add(s.peek());
						nodes.add(s.pop().val);
					} else {
						s.push(n.right);
					}
				}
			} else {
				s.push(n.left);
			}
		}
		return nodes;
    }
    public static void main (String [] args){
    	PostOrderTraversal p = new PostOrderTraversal();
    	TreeNode t1 = p.new TreeNode(1);
    	TreeNode t2 = p.new TreeNode(2);
    	TreeNode t3 = p.new TreeNode(3);
    	
    	t1.right = t2;
    	t1.left = t3;
    	System.out.println(p.postorderTraversal(t1));
    }
}
