package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test {
public static void main(String[]args){
	List<List<Integer>>n=new ArrayList();
	List<Integer>t=new ArrayList();
	t.add(5);
	t.add(2);
	t.add(3);
	n.add(t);
	Collections.sort(t);
//	for(Integer h:t){
//		System.out.println(h);
//	}
	System.out.println(t.lastIndexOf(5));
}
}
