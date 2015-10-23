package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack();
		List<Integer> list = new ArrayList();
		Set<TreeNode> set = new HashSet();
		if (root == null)
			return list;
		stack.add(root);
		while (!stack.empty()) {
			TreeNode subroot = stack.pop();
			if (set.contains(subroot))
				list.add(subroot.val);
			else {
				set.add(subroot);
				stack.add(subroot);
				if(subroot.right!=null)stack.add(subroot.right);
				if(subroot.left!=null)stack.add(subroot.left);
			}
		}
		return list;
	}
	
	public static void main(String[]args){
		TreeNode a3=new TreeNode(3);
		TreeNode a2=new TreeNode(2);
		TreeNode a1=new TreeNode(1);
		a1.right=a2;
		a2.left=a3;
		BinaryTreePostOrderTraversal test=new BinaryTreePostOrderTraversal();
		List<Integer>ret=test.postorderTraversal(a1);
		for(Integer item:ret){
			System.out.println(item);
		}
	}
}
