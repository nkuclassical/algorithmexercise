package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
//	List<String>list=new ArrayList();
//	public int sumNumbers(TreeNode root) {
//		if(root==null)return 0;
//		String sum="";
//		sub(root,sum);
//		int ret=0;
//		for(String item:list){
//			ret+=Integer.valueOf(item);
//		}
//		return ret;
//	}
//	public void sub(TreeNode root, String sum){
//		if(root.left==null&&root.right==null){
//			list.add(sum+root.val);
//		}
//		if(root.left!=null)sub(root.left,sum+root.val);
//		if(root.right!=null)sub(root.right,sum+root.val);
//		
//	}
	
	int ret=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        sumhelper(root,0);
        return ret;
    }
    
    public void sumhelper(TreeNode root, int prev){
        prev=prev*10+root.val;
        if(root.left!=null){
            sumhelper(root.left,prev);
        }
        if(root.right!=null){
            sumhelper(root.right,prev);
        }
        if(root.left==null&&root.right==null){
            ret+=prev;
        }
    }
	public static void main(String[]args){
		int ret=9;
		int weishu=(int)(Math.log10(ret)+1);
		
		System.out.println(Math.pow(10, weishu));
	}
}
