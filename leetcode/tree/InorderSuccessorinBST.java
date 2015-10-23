package tree;

import java.util.HashSet;
import java.util.Stack;

public class InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = new Stack();
		stack.push(root);
		HashSet<TreeNode> set = new HashSet();
		boolean found = false;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			if(cur==null)return null;
			if (set.contains(cur)) {
				if (found)
					return cur;
				if (cur == p) {
					found = true;
				}
			}else{
				set.add(cur);
				if(cur.right!=null)
					stack.push(cur.right);
				stack.push(cur);
				if(cur.left!=null)
					stack.push(cur.left);
			}
		}
		return null;
	}
	
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {//perfect 
        TreeNode cur=root;
        TreeNode successor=null;
        while(cur!=null){
            if(cur.val<=p.val){
                cur=cur.right;
            }else if(cur.val>p.val){
                successor=cur;
                cur=cur.left;
            }
        }
        return successor;
    }
	
	public static void main(String[]args){
		InorderSuccessorinBST test=new InorderSuccessorinBST();
//		TreeNode a1=null;
		TreeNode a1=new TreeNode(1);
		TreeNode a2=new TreeNode(2);
//		TreeNode a3=new TreeNode(3);
//		TreeNode a4=new TreeNode(4);
//		TreeNode a5=new TreeNode(5);
//		TreeNode a6=new TreeNode(6);
		a1.left=a2;
//		a1.right=a3;
//		a2.left=a4;
//		a3.left=a5;
//		a5.left=a6;
		System.out.println(test.inorderSuccessor(a1, a2).val);
	}
}
