package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
//	public void sub(List<String> ret, TreeNode root, String path) {
//		if (root == null)
//			return;
//		if (root.left == null && root.right == null) {
//			if (path.length() == 0) {
//				ret.add(String.valueOf(root.val));
//			} else {
//				ret.add(path + "->" + root.val);
//			}
//		} else if (root.left == null && root.right != null) {
//			if (path.isEmpty()) {
//				sub(ret, root.right, String.valueOf(root.val));
//			} else {
//				sub(ret, root.right, path + "->" + root.val);
//			}
//		} else if (root.left != null && root.right == null) {
//			if (path.isEmpty()) {
//				sub(ret, root.left, String.valueOf(root.val));
//			} else {
//				sub(ret, root.left, path + "->" + root.val);
//			}
//		} else {
//			if (path.isEmpty()) {
//				sub(ret, root.left, String.valueOf(root.val));
//				sub(ret, root.right, String.valueOf(root.val));
//			} else {
//				sub(ret, root.left, path + "->" + root.val);
//				sub(ret, root.right, path + "->" + root.val);
//			}
//		}
//	}
//
//	public List<String> binaryTreePaths(TreeNode root) {
//		List<String> ret = new ArrayList<String>();
//		sub(ret, root, "");
//		return ret;
//	}
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String>ret=new ArrayList();
        if(root==null)return ret;
        helper(root,new StringBuilder(),ret);
        return ret;
    }
    
    public void helper(TreeNode root,StringBuilder sb,List<String>ret){
        int startindex=sb.length();
        if(root.left==null&&root.right==null){
            sb.append(root.val);
            ret.add(sb.toString());
        }else{
            sb.append(root.val+"->");
            if(root.left!=null){
                helper(root.left,sb,ret);
            }
            if(root.right!=null){
                helper(root.right,sb,ret);
            }
        }
        sb.delete(startindex,sb.length());
    }

	public static void main(String[] args) {
		String a = "";
		System.out.println(a.length() == 0);
	}
}
