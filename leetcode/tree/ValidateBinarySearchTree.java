package tree;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode root, Integer least, Integer most) {
		if (root == null)
			return true;
		
		if ((least!=null&&root.val <= least) || (most!=null&&root.val >= most)) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return true;
		} else {
			return helper(root.left, least, root.val)
					&& helper(root.right, root.val, most);
		}
	}

	public static void main(String[] args) {

	}
}
