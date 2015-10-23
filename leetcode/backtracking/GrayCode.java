package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
//	public List<Integer> grayCode(int n) {
//		List<Integer>ret=new ArrayList();
//		if(n<0)return ret;
//		ret.add(0);
//		
//		for(int i=1;i<=n;i++){
//			List<Integer>tempret=new ArrayList(ret);
//			reverse(tempret);
//			
//			for(int j=0;j<tempret.size();j++){
//				ret.add(tempret.get(j)+tempret.size());
//			}
//		}
//		
//		return ret;
//	}
//	
//	public void reverse(List<Integer>l){
//		int start=0, end=l.size()-1;
//		while(start<end){
//			int temp=l.get(start);
//			l.set(start, l.get(end));
//			l.set(end, temp);
//			start++;
//			end--;
//		}
//	}
	
	
	 public List<Integer> grayCode(int n) {
	        List<Integer>ret=new ArrayList();
	        ret.add(0);
	        if(n==0)return ret;
	        ret.add(1);
	        for(int i=1;i<n;i++){
	            int size=ret.size();
	            for(int j=size-1;j>=0;j--){
	                ret.add(ret.get(j)+size);
	            }
	        }
	        return ret;
	    }
	
	
	public static void main(String[]args){
		GrayCode test=new GrayCode();
		List<Integer>result=test.grayCode(3);
		for(Integer r:result){
			System.out.println(r);
		}
//		System.out.println(test.addOne(4));
	}
}
