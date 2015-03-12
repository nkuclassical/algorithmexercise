package constructor;

public class copy {
	public copy(String name,int age, String sexual)
	{
		this.name=name;
		this.age=age;
		this.sexual=sexual;
	}
	
	public copy(copy c)
	{
		this(c.name,c.age,c.sexual);
	}
	public void display()
	{
		System.out.println(this.name+" "+this.age+" "+this.sexual);
	}
	String name;
	int age;
	String sexual;
	
	public static void main(String[]args)
	{
		copy o=new copy("Wang",12,"Male");
		copy b=new copy(o);
		b.age=20;
		o.display();
		b.display();
	}
}
