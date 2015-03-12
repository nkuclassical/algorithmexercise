import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
abstract class Person
{
	public abstract void d(int x,int y);
}
class Employee extends Person
{
	int salary;
	String name;
	public Employee(String n)
	{
		name=n;
	}
	public Employee(String n,int s)
	{
		salary=s;
		name=n;
	}
	@Override
	public void d(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
class Manager extends Employee
{
	String department;
	public Manager(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	public Manager(String n,int s)
	{
		super(n,s);
	}
	public Manager(String d,String n,int s)
	{
		super(n,s);
		department=d;
		
	}
	
}
interface r
{
	public static final int a=3;
	public abstract void b();
	public void print();
}
interface g
{
	public static final int a=3;
	public abstract void b();
}
interface b
{
	public static final int a=3;
	public abstract void b();
}
class rgb implements r,g,b
{

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}
class ca
{
	}

public class Solution {
public static void main(String[]args) 
{
	//Manager m=(Manager) new Employee("12");
	StringBuilder a = new StringBuilder();
	a.append("123");
	a.setCharAt(1, '3');
	a.append("fsadjk");
	String b=a.toString();
	System.out.println(b);
	/*
	URL url;
	InputStream is=null;
	BufferedReader br;
	String line;
	
	try
	{
		url=new URL("http://personal.stevens.edu/~yzhan14/");
		is=url.openStream();
		br=new BufferedReader(new InputStreamReader(is));
		while((line=br.readLine())!=null)
		{
			System.out.println(line);
		}
	}catch(MalformedURLException mue)
	{
		mue.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(is!=null)is.close();
		}catch(IOException e)
		{
			
		}
	}
	*/
	
}
}
