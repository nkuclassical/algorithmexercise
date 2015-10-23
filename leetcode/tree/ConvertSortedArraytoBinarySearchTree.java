package tree;

public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0, nums.length-1);
    }
    
    public TreeNode build(int[]nums, int start, int end){
        
        if(start>end)return null;
        int mid=start+(end-start)/2;
        TreeNode root =  new TreeNode(nums[mid]);
        if(start==end)return root;
        else{
            root.left=build(nums,start,mid-1);
            root.right=build(nums,mid+1,end);
            return root;
        }
    }
	
	public static void main(String[]args){
		ConvertSortedArraytoBinarySearchTree test=new ConvertSortedArraytoBinarySearchTree();
		int[]nums=new int[1];
		for(int i=0;i<1;i++){
			nums[i]=i+1;
		}
		test.sortedArrayToBST(nums);
	}
}
