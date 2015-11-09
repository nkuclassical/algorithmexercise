package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
	public List<String>next(String s){
		List<String>ret=new ArrayList();
		StringBuilder sb;
		for(int i=1;i<s.length();i++){
			if(s.charAt(i-1)=='+'&&s.charAt(i)=='+'){
				sb=new StringBuilder(s);
				sb.setCharAt(i-1, '-');
				sb.setCharAt(i, '-');
				ret.add(sb.toString());
			}
		}
		return ret;
	}
}
