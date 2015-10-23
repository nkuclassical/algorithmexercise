package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class Vector2D {
    private Iterator<List<Integer>>i;
    private Iterator<Integer>j;
	public Vector2D(List<List<Integer>>vec2d){
    	i=vec2d.iterator();
    }   
    public int next(){
    	return j.next();
    }
    public boolean hasNext(){
    	while((j==null||!j.hasNext())&&i.hasNext()){
    		j=i.next().iterator();
    	}
    	return j!=null&&j.hasNext();
    }
    public static void main(String[]args){
    	List<List<Integer>>v=new ArrayList<List<Integer>>();
//    	List<List<Integer>>v = null;
//    	v.add(null);
//    	v.add(new ArrayList<Integer>());
    	List<Integer>t=new ArrayList<Integer>();
    	t.add(1);
    	t.add(2);
    	v.add(new ArrayList(t));
    	t.clear();
    	t.add(3);
//    	t.add(2);
    	v.add(new ArrayList(t));
    	t.clear();
    	t.add(4);
    	t.add(5);
    	t.add(6);
    	v.add(new ArrayList(t));
    	t.clear();
    	Vector2D test=new Vector2D(v);
    	while(test.hasNext()){
    		System.out.println(test.next());
    	}
    }
}