package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
	
	public List<List<Integer>>levelOrderBottom2(TreeNode root){
		List<List<Integer>>ret=new ArrayList();
		List<Integer>current=new ArrayList();
		if(root==null)return ret;
		Queue<TreeNode>queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				TreeNode temp=queue.poll();
				current.add(temp.val);
				if(temp.left!=null)queue.add(temp.left);
				if(temp.right!=null)queue.add(temp.right);
			}
			ret.add(0,new ArrayList(current));
			current.clear();
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
		BinaryTreeLevelOrderTraversalII test=new BinaryTreeLevelOrderTraversalII();
		List<List<Integer>>result=test.levelOrderBottom2(a3);
		for(List<Integer>rt:result){
			for(Integer r:rt){
				System.out.print(r);
			}System.out.println();
		}
	}

}
