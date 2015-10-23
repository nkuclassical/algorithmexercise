package arraylist;

import tree.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
	}
    public TreeNode helper(int[]preorder, int[]inorder, int prestart, int preend, int instart, int inend){
        if(prestart>preend)return null;
        int rootvalue=preorder[prestart];
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==rootvalue){
                TreeNode root=new TreeNode(rootvalue);
                int leftsize=i-instart;
                root.left=helper(preorder,inorder,prestart+1,prestart+leftsize,instart,i-1);
                root.right=helper(preorder,inorder,prestart+leftsize+1,preend,i+1,inend);
                return root;
            }
        }
        return null;
    }	
	public static void main(String[]args){
		ConstructBinaryTreefromPreorderandInorderTraversal test=new ConstructBinaryTreefromPreorderandInorderTraversal();
		int[]preorder={1,2,3};
		int[]inorder={2,1,3};
		TreeNode result=test.buildTree(preorder, inorder);
		result.toString();
	}
}
