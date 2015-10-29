package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList();
		if (root == null)
			return ret;
		helper(ret, new ArrayList(), root, sum);
		return ret;
	}

	public void helper(List<List<Integer>> ret, List<Integer> prefix,
			TreeNode root, int sum) {
		prefix.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				ret.add(new ArrayList(prefix));
			}
		} else {
			if (root.left != null) {
				helper(ret, prefix, root.left, sum - root.val);
			}
			if (root.right != null) {
				helper(ret, prefix, root.right, sum - root.val);
			}
		}
		prefix.remove(prefix.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode a5 = new TreeNode(5);
		TreeNode a4 = new TreeNode(4);
		TreeNode a8 = new TreeNode(8);
		TreeNode a11 = new TreeNode(11);
		TreeNode a13 = new TreeNode(13);
		TreeNode a41 = new TreeNode(4);
		TreeNode a7 = new TreeNode(7);
		TreeNode a2 = new TreeNode(2);
		TreeNode a51 = new TreeNode(5);
		TreeNode a1 = new TreeNode(1);
		PathSumII test = new PathSumII();
		a5.left = a4;
		a5.right = a8;
		a4.left = a11;
		a8.left = a13;
		a8.right = a41;
		a11.left = a7;
		a11.right = a2;
		a41.left = a51;
		a41.right = a1;
		List<List<Integer>> result = test.pathSum(a5, 22);
		for (List<Integer> rt : result) {
			for (Integer r : rt) {
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
