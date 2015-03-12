import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;




public class Solution {
	public static void main(String[]args)
	{
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "e");
		map.put(2, "b");
		map.put(3, "z");
		map.put(4, "d");
		Iterator iterator=map.values().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		Queue q=new LinkedList();
		q.add("1");
		q.add("2");
		q.add("5");
		q.add("4");
		System.out.println(q.peek());
		System.out.println(q.peek());
		q.remove(q.element());
		Stack <String>s=new Stack<String>();
		s.push("4");
		s.push("5");
		
		System.out.println(s.hashCode());
		System.out.println(map.hashCode());
		String s1="fdsjaklfdjaijfasmd;sflsdjfiondsvdsahvdsds";
		String s2="jfsdajoimvisjvui4rjnfduhuihnfiuaoyf9hunweihosa";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	}
}
