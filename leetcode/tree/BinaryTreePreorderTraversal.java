package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer>ret=new ArrayList<Integer>();
		Stack<TreeNode>stack=new Stack();
		if(root==null)return ret;
		stack.add(root);
		while(!stack.empty()){
			TreeNode subroot=stack.pop();
			ret.add(subroot.val);
			if(subroot.right!=null)stack.add(subroot.right);
			if(subroot.left!=null)stack.add(subroot.left);
		}
		return ret;
	}
	
	public static void main(String[]args){
		TreeNode a3=new TreeNode(3);
		TreeNode a2=new TreeNode(2);
		TreeNode a1=new TreeNode(1);
		a1.right=a2;
		a2.left=a3;
		BinaryTreePreorderTraversal test=new BinaryTreePreorderTraversal();
		List<Integer>ret=test.preorderTraversal(a1);
		for(Integer item:ret){
			System.out.println(item);
		}
	}

}
