package hw2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public class RandomQueue<Item> implements Iterable<Item> {

	 
	private Item[]items;
	private int N;
	public RandomQueue(){
		N=-1;
		items=(Item[])new Object[4];
	}
	public int size(){
		return N+1;
	}
	public void enqueue(Item item){
		if(size()==items.length){
			resize(2*size());
		}
		N++;
		items[N]=item;
	}
	public void shuffle(){
		if(N<=0)return;
		int shuffleindex=(int) (Math.random()*(N));
		Item temp=items[N];
		items[N]=items[shuffleindex];
		items[shuffleindex]=temp;
	}
	public void resize(int size){
		Item[]newitems=(Item[])new Object[size];
		for(int i=0;i<size&&i<size();i++){
			newitems[i]=items[i];
		}
		items=newitems;
		
	}
	public Item dequeue(){
		shuffle();
		if(size()==0)throw new RuntimeException("Randomized queue underflow!");
		Item ret=items[N];
		N--;
		if(N>0&&N==items.length/4){
			resize(items.length/2);
		}
		return ret;
	}
	
	public Item sample(){
		shuffle();
		return items[N];
	}
	
	@Override	
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[]args){
		
		RandomQueue test=new RandomQueue();
		HashMap<Integer,Integer>map=new HashMap();
		for(int i=0;i<10;i++){
			test.enqueue(i);
			map.put(i, 0);
		}
		System.out.println("------get sample 1000times-----");
		for(int i=0;i<1000;i++){
			int r=(int)test.sample();
			map.put(r, map.get(r)+1);
		}
		for(Entry<Integer,Integer>entry:map.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		System.out.println("----start dequeue-----");
		for(int i=0;i<10;i++){
			System.out.println(test.dequeue());
		}
		
		
//		for(Entry<Integer,Integer>entry:map.entrySet()){
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
	}
	
}
