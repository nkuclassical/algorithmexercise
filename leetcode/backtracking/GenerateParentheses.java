package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthese(int n) {
		List<String>ret=new ArrayList();
		generate(ret,"",n,n);
		return ret;
	}
	
	public void generate(List<String>ret,String s, int left, int right){
		if(left==0&&right==0){
			ret.add(new String(s));
			return;
		}
		if(left>right)return;
		if(left>0)
			generate(ret,s+'(',left-1,right);
		if(right>0)
			generate(ret,s+')',left, right-1);
		
	}
	
	public static void main(String[]args){
		GenerateParentheses test=new GenerateParentheses();
		List<String>result=test.generateParenthese(10);
		for(String r:result)
			System.out.println(r);
	}
}
