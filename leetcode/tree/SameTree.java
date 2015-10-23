package tree;

public class SameTree {
	public boolean sub(TreeNode p, TreeNode q) {
		if (p.val != q.val)
			return false;
		if (p.left == null) {
			if (p.right == null) {
				if (q.left == null && q.right == null)
					return true;
			} else {
				if (q.left == null && q.right != null)
					return sub(p.right, q.right);
			}

		} else {
			if (q.left != null && p.right != null && q.right != null) {
				return sub(p.left, q.left) && sub(p.right, q.right);
			} else if (q.left != null && p.right == null && q.right == null)
				return sub(p.left, q.left);
			
		}
		return false;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if ((p == null && q != null) || (p != null && q == null))
			return false;
		return sub(p, q);

	}
	
	
    public boolean isSameTree2(TreeNode p, TreeNode q) { //better
        if(p==null&&q==null)return true;
        else if((p!=null&&q==null)||(p==null&&q!=null))return false;
        else {
            if(p.val!=q.val)return false;
            else{
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }
        }
    }
}
