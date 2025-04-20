import java.util.Arrays;

class Demo2
{
	int a,b;
	
	static int count;
	
	
	{
		count++;
	}
	
	public Demo2()
	{
		
	}
	public Demo2(int a, int b)
	{
	
	}
	
}

public class LaunchJI 
{
	public static void main(String[] args) 
	{
		Demo2 d1=new Demo2();
		
		System.out.println(Demo2.count);
		
		Demo2 d2=new Demo2();
		System.out.println(Demo2.count);
		
		Demo2 d3=new Demo2(10,20);
		
		System.out.println(Demo2.count);
		
		
		
	}

}
