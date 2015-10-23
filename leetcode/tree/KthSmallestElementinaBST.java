package tree;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementinaBST {

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack();
		HashSet<TreeNode> rootnode = new HashSet();
		stack.push(root);
		int index = 0;
		while (!stack.isEmpty()) {

			TreeNode temproot = stack.pop();
			if (rootnode.contains(temproot)) {
				index++;
				if (index == k)
					return temproot.val;
			} else {
				if(temproot.right!=null)stack.push(temproot.right);
				if (temproot.left == null) {
					index++;
					if(index==k)return temproot.val;
				} else {
					stack.push(temproot);
					rootnode.add(temproot);
					stack.push(temproot.left);
				}
			}
		}
		return 0;
	}
	
	public static void main(String[]args){
		TreeNode a20=new TreeNode(20);
		TreeNode a8=new TreeNode(8);
		TreeNode a22=new TreeNode(22);
		TreeNode a4=new TreeNode(4);
		TreeNode a12=new TreeNode(12);
		TreeNode a10=new TreeNode(10);
		TreeNode a14=new TreeNode(14);
		a20.left=a8;
		a20.right=a22;
		a8.left=a4;
		a8.right=a12;
		a12.left=a10;
		a12.right=a14;
		
		KthSmallestElementinaBST test=new KthSmallestElementinaBST();
		System.out.println(test.kthSmallest(a20, 3));
	}

}
