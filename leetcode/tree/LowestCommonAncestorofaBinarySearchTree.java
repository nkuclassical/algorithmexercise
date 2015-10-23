package tree;

public class LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null)return root;
		TreeNode smaller=p.val<q.val?p:q;
		TreeNode larger=p.val<q.val?q:p;
		if(root.val>=smaller.val&&root.val<=larger.val){
			return root;
		}else if(root.val>larger.val){
			return lowestCommonAncestor(root.left,smaller,larger);
		}else return lowestCommonAncestor(root.right,smaller,larger);
	}
	
	public static void main(String[]args){
		TreeNode a6=new TreeNode(6);
		TreeNode a2=new TreeNode(2);
		TreeNode a8=new TreeNode(8);
		TreeNode a0=new TreeNode(0);
		TreeNode a4=new TreeNode(4);
		TreeNode a7=new TreeNode(7);
		TreeNode a9=new TreeNode(9);
		TreeNode a3=new TreeNode(3);
		TreeNode a5=new TreeNode(5);
		a6.left=a2;
		a6.right=a8;
		a2.left=a0;
		a2.right=a4;
		a4.left=a3;
		a4.right=a5;
		a8.left=a7;
		a8.right=a9;
		LowestCommonAncestorofaBinarySearchTree test=new LowestCommonAncestorofaBinarySearchTree();
		TreeNode ret=test.lowestCommonAncestor(a6, a3, a0);
		System.out.println(ret.val);
		
	}
}
