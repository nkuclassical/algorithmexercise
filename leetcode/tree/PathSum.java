package tree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			if (root.val == sum)
				return true;
			else
				return false;
		}
		if (root.left != null && root.right == null)
			return hasPathSum(root.left, sum - root.val);
		if (root.left == null && root.right != null)
			return hasPathSum(root.right, sum - root.val);
		else return hasPathSum(root.left, sum - root.val)
					|| hasPathSum(root.right, sum - root.val);

	}
	
	public boolean hasPathSum2(TreeNode root, int sum) {//better concise
        if(root==null)return false;
        sum-=root.val;
        if(root.left!=null&&hasPathSum(root.left,sum))return true;
        if(root.right!=null&&hasPathSum(root.right,sum))return true;
        if(root.left==null&&root.right==null)return sum==0;
        return false;
    }
}
