
public class Solution {
	public int strStr(String haystack, String needle) {
		for(int i=0;i<haystack.length()-needle.length()+1;i++)
		{
			if(haystack.substring(i, i+needle.length()).equals(needle))
			{
				return i;
			}
		}
		return -1;
    }
	public static void main(String[]args)
	{
		Solution s=new Solution();
		System.out.println(s.strStr("abcdefg", "efg"));
	}
}
