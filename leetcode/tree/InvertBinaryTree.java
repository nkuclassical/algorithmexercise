package tree;

public class InvertBinaryTree {
	public void invert(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		else {
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			invert(root.left);
			invert(root.right);
		}
	}

	public TreeNode invertTree(TreeNode root) {
		invert(root);
		return root;
	}
}
