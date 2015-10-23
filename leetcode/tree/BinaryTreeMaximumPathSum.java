package tree;

public class BinaryTreeMaximumPathSum {
	int ret = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		helper(root);
		return ret;
	}

	public int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = 0, right = 0;
		if (root.left != null) {
			left = helper(root.left);
		}
		if (root.right != null) {
			right = helper(root.right);
		}
		int temp = root.val;
		if (left > 0)
			temp += left;
		if (right > 0)
			temp += right;
		if (temp > ret)
			ret = temp;
		return root.val + Math.max(0, Math.max(left, right));
	}

	public static void main(String[] args) {
		// TreeNode a3 = new TreeNode(3);
		// TreeNode a2 = new TreeNode(2);
		TreeNode a1 = new TreeNode(-3);
		// a1.left = a2;
		// a1.right = a3;
		BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
		System.out.println(test.maxPathSum(a1));
	}

}
