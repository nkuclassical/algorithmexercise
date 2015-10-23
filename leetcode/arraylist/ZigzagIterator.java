package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
	int cur;
	int l;
	List<Integer>v1;
	List<Integer>v2;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		cur=(v1.isEmpty())?1:0;
		l=0;
		this.v1=v1;
		this.v2=v2;
	}
	
	public int next(){
		int ret;
		if(cur==0){
			ret=v1.get(l);
			if(l<v2.size())cur=1;
			else l++;
			return ret;
		}else {
			ret=v2.get(l);
			if(l+1<v1.size())cur=0;
			l++;
			return ret;
		}
	}
	
	public boolean hasNext(){
		if(cur==0){
			return v1.size()>l;
		}else{
			return v2.size()>l;
		}
	}
	
	public static void main(String[]args){
		List<Integer>v1=new ArrayList();
		v1.add(1);
		v1.add(2);
		List<Integer>v2=new ArrayList();
		v2.add(3);
		v2.add(4);
		v2.add(5);
		v2.add(6);
		ZigzagIterator test=new ZigzagIterator(v2,v1);
		while(test.hasNext()){
			System.out.println(test.next());
		}
	}
}
