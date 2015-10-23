package design;

import java.util.Stack;

import tree.TreeNode;

public class BSTIterator {
	Stack<TreeNode> stack = new Stack();

	public BSTIterator(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {
			stack.add(cur);
			cur = cur.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.empty();
	}

	/** @return the next smallest number */
	public int next() {
		if (hasNext()) {
			int ret=stack.peek().val;
			TreeNode cur = stack.pop();
			
			if (cur.right != null) {
				cur = cur.right;
				while (cur != null) {
					stack.add(cur);
					cur = cur.left;
				}
			}
			return ret;
		} else
			return -1;
	}
	public static void main(String[]args){
		TreeNode root=new TreeNode(1);
		BSTIterator i=new BSTIterator(root);
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
