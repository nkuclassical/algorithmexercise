package tree;

import java.util.Stack;

public class LowestCommonAncestorofaBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Stack<TreeNode>first=new Stack();
		Stack<TreeNode>second=new Stack();
		TreeNode ret=new TreeNode(-1);
		if(helper(root,p,first)&&helper(root,q,second)){
			while((!first.empty())&&(!second.empty())){
				if(first.peek()==second.peek()){
					ret=first.peek();
					first.pop();
					second.pop();
				}
				else{
					return ret;
				}
			}
		}
		return ret;
	}
	public boolean helper(TreeNode root,TreeNode target,Stack<TreeNode>stack){
		if(root==null)return false;
		if(root==target){
			stack.push(root);
			return true;
		}
		if(helper(root.left,target,stack)||helper(root.right,target,stack)){
			stack.push(root);
			return true;
		}
		return false;
	}
	public static void main(String[]args){
		LowestCommonAncestorofaBinaryTree test=new LowestCommonAncestorofaBinaryTree();
		TreeNode a6=new TreeNode(6);
		TreeNode a2=new TreeNode(2);
		TreeNode a8=new TreeNode(8);
		TreeNode a0=new TreeNode(0);
		TreeNode a4=new TreeNode(4);
		TreeNode a7=new TreeNode(7);
		TreeNode a3=new TreeNode(3);
		TreeNode a5=new TreeNode(5);
		TreeNode a1=new TreeNode(1);
		a3.left=a5;
		a3.right=a1;
		a5.left=a6;
		a5.right=a2;
		a2.left=a7;
		a2.right=a4;
		a1.left=a0;
		a1.right=a8;
		System.out.println(test.lowestCommonAncestor(a3, a1, a5).val);
	}
}
