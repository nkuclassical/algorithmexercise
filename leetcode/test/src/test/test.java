package test;

public class test {
	int value[];
	int f(int a)
	{
		//System.out.println(a);
		if(value[a-1]>0)return value[a-1];
		if(a==1){value[0]=1;return 1;}
		else if(a==2){value[1]=2;return 2;}
		else {value[a-1]=f(a-1)+f(a-2);return value[a-1];}
	}
	public static void main(String[]args)
	{
		int n=50;
		test t=new test();
		t.value=new int[n];
		for(int i=0;i<n;i++)
			t.value[i]=0;
		t.f(n);
		System.out.println(t.value[n-1]);
	}
}
