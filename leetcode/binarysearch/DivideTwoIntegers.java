package binarysearch;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		if (dividend < 0)
			sign = -sign;
		if (divisor < 0)
			sign = -sign;
		long temp=Math.abs((long)dividend);
		long temp2=Math.abs((long)divisor);
		long c=1;
		while(temp>temp2){
			temp2<<=1;
			c<<=1;
		}
		long res=0;
		while(temp>=Math.abs((long)divisor)){
			while(temp>=temp2){
				temp-=temp2;
				res+=c;
			}
			temp2>>=1;
			c>>=1;
		}
		if(res*sign<Integer.MIN_VALUE||res*sign>Integer.MAX_VALUE)return Integer.MAX_VALUE;
		return (int) (res*sign);
	}
    public int divide2(int dividend, int divisor) {
        int positive=1;
    	if(dividend<0)positive=-positive;
    	if(divisor<0)positive=-positive;
    	long temp1=Math.abs(dividend);
    	long temp2=Math.abs(divisor);
    	int c=1;
    	while(temp1>temp2){
    		temp2<<=1;
    		c<<=1;
        }
        long res=0;
        while(temp1>=Math.abs((long)divisor)){
        	while(temp1>=temp2){
        		temp1-=temp2;
        		res+=c;
            }
            temp2>>=1;
            c>>=1;
        }
        long result=res*positive;
        System.out.println(res);
        System.out.println(positive);
        System.out.println(result);
        if(res*positive<Integer.MIN_VALUE||res*positive>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        else return (int)res*positive;

    }
	public static void main(String[]args){
		DivideTwoIntegers test=new DivideTwoIntegers();
		System.out.println(test.divide2(-2147483648,-1));
		int overflow=Integer.MAX_VALUE;
		try{
		Math.addExact(overflow, 2);
		}catch (Exception e){
			System.out.println(e.toString());
		}
		int overflow2=Math.addExact(Integer.MAX_VALUE, 1);
		//overflow2 =Integer.MAX_VALUE+1  ->Integer.MIN_VALUE;
		
		int underflow=Integer.MIN_VALUE;
		for(int i=0;i<20;i++){
//			underflow-=1;
			System.out.println(underflow--);
		}
		
	}
}
