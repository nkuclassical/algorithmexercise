package tree;

public class CountUnivalueSubtree {
	int ret = 0;

	public int countUnivalSubtrees(TreeNode root) {
		helper(root);
		return ret;
	}

	public boolean helper2(TreeNode root) {
		if (root.left == null && root.right == null) {
			ret++;
			return true;
		} else if (root.left != null && root.right == null) {
			if (helper(root.left)) {
				if (root.val == root.left.val) {
					ret++;
					return true;
				} else
					return false;
			} else
				return false;
		} else if (root.left == null && root.right != null) {
			if (helper(root.right)) {
				if (root.val == root.right.val) {
					ret++;
					return true;
				} else
					return false;
			} else
				return false;
		} else {
			boolean rl = helper(root.left);
			boolean rr = helper(root.right);
			if (rl && rr) {
				if (root.val == root.left.val && root.val == root.right.val) {
					ret++;
					return true;
				} else
					return false;
			} else
				return false;
		}
	}

	public boolean helper(TreeNode root) {
		if (root == null)
			return true;
		else if (root.left == null && root.right == null) {
			ret++;
			return true;
		} else {
			boolean l = helper(root.left);
			boolean r = helper(root.right);
			if (l && r) {
				if ((root.left == null || root.val == root.left.val)
						&& (root.right == null || root.val == root.right.val)) {
					ret++;
					return true;
				} else
					return false;
			} else
				return false;
		}
	}

	public static void main(String[] args) {
		CountUnivalueSubtree test = new CountUnivalueSubtree();
		TreeNode a51 = new TreeNode(5);
		TreeNode a52 = new TreeNode(5);
		TreeNode a53 = new TreeNode(5);
		TreeNode a54 = new TreeNode(5);
		TreeNode a55 = new TreeNode(5);
		TreeNode a1 = new TreeNode(1);
		a51.left = a1;
		a51.right = a52;
		a1.left = a53;
		a1.right = a54;
		a52.right = a55;
		System.out.println(test.countUnivalSubtrees(a51));

	}
}
