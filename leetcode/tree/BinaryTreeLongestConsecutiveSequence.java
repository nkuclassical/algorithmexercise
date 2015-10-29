package tree;

public class BinaryTreeLongestConsecutiveSequence {
	int ret = 0;

	public int longestConsecutive(TreeNode root) {
		if (root == null)
			return 0;
		helper(root);
		return ret;
	}

	public int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		int max = 1;
		if (left > 0) {
			if (root.val + 1 == root.left.val) {
				max = Math.max(left + 1, max);
			}
		}
		if (right > 0) {
			if (root.val + 1 == root.right.val) {
				max = Math.max(right + 1, max);
			}
		}
		ret=ret>max?ret:max;
		return max;
	}
}
