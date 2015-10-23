package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack();
		Set<TreeNode> set = new HashSet();
		if (root == null)
			return ret;
		stack.add(root);
		while (!stack.empty()) {
			TreeNode subroot = stack.pop();
			if (set.contains(subroot)) {
				ret.add(subroot.val);
			} else {
				
				if(subroot.right!=null)stack.add(subroot.right);
				if (subroot.left == null)
					ret.add(subroot.val);
				else{
					stack.add(subroot);
					set.add(subroot);
					stack.add(subroot.left);
				}
			}
		}
		return ret;
	}
	public static void main(String[]args){
		TreeNode a3=new TreeNode(3);
		TreeNode a2=new TreeNode(2);
		TreeNode a1=new TreeNode(1);
		a1.right=a2;
		a2.left=a3;
		BinaryTreeInorderTraversal test=new BinaryTreeInorderTraversal();
		List<Integer>ret=test.inorderTraversal(a1);
		for(Integer item:ret){
			System.out.println(item);
		}
	}

}
