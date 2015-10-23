package tree;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root==null)return 0;
		int leftdepth=leftDepth(root);
		int rightdepth=rightDepth(root);
		if(leftdepth==rightdepth)return (1<<leftdepth)-1;
		else{
			return 1+countNodes(root.left)+countNodes(root.right);
		}
	}
	
	public int leftDepth(TreeNode root){
		
		int dep=1;
		while(root.left!=null){
			root=root.left;
			dep++;
		}
		return dep;
	}
	
	public int rightDepth(TreeNode root){
		int dep=1;
		while(root.right!=null){
			root=root.right;
			dep++;
		}
		return dep;
	}
}
