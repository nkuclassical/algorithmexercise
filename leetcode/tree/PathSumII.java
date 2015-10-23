package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
//	List<List<Integer>>ret=new ArrayList();
//	public List<List<Integer>> pathSum(TreeNode root, int sum) {
//		helper(root,sum,new ArrayList<Integer>());
//		return ret;
//	}
//	public void helper(TreeNode root,int sum,List<Integer>prefix){
//		if(root==null)return;
//		if(root.left==null&&root.right==null){
//			if(root.val==sum){
//				prefix.add(root.val);
//				ret.add(new ArrayList(prefix));
//			}else return;
//		}
//		else if(root.left!=null&&root.right==null){
//			prefix.add(root.val);
//			helper(root.left,sum-root.val,prefix);
//			return;
//		}else if(root.left==null&&root.right!=null){
//			prefix.add(root.val);
//			helper(root.right,sum-root.val,prefix);
//			return;
//		}else{
//			prefix.add(root.val);
//			helper(root.left,sum-root.val,new ArrayList(prefix));
//			helper(root.right,sum-root.val,new ArrayList(prefix));
//			return;
//		}
//	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>ret=new ArrayList();
        helper(root,sum,new ArrayList(),ret);
        return ret;
    }
    
    public void helper(TreeNode root, int sum, List<Integer>previous, List<List<Integer>>ret){
        if(root==null)return;
        sum-=root.val;
        previous.add(root.val);
        if(root.left!=null){
            helper(root.left,sum,previous,ret);
        }
        if(root.right!=null){
            helper(root.right,sum,previous,ret);
        }
        if(root.left==null&&root.right==null){
            if(sum==0){
                ret.add(new ArrayList(previous));
            }
        }
        previous.remove(previous.size()-1);
    }
	public static void main(String[]args){
		TreeNode a5=new TreeNode(5);
		TreeNode a4=new TreeNode(4);
		TreeNode a8=new TreeNode(8);
		TreeNode a11=new TreeNode(11);
		TreeNode a13=new TreeNode(13);
		TreeNode a41=new TreeNode(4);
		TreeNode a7=new TreeNode(7);
		TreeNode a2=new TreeNode(2);
		TreeNode a51=new TreeNode(5);
		TreeNode a1=new TreeNode(1);
		PathSumII test=new PathSumII();
		a5.left=a4;
		a5.right=a8;
		a4.left=a11;
		a8.left=a13;
		a8.right=a41;
		a11.left=a7;
		a11.right=a2;
		a41.left=a51;
		a41.right=a1;
		List<List<Integer>>result=test.pathSum(a5, 22);
		for(List<Integer>rt:result){
			for(Integer r:rt){
				System.out.print(r);
			}
			System.out.println();
		}
	}
}
