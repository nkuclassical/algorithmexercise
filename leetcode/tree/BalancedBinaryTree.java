package tree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(helper(root)<0)return false;
		return true;
	}
	public int helper(TreeNode root){
		if(root==null)return 0;
		int left=helper(root.left);
		int right=helper(root.right);
		int min=Math.min(left, right);
		int max=Math.min(left, right);
		if(min<0||max-min>1)return -1;
		else return 1+max;
	}
}
