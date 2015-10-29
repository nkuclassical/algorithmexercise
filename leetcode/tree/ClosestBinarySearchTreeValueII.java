package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ClosestBinarySearchTreeValueII {
	public List<Integer> closestKValues2(TreeNode root, double target, int k) {
		Stack<TreeNode> stack = new Stack();
		LinkedList<Integer> ret = new LinkedList();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				if (ret.size() < k) {
					ret.add(cur.val);
				} else {
					if (Math.abs(ret.getFirst() - target) > Math.abs(cur.val
							- target)) {
						ret.removeFirst();
						ret.add(cur.val);
					} else
						break;
				}
				cur = cur.right;
			}
		}
		return ret;
	}
}
