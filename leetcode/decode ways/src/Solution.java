import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


public class Solution {
	public List<String> anagrams(String[] strs) {
        List<String>ans=new ArrayList<String>();
        String[]temp=strs;
        for(int i=0;i<strs.length;i++)
        {
        	//sort(strs[i].
        }
        return ans;
	}
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        reserve(nums,0,length-1);
        reserve(nums,0,k%length-1);
        reserve(nums,k%length,length-1);
    }
    void reserve(int[]nums,int start,int end)
    {
        while(end>start)
        {
            int tem=nums[start];
            nums[start]=nums[end];
            nums[end]=tem;
            end--;
            start++;
        }
    }
    public void setZeroes(int[][] matrix) {
        
		int m=matrix.length;
		if(m==0)return ;
        int n=matrix[0].length;
        boolean row=false,column=false;
        for(int i=0;i<m;i++)
        {
        	if(matrix[i][0]==0)
        	{
        		row=true;
        		break;
        	}
        }
        for(int i=0;i<n;i++)
        {
        	if(matrix[0][i]==0)
        	{
        		column=true;
        		break;
        	}
        }
        for(int i=1;i<m;i++)
        {
        	for(int j=1;j<n;j++)
        	{
        		if(matrix[i][j]==0)
        		{
        			matrix[0][j]=0;
        			matrix[i][0]=0;
        		}
        	}
        }
        for(int i=1;i<m;i++)
        {
        	if(matrix[i][0]==0)
        	{
        		changerow(matrix,i,m,n);
        	}
        }
        for(int i=1;i<n;i++)
        {
        	if(matrix[0][i]==0)
        	{
        		changecolumn(matrix,i,m,n);
        	}
        }
        if(row)
        {
        	changecolumn(matrix,0,m,n);
        }
        if(column)
        {
        	changerow(matrix,0,m,n);
        }
        
    }
	void changerow(int[][]matrix,int index,int m,int n)
	{
		for(int i=0;i<n;i++)
		{
			matrix[index][i]=0;
		}
	}
	void changecolumn(int[][]matrix,int index,int m,int n)
	{
		for(int i=0;i<m;i++)
		{
			matrix[i][index]=0;
		}
	}
    public int numDecodings(String s) {
        if(s.length()==0)return 0;
        if(s.length()==1)return Integer.parseInt(s)==0?0:1;
        
        Vector<Integer>dp=new Vector<Integer>(s.length()+1);
        for(int i=0;i<s.length()+1;i++)
        	dp.add(0);
        dp.set(0, 1);
        dp.set(1,s.charAt(0)=='0'?0:1);
        for(int i=2;i<s.length()+1;i++)
        {
        	if(s.charAt(i-1)!='0')dp.set(i,dp.get(i-1)+dp.get(i));
        	if(Integer.parseInt(s.substring(i-2, i))<=26&&s.charAt(i-2)!='0')
        		{dp.set(i,dp.get(i)+dp.get(i-2));
        		System.out.println(Integer.parseInt(s.substring(i-2, i)));
        		}
        }
        return dp.get(s.length());
    }
    public static void main(String[]args)
    {
    	//Solution s=new Solution();
    	String str="helloa";
    	char[]chararray=new char[str.length()];
    	chararray=str.replaceAll("\\s+", "").toCharArray();
    	Arrays.sort(chararray);
    	String again=String.copyValueOf(chararray);
    	System.out.println(again);
    	
    	/*Vector<Integer>v=new Vector<Integer>(5,5);
    	
    	for(Integer items:v)
    	{
    		System.out.println(items);
    	}
    	*/
    }
}
