package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode>curlevel=new LinkedList<TreeNode>();
		Queue<TreeNode>nextlevel=new LinkedList<TreeNode>();
		List<List<Integer>>ret=new ArrayList();
		if(root==null)return ret;
		List<Integer>curret=new ArrayList();
		curlevel.add(root);
		while(!curlevel.isEmpty()){
			TreeNode curnode=curlevel.poll();
			if(curnode.left!=null)nextlevel.add(curnode.left);
			if(curnode.right!=null)nextlevel.add(curnode.right);
			curret.add(curnode.val);
			if(curlevel.isEmpty()){
				ret.add(0,new ArrayList(curret));
				curret.clear();
				curlevel.addAll(nextlevel);
				nextlevel.clear();
			}
		}
		return ret;
	}
	public static void main(String[]args){
		TreeNode a3=new TreeNode(3);
		TreeNode a9=new TreeNode(9);
		TreeNode a20=new TreeNode(20);
		TreeNode a15=new TreeNode(15);
		TreeNode a7=new TreeNode(7);
		a3.left=a9;
		a3.right=a20;
		a20.left=a15;
		a20.right=a7;
		BinaryTreeLevelOrderTraversal test=new BinaryTreeLevelOrderTraversal();
		List<List<Integer>>result=test.levelOrder(a3);
		for(List<Integer>rt:result){
			for(Integer r:rt){
				System.out.print(r);
			}System.out.println();
		}
	}
}
