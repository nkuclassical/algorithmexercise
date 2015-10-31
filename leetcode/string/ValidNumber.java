package string;

public class ValidNumber {
	public boolean isNumber2(String s){
		s=s.trim();
		if(s.length()==0)return false;
		if(s.matches("[+-]?(([0-9]*\\.?[0-9]+)|([0-9]+\\.?[0-9]*))([eE][+-]?[0-9]+)?"))return true;
		else return false;
	}
	
	public static void main(String[]args){
		ValidNumber test=new ValidNumber();
		System.out.println(test.isNumber2("3fds"));
	}
}
