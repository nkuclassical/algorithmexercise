package string;

public class CountandSay {
	
	public String helper(String s){

		StringBuilder ret=new StringBuilder();
		int start=0;
		int cur=s.charAt(0)-'0';
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==s.charAt(start))continue;
			else{
				int time=i-start;
				ret.append(time);
				ret.append(cur);
				cur=s.charAt(i)-'0';
				start=i;
			}
		}
		
		int time=s.length()-start;
		ret.append(time);
		ret.append(cur);
		return ret.toString();
	}
	public String countAndSay(int n) {
		if(n==1)return String.valueOf(1);
		String ret=helper(String.valueOf(1));
		for(int i=2;i<n;i++){
			ret=helper(ret);
		}
		return ret;
	}
	public static void main(String[]args){
		CountandSay test=new CountandSay();
		System.out.println(test.countAndSay(2));
	}
}
