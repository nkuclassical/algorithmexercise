import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

abstract class animal
{
	public abstract void a();
	public void b()
	{
		System.out.println("I'm animal");
	}
}
class dog extends animal
{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("I'm a dog");
	}
}
class cat extends animal
{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("I'm a cat");
	}
}

final class String implements Comparable
{

	private char[]value;
	private int length;
	private int hash;
	private int offset;
	public String(int offset,int length,char[]value)
	{
		this.offset=offset;
		this.length=length;
		this.value=value;
	}
	public String substring(int from,int to)
	{
		return new String(offset+from,to-from,value);
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
public class interview {
	volatile boolean close=false;
	public static void main(String[]args) throws InterruptedException
	{
		animal d=new dog();
		d.a();
		d.b();
		d=new cat();
		d.a();
		d.b();
	}
}
