package leetCode;

public class ConstructBinaryTreeInorderPostorder {
	class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) { this.val = val; }
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (inorder.length == 0){
    		return null;
    	}
        return buildHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode buildHelper(int[] inorder, int inorder_start, int inorder_end, int[] postorder, int postorder_start, int postorder_end){
    	System.out.println(inorder_start + " " + inorder_end + " " + postorder_start + " " + postorder_end);
    	if (inorder_start >= inorder_end){
    		return new TreeNode(inorder[inorder_start]);
    	}
    	int root = postorder[postorder_end];
    	TreeNode cur = new TreeNode(root);
    	
    	int root_index = 0;
    	for (int i=inorder_start;i<inorder_end+1;i++){
    		if (inorder[i] == root){
    			root_index = i;
    			break;
    		}
    	}
    	int left_length = root_index - inorder_start;
    	int right_length = inorder_end - root_index;
    	
    	TreeNode left = buildHelper(inorder, inorder_start, root_index-1, postorder, postorder_start, postorder_start+left_length-1);
    	TreeNode right = buildHelper(inorder, root_index+1, inorder_end, postorder, postorder_start+left_length, postorder_start+left_length+right_length-1);
    	cur.left = left;
    	cur.right = right;
    	return cur;
    }
}
