package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	public List<TreeNode> helper(int start, int end) {
		List<TreeNode> trees = new ArrayList();
		if (start > end) {
			trees.add(null);
			return trees;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = helper(start, i - 1);
			List<TreeNode> right = helper(i + 1, end);

			for (TreeNode leftTree : left) {
				for (TreeNode rightTree : right) {
					TreeNode root = new TreeNode(i);
					root.left = leftTree;
					root.right = rightTree;
					trees.add(root);
				}
			}
		}
		return trees;
	}
}
