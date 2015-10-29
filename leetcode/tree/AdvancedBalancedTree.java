package tree;
/**
 * Check whether the difference of depth of all leaf nodes are at most 1 
 * @author yanqiaozhan
 *
 */
public class AdvancedBalancedTree {
	public boolean isBalanced(TreeNode root) {
		int[]ret=helper(root);
		if(ret[1]-ret[0]>1)return false;
		else return true;
	}
	public int[]helper(TreeNode root){
		
		if(root==null){
			int []ret={0,0};
			return ret;
		}
		if(root.left==null&&root.right==null){
			int []ret={1,1};
			return ret;
		}else if(root.left==null&&root.right!=null){
			int []ret=helper(root.right);
			ret[0]++;
			ret[1]++;
			return ret;
		}else if(root.left!=null&&root.right==null){
			int[]ret=helper(root.left);
			ret[0]++;
			ret[1]++;
			return ret;
		}else{
			int[]left=helper(root.left);
			int[]right=helper(root.right);
			int min=Math.min(left[0], right[0])+1;
			int max=Math.max(left[1], right[1])+1;
			int []ret={min, max};
			return ret;
		}
	}
	public static void main(String[]args){
		TreeNode a1=new TreeNode(1);
		TreeNode a2=new TreeNode(2);
		TreeNode a3=new TreeNode(3);
		TreeNode a4=new TreeNode(4);
		TreeNode a5=new TreeNode(5);
		TreeNode a6=new TreeNode(6);
		TreeNode a7=new TreeNode(7);
		TreeNode a8=new TreeNode(8);
		TreeNode a9=new TreeNode(9);
		TreeNode a10=new TreeNode(10);
		TreeNode a11=new TreeNode(11);
		TreeNode a12=new TreeNode(12);
		TreeNode a13=new TreeNode(13);
		TreeNode a14=new TreeNode(14);
		TreeNode a15=new TreeNode(15);
		a1.left=a2;
		a1.right=a3;
		a2.left=a4;
		a2.right=a5;
		a4.left=a8;
		a4.right=a9;
		a5.left=a10;
		a5.right=a11;
		a8.left=a13;
		a9.left=a14;
		a11.right=a15;
		a3.left=a6;
		a3.right=a7;
		AdvancedBalancedTree test=new AdvancedBalancedTree();
		System.out.println(test.isBalanced(a1));

	}
	
}
