package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		if(root==null)return;
		Stack<TreeNode>queue=new Stack();
		TreeNode root2=root;
		
		if(root.right!=null)
			queue.add(root.right);
		if(root.left!=null)
			queue.add(root.left);
		while(!queue.isEmpty()){
			TreeNode cur=queue.pop();
			root2.right=cur;
			root2.left=null;
			root2=root2.right;
			if(cur.right!=null)
				queue.add(cur.right);
			if(cur.left!=null)
				queue.add(cur.left);
						
		}
		
	}
	
	
	
	public static void main(String[]args){
		FlattenBinaryTreetoLinkedList test=new FlattenBinaryTreetoLinkedList();
		TreeNode a0=new TreeNode(0);
		TreeNode a1=new TreeNode(1);
		TreeNode a2=new TreeNode(2);
		TreeNode a3=new TreeNode(3);
		TreeNode a4=new TreeNode(4);
		TreeNode a5=new TreeNode(5);
		TreeNode a6=new TreeNode(6);
		a1.left=a2;
		a1.right=a5;
		a2.left=a3;
		a2.right=a4;
		a5.right=a6;
		test.flatten(a1);
		a1.toString();
	}
}
