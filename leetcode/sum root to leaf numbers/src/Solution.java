class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	private int ans;
		
	public int sumNumbers(TreeNode root)
	{
		ans=0;
		sub(root,0);
		return ans;
	}
	void sub(TreeNode root,int prefix)
	{
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{
			ans+=prefix*10+root.val;
			return;
		}
		if(root.left!=null)
			sub(root.left,prefix*10+root.val);
		if(root.right!=null)
			sub(root.right,prefix*10+root.val);
	}
}
