class Calculator
{
	int num1;
	int num2;
	int res;
	
//	void add()
//	{
//		num1=10;
//		num2=20;
//		res=num1+num2;
//		System.out.println(res);
//	}
	
//	void add(int a, int b)
//	{
//		num1=a;
//		num2=b;
//		res=num1+num2;
//		System.out.println(res);
//	}
	
//	int add()
//	{
//		num1=10;
//		num2=20;
//		res=num1+num2;
//		return res;
//		
//	}
	
	int add(int a, int b)
	{
		num1=a;
		num2=b;
		res=num1+num2;
		return res;
	}
}
public class LaunchMethod 
{
	public static void main(String[] args) 
	{
		Calculator calc=new Calculator();
		//calc.add();
		//calc.add(10,20);
		//int a=calc.add();
		int a=calc.add(10,20);
		
		System.out.println(a);
	}

}
