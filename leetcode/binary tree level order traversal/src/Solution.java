import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;







class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; } 
}
public class Solution {
	public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while(left<right)
        {
            int tem=Math.min(height[left],height[right])*(right-left);
            if(tem>max)max=tem;
            if(height[left]>height[right])
            {
            	right--;
           	}
            else left++;
        }
        return max;
    }	
	public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++)
        {
        	if(matrix[i][0]>target)return false;
        	if(matrix[i][matrix[i].length-1]<target)continue;
        	for(int j=0;j<matrix[i].length;j++)
        		if(matrix[i][j]==target)return true;
        }
        return false;
    }
    public int jump(int[] A) {
        int []steps=new int[A.length];
        for(int i=0;i<A.length;i++)
        	steps[i]=0;
        int maxindex=0;
        for(int i=0;i<A.length;i++)
        {
        	for(int j=A[i];j>0;j--)
        	{
        		if(i+j>A.length)
        			continue;
        		if(i+j<=maxindex)
        			break;
        		steps[i+j]=steps[i]+1;
        	}
        	if(maxindex<i+A[i])maxindex=i+A[i];
        }
        return steps[A.length-1];
    }
    public int minDistance(String word1, String word2) {
        int matrix[][]=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<word1.length()+1;i++)
            matrix[i][0]=i;
        for(int i=0;i<word2.length()+1;i++)
            matrix[0][i]=i;
        for(int i=1;i<word1.length()+1;i++)
        {
            for(int j=1;j<word2.length()+1;j++)
            {
            	System.out.println(word1.charAt(i-1));
            	System.out.println(word2.charAt(j-1));
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    matrix[i][j]=matrix[i-1][j-1];
                }
                else 
                    matrix[i][j]=Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i][j-1])+1;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
        	for(int j=0;j<matrix[i].length;j++)
        		System.out.print(matrix[i][j]+" ");
        	System.out.println();
        }
        return matrix[word1.length()][word2.length()];
    }
    public String addBinary(String a, String b) {
    	StringBuilder str=new StringBuilder();
    	int aPtr=a.length()-1;
    	int bPtr=b.length()-1;
    	int carry=0;
    	int count=0;
    	while(aPtr>=0||bPtr>=0)
    	{
    		if(aPtr>=0)
    		{
    			if(a.charAt(aPtr)=='1')
    			{
    				count++;
    			}
    		}
    		if(bPtr>=0)
    		{
    			if(b.charAt(bPtr)=='1')
    			{
    				count++;
    			}
    		}
    		if(carry>0)
    			count++;
    		carry=(carry>1)?1:0;
    		str.insert(0, (count==0||count==2)?'0':'1');
    		count=0;
    		aPtr--;
    		bPtr--;
    		
    	}
    	if(carry==1)
		{
    		str.insert(0, '1');
		}
    	return str.toString();
    	
    }
	public static void main(String[]args)
	{
		Solution s=new Solution();
		System.out.println(s.minDistance("123", "753"));
		
		
	}
}
