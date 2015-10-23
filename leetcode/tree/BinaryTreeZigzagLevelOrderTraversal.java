package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		int order=-1;
		Stack<TreeNode>stack=new Stack();
		Stack<TreeNode>nextstack=new Stack();
		List<List<Integer>>ret=new ArrayList();
		if(root==null)return ret;
		nextstack.add(root);
		
		while((!stack.empty())||(!nextstack.empty())){
			if(stack.empty()){
				stack.addAll(nextstack);
				List<Integer>levelret=new ArrayList();
				while(!nextstack.empty()){
					levelret.add(nextstack.pop().val);
				}
				ret.add(levelret);
				order=-order;
			}
			TreeNode subroot=stack.pop();
			if(order==1){
				if(subroot.left!=null)nextstack.add(subroot.left);
				if(subroot.right!=null)nextstack.add(subroot.right);
			}else{
				if(subroot.right!=null)nextstack.add(subroot.right);
				if(subroot.left!=null)nextstack.add(subroot.left);
			}
		}
		return ret;
	}
	public static void main(String[]args){
		TreeNode a3=new TreeNode(3);
		TreeNode a9=new TreeNode(9);
		TreeNode a20=new TreeNode(20);
		TreeNode a15=new TreeNode(15);
		TreeNode a6=new TreeNode(6);
		TreeNode a7=new TreeNode(7);
		TreeNode a4=new TreeNode(4);
		
		a3.left=a9;
		a3.right=a20;
		a20.left=a15;
		a20.right=a7;
		a9.left=a6;
		a9.right=a4;
		BinaryTreeZigzagLevelOrderTraversal test=new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>>ret=test.zigzagLevelOrder(a3);
		for(List<Integer> item:ret){
			for(Integer i:item)
				System.out.print(i+" ");
			System.out.println();
		}

	}
}
