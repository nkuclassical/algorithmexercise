package tree;

public class ClosestBinarySearchTreeValue {
//	int ret;
//
//	public int closestValue2(TreeNode root, double target) {
//		if (root == null)
//			return 0;
//		ret = root.val;
//		if(ret==target)return root.val;
//		if(ret<target)
//			sub(root.right, target);
//		else sub(root.left,target);
//		return ret;
//	}
//	public int closestValue(TreeNode root,double target){
//		int a=root.val;
//		TreeNode kid=(root.val<target)?root.right:root.left;
//		if(kid==null)return a;
//		int b=closestValue(kid,target);
//		return Math.abs(a-target)<Math.abs(b-target)?a:b;
//	}
//	public void sub(TreeNode root, double target) {
//		double distance = Math.abs(root.val - target);
//		if (distance == 0)
//			ret = root.val;
//		if (distance < Math.abs(ret - target)) {
//			ret = root.val;
//			if (root.val < target) {
//				if (root.right != null)
//					sub(root.right, target);
//			} else {
//				if (root.left != null)
//					sub(root.left, target);
//			}
//		}
//	}
	
    int ret;
    public int closestValue(TreeNode root, double target) {
            if(root==null)return 0;
            else{
                ret=root.val;
            }
            helper(root,target);
            return ret;
    }
    public void helper(TreeNode root, double target){
        if(root==null)return;
        int cur=root.val;
        if(cur==target){
            ret=cur;
            return;
        }
        if(Math.abs(cur-target)<Math.abs(ret-target))ret=cur;
        if(root.val<target){
            helper(root.right,target);
        }else helper(root.left,target);
    }
	public static void main(String[]args){
		TreeNode a1=new TreeNode(1);
		TreeNode a2=new TreeNode(2);
		TreeNode a3=new TreeNode(3);
		TreeNode a4=new TreeNode(4);
		TreeNode a5=new TreeNode(5);
		TreeNode a6=new TreeNode(6);
		a3.right=a5;
		a5.right=a6;
		a3.left=a2;
		a2.left=a1;
		a5.left=a4;
		ClosestBinarySearchTreeValue test=new ClosestBinarySearchTreeValue();
		System.out.println(test.closestValue(a3, 3.78));
	}
}
