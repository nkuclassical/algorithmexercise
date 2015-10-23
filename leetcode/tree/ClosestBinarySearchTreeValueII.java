package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
	public List<Integer> cloestKValues(TreeNode root, double target, int k) {
		Stack<TreeNode> bigger = new Stack();
		Stack<TreeNode> smaller = new Stack();
		TreeNode node = root;
		List<Integer> ret = new ArrayList();
		while (node != null) {
			if (node.val > target) {
				bigger.push(node);
				node = node.left;
			} else if (node.val <= target) {
				smaller.push(node);
				node = node.right;
			}
		}

		while (ret.size() < k) {
			if (smaller.isEmpty()
					|| (!bigger.isEmpty() && (bigger.peek().val - target < target
							- smaller.peek().val))) {
				TreeNode cur = bigger.pop();
				ret.add(cur.val);
				cur = cur.right;
				while (cur != null) {
					bigger.push(cur);
					cur = cur.left;
				}
			} else {
				TreeNode cur = smaller.pop();
				ret.add(cur.val);
				cur = cur.left;
				while (cur != null) {
					smaller.push(cur);
					cur = cur.right;
				}
			}
		}
		return ret;
	}

	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Stack<TreeNode> bigger = new Stack();
		Stack<TreeNode> smaller = new Stack();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val < target) {
				smaller.push(cur);
				cur = cur.right;
			} else {
				bigger.push(cur);
				cur = cur.left;
			}
		}

		List<Integer> ret = new ArrayList();
		for (int i = 0; i < k; i++) {
			if (bigger.isEmpty()
					|| (!smaller.isEmpty() && (bigger.peek().val - target > target
							- smaller.peek().val))) {
				cur = smaller.pop();
				ret.add(cur.val);
				cur = cur.left;
				while (cur != null) {
					smaller.push(cur);
					cur = cur.right;
				}
			} else {
				cur = bigger.pop();
				ret.add(cur.val);
				cur = cur.right;
				while (cur != null) {
					bigger.push(cur);
					cur = cur.left;
				}
			}
		}

		return ret;
	}
}
