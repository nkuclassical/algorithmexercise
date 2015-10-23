package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeRIghtSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new ArrayList();
		if (root == null)
			return ret;
		helper(root, 1, ret);
		return ret;
	}

	public void helper(TreeNode root, int d, List<Integer> ret) {
		if (root == null)
			return;
		if (d > ret.size()) {
			ret.add(root.val);
		}
		helper(root.right, d + 1, ret);
		helper(root.left, d + 1, ret);
	}

}
