package string;

import java.util.Stack;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		if(s==null)return null;
		Stack<String>reverse=new Stack();
		int start=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' '){
				if(i==start){
					start=i+1;
					continue;
				}else{
					String sub=s.substring(start,i);
					start=i+1;
					reverse.add(sub);
				}
			}
		}
		if(start<s.length()){
			reverse.add(s.substring(start,s.length()));
		}
		StringBuilder sb=new StringBuilder();
		while(!reverse.empty()){
			sb.append(reverse.pop());
			if(!reverse.empty()){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	public static void main(String[]args){
		ReverseWordsinaString test=new ReverseWordsinaString();
		System.out.println(test.reverseWords("the sky is blue "));
	}
}
