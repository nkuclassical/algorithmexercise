package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	Iterator<Integer>it1;
    Iterator<Integer>it2;
    int cur;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1=v1.iterator();
        it2=v2.iterator();
        cur=1;
    }

    public int next() {
        if(!it1.hasNext()){
            return it2.next();
        }
        if(!it2.hasNext()){
            return it1.next();
        }
        if(cur==1){
            cur=2;
            return it1.next();
        }else{
            cur=1;
            return it2.next();
        }
    }

    public boolean hasNext() {
        return it1.hasNext()||it2.hasNext();
        
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
