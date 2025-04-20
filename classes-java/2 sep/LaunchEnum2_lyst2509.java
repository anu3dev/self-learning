
//class Result extends Enum{
//}
//class Demo
//{
//	void disp()
//	{
//		System.out.println("hello");
//	}
//}


enum Result
{
	PASS, FAIL, NR;
	
	//public static final Result PASS=new Result();
	//public static final Result FAIL=new Result();
	//public static final Result NR=new Result();
	
	int marks;
	
	Result()
	{
		System.out.println("Constructor of enum");
	}
	
	void setMarks(int marks)
	{
		this.marks=marks;
	//
	}
	
	int getMarks()
	{
		return marks;
	}
}


public class LaunchEnum2 
{

	public static void main(String[] args) 
	{
		Result.PASS.setMarks(44);
		
		int marks=Result.PASS.getMarks();
		
		System.out.println(marks);//44
		
		int m2=Result.FAIL.getMarks();
		System.out.println(m2);//0
		
//		Demo d1=new Demo();
//		d1.disp();
//		
//		Demo d2=new Demo();
//		d2.disp();
		

	}

}
