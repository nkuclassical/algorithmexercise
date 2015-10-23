package string;

public class ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
		reverse(s,0,s.length);
		for(int i=0,j=0;i<=s.length;i++){
			if(i==s.length||s[i]==' '){
				reverse(s,j,i);
				j=i+1;
			}
		}
	}
	public void reverse(char[]s,int start,int end){
		for(int i=start;i<(start+end)/2;i++){
			char temp=s[i];
			s[i]=s[end+start-i-1];
			s[end+start-i-1]=temp;
		}
	}
	public static void main(String[]args){
		ReverseWordsinaStringII test=new ReverseWordsinaStringII();
		String s="the sky is blue";
		//char[]sc=s.toCharArray();
		test.reverseWords(s.toCharArray());
		System.out.println(s.toCharArray());
	}
}
