package bitmanipulation;


import java.util.Arrays;
import java.util.HashSet;

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		HashSet<Integer>set=new HashSet();
		for(int num:nums){
			if(set.contains(num)){
				set.remove(num);
			}else{
				set.add(num);
			}
		}	
//		int[]ret=Arrays.asList(set);
		Object[]ret=set.toArray();
		int[]result=new int[2];
		result[0]=(int)ret[0];
		result[1]=(int)ret[1];
		return result;
	}
	
	public int[]singleNumber2(int[]nums){
		int res=0;
		for(int num:nums){
			res^=num;
		}
		int lowbit=res&(-res);
		int[]a=new int[2];
		a[0]=0;
		a[1]=0;
		for(int num:nums){
			if((num&lowbit)!=0){
				a[0]^=num;
			}else{
				a[1]^=num;
			}
		}
		return a;
	}
	
}
