package tree;

import java.util.Stack;

public class BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root==null)return root;
		Stack<TreeNode>stack=new Stack<TreeNode>();
		stack.add(root);
		TreeNode cur=root;
		while(true){
			TreeNode temp=stack.peek();
			if(temp.left==null)break;
			else{
				stack.add(temp.left);
			}
		}
		
		TreeNode newroot=stack.pop();
		cur=newroot;
		while(!stack.isEmpty()){
			TreeNode temp=stack.pop();
			if(temp.right!=null){
				cur.left=new TreeNode(temp.right.val);	
			}
			cur.right=new TreeNode(temp.val);
			cur=cur.right;
		}
		return newroot;
	}
	public static void main(String[]args){
		BinaryTreeUpsideDown test=new BinaryTreeUpsideDown();
		TreeNode a1=new TreeNode(1);
//		TreeNode a2=new TreeNode(2);
//		TreeNode a3=new TreeNode(3);
//		TreeNode a4=new TreeNode(4);
//		TreeNode a5=new TreeNode(5);
//		a1.left=a2;
//		a1.right=a3;
//		a2.left=a4;
//		a2.right=a5;
		
//		TreeNode a1=null;
		TreeNode result=test.upsideDownBinaryTree(a1);
		result.toString();
		
	}
	
}
