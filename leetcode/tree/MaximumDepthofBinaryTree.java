package tree;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if(root==null)return 0;
		if(root.left==null&&root.right==null)return 1;
		else if(root.left!=null&&root.right==null)return maxDepth(root.left)+1;
		else if(root.left==null&&root.right!=null)return maxDepth(root.right)+1;
		else return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
	
    public int maxDepth2(TreeNode root) { //concise
        if(root==null)return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
