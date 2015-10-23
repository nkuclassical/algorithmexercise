package math;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {

	List<String> ret = new ArrayList();

	public List<String> findStrobogrammatic(int n) {
		if (n == 0)
			return ret;
		else if (n == 1)
			helper(new StringBuilder(), 1);
		else {
			helper(new StringBuilder("11"), n - 2);
			helper(new StringBuilder("69"), n - 2);
			helper(new StringBuilder("88"), n - 2);
			helper(new StringBuilder("96"), n - 2);
		}
		return ret;

	}

	public void helper(StringBuilder sb, int n) {
		if (n == 0) {
			ret.add(sb.toString());
		} else if (n == 1) {
			int midIndex = sb.length() / 2;
			sb.insert(midIndex, "0");
			ret.add(sb.toString());
			sb.deleteCharAt(midIndex);
			sb.insert(midIndex, "1");
			ret.add(sb.toString());
			sb.deleteCharAt(midIndex);
			sb.insert(midIndex, "8");
			ret.add(sb.toString());
			sb.deleteCharAt(midIndex);
			return;
		} else {
			int midIndex = sb.length() / 2;
			helper(sb.insert(midIndex, "00"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "11"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "69"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "88"), n - 2);
			sb.delete(midIndex, midIndex + 2);
			helper(sb.insert(midIndex, "96"), n - 2);
			sb.delete(midIndex, midIndex + 2);
		}
	}
    public List<String> findStrobogrammatic2(int n) {
        List<String>ret=new ArrayList();
        if(n==0)return ret;
        else if(n==1)helper(ret,n,new StringBuilder());
        else {
            helper(ret,n-2, new StringBuilder("11"));
            helper(ret,n-2, new StringBuilder("69"));
            helper(ret,n-2, new StringBuilder("88"));
            helper(ret,n-2, new StringBuilder("96"));
        }
        return ret;
    }
    public void helper(List<String>ret, int n, StringBuilder prefix){
        if(n==0){
            ret.add(prefix.toString());
            return;
        }else{
            int midIndex=prefix.length()/2;
            if(n==1){
                prefix.insert(midIndex,"0");
                ret.add(prefix.toString());
                prefix.deleteCharAt(midIndex);
                prefix.insert(midIndex,"1");
                ret.add(prefix.toString());
                prefix.deleteCharAt(midIndex);
                prefix.insert(midIndex,"8");
                ret.add(prefix.toString());
                return;
            }else{
                helper(ret,n-2,prefix.insert(midIndex,"00"));
                prefix.delete(midIndex,midIndex+2);
                helper(ret,n-2,prefix.insert(midIndex,"11"));
                prefix.delete(midIndex,midIndex+2);
                helper(ret,n-2,prefix.insert(midIndex,"69"));
                prefix.delete(midIndex,midIndex+2);
                helper(ret,n-2,prefix.insert(midIndex,"88"));
                prefix.delete(midIndex,midIndex+2);
                helper(ret,n-2,prefix.insert(midIndex,"96"));
                prefix.delete(midIndex,midIndex+2);
            }
        }
        
    }
	public static void main(String[] args) {
		StrobogrammaticNumberII test = new StrobogrammaticNumberII();
		List<String> result = test.findStrobogrammatic2(3);
		for (String r : result) {
			System.out.println(r);
			
		}
	}
}
