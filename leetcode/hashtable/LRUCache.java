package hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//public class LRUCache {
//	private HashMap<Integer,Integer>map;
//	public LRUCache(int capacity){
////		map=new LinkedCappedHashMap<Integer,Integer>(capacity);
//		map=new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
//			@Override
//			protected boolean removeEldestEntry(Map.Entry eldest){
//				return size()>capacity;
//			}
//		};
//	}
//	public int get(int key){
//		
//		if(map.containsKey(key))return map.get(key);
//		else return -1;
//	}
//	public void set(int key,int value){
//		map.put(key, value);
//	}
////	private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
////		int maxCapacity;
////		LinkedCappedHashMap(int maxCapacity){
////			super(16,1.0f,true);
////			this.maxCapacity=maxCapacity;
////		}
////		protected boolean removeEldestEntry(Map.Entry eldest) {
////		             return size() > maxCapacity;
////		}
////	}
//	
//	public static void main(String[]args){
//		LRUCache test=new LRUCache(2);
//		
//		test.set(2, 1);
//		test.set(1, 1);
//		System.out.println(test.get(2));
//		test.set(4, 1);
//		System.out.println(test.get(1));
//		System.out.println(test.get(2));
////		test.set(2, 1);
//		
//		
//	}
//}
public class LRUCache {
    class LinkedList{
        int key;
        int val;
        LinkedList next;
        LinkedList prev;
        public LinkedList(int k, int v){
            this.val=v;
            this.key=k;
            next=null;
            prev=null;
        }
    }
    int c;
    int size;
    LinkedList head=new LinkedList(-1,-1);
    LinkedList tail=new LinkedList(1,1);
    HashMap<Integer,LinkedList>map=new HashMap();
    public LRUCache(int capacity) {
        this.c=capacity;
        head.next=tail;
        tail.prev=head;
        		
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            LinkedList cur=map.get(key);
            cur.prev.next=cur.next;
            cur.next.prev=cur.prev;
            
            cur.prev=head;
            cur.next=head.next;
            head.next=cur;
            cur.next.prev=cur;
            return cur.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            LinkedList cur=map.get(key);
            cur.prev.next=cur.next;
            cur.next.prev=cur.prev;
            
            cur.prev=head;
            cur.next=head.next;
            head.next=cur;
            cur.next.prev=cur;
            cur.val=value;
        }else{
            if(this.size==this.c){
                map.remove(tail.prev.key);
                tail.prev.prev.next=tail;
                tail.prev=tail.prev.prev;
                
                
                LinkedList cur=new LinkedList(key,value);
                cur.prev=head;
                cur.next=head.next;
                head.next=cur;
                cur.next.prev=cur;
                
                map.put(key,cur);
            }else{
                LinkedList cur=new LinkedList(key,value);
                cur.next=head.next;
                cur.prev=head;
                head.next=cur;
                cur.next.prev=cur;
                map.put(key,cur);
                this.size++;
            }
        }
    }
    public static void main(String[]args){
		LRUCache test=new LRUCache(2);
		
		test.set(2, 2);
		test.set(1, 1);
		System.out.println(test.get(2));
		test.set(4, 4);
		System.out.println(test.get(4));
		System.out.println(test.get(1));
		test.set(2, 2);
		
		
	}
}