package tree;

public class SymmetricTree {
	public boolean SymmetricSub(TreeNode left, TreeNode right) {
		if (left.left == null && left.right == null && right.left == null
				&& right.right == null) {
			if (left.val == right.val)
				return true;
			else
				return false;
		} else if (left.left != null && right.right != null
				&& left.right != null && right.left != null) {
			return (left.val == right.val)
					&& SymmetricSub(left.left, right.right)
					&& SymmetricSub(left.right, right.left);
		} else if (left.left != null && right.right != null
				&& left.right == null && right.left == null) {
			return (left.val == right.val)
					&& SymmetricSub(left.left, right.right);
		} else if (left.left == null && right.right == null
				&& left.right != null && right.left != null) {
			return (left.val == right.val)
					&& SymmetricSub(left.right, right.left);
		} else {
			return false;
		}

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;
		else if (root.left != null && root.right != null)
			return SymmetricSub(root.left, root.right);
		else
			return false;
	}
	
    public boolean isSymmetric2(TreeNode root) {//better
        if(root==null)return true;
        return helper(root.left,root.right);
   }
   
   public boolean helper(TreeNode left, TreeNode right){
       if(left==null&&right==null)return true;
       else if((left==null&&right!=null)||(left!=null&&right==null))return false;
       else{
           if(left.val!=right.val)return false;
           else return helper(left.left,right.right)&&helper(left.right,right.left);
       }
   }
}
