package math;

public class IntegertoEnglishWords {
    public String get(int n){
        if(n==1)return "One";
        else if(n==2)return "Two";
        else if(n==3)return "Three";
        else if(n==4)return "Four";
        else if(n==5)return "Five";
        else if(n==6)return "Six";
        else if(n==7)return "Seven";
        else if(n==8)return "Eight";
        else if(n==9)return "Nine";
        else if(n==10)return "Ten";
        else if(n==11)return "Eleven";
        else if(n==12)return "Twelve";
        else if(n==13)return "Thirteen";
        else if(n==14)return "Fourteen";
        else if(n==15)return "Fifteen";
        else if(n==16)return "Sixteen";
        else if(n==17)return "Seventeen";
        else if(n==18)return "Eighteen";
        else if(n==19)return "Nineteen";
        else if(n==20)return "Twenty";
        else if(n==30)return "Thirty";
        else if(n==40)return "Forty";
        else if(n==50)return "Fifty";
        else if(n==60)return "Sixty";
        else if(n==70)return "Seventy";
        else if(n==80)return "Eighty";
        else if(n==90)return "Ninety";
        else return "";
    }
    public String helper(int num){
        if(num>=1000000000)return helper(num/1000000000)+" Billion"+helper(num%1000000000);
        else if(num>=1000000)return helper(num/1000000)+" Million"+helper(num%1000000);
        else if(num>=1000)return helper(num/1000)+" Thousand"+helper(num%1000);
        else if(num>=100)return helper(num/100)+" Hundred"+helper(num%100);
        else if(num>=20)return " "+get(num-num%10)+helper(num%10);
        else if(num>=1)return " "+get(num);
        else return "";
    }
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        else{
        	String ret=helper(num);
        	return ret.substring(1);
        }
        
    }
    
    public static void main(String[]args){
    	IntegertoEnglishWords test=new IntegertoEnglishWords();
    	System.out.println(test.numberToWords(123456789));
    }
}
