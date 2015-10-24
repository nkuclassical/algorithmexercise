package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String>ret=new ArrayList();
        helper(ret,new StringBuilder(),n,n);
        return ret;
    }
    public void helper(List<String>ret, StringBuilder sb, int left, int right){
        if(left==0&&right==0){
            ret.add(sb.toString());
        }else{
            if(left>right)return;
            if(left>0){
                helper(ret,sb.append("("),left-1,right);
                sb.deleteCharAt(sb.length()-1);
            }
            if(right>0){
                helper(ret,sb.append(")"),left,right-1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
	public static void main(String[]args){
		GenerateParentheses test=new GenerateParentheses();
		List<String>result=test.generateParenthesis(10);
		for(String r:result)
			System.out.println(r);
	}
}
