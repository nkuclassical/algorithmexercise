package math;

import java.util.HashMap;
import java.util.HashSet;

public class HappyNumber {
	HashSet<Integer>map=new HashSet();
	public boolean isHappy(int n) {
		if(map.contains(n))return false;
		else{
			map.add(n);
			int num=0;
			while(n>0){
				num+=(n%10)*(n%10);
				n/=10;
			}
			
			if(num==1)return true;
			else return isHappy(num);
		}
	}
	public static void main(String[]args){
		HappyNumber test=new HappyNumber();
		System.out.println(test.isHappy(100));
	}
}
