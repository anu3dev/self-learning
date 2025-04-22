import java.util.Scanner;

class Demo
{
	void alpha()throws Exception
	{
		System.out.println("Connection2 is Established to An App");
		Scanner scan =new Scanner(System.in);
		try
		{
		
		System.out.println("Kindly enter the numerator to divide ");
		int num1=scan.nextInt();
		System.out.println("Kindly enter the denominator");
		int num2=scan.nextInt();
		
		int res=num1/num2;

		System.out.println("The result is : "+ res);
		}
		catch(Exception e)
		{
			System.out.println("Exception is handled in alpha()");
			throw e;
		}
		
		finally
		{

		System.out.println("Connection2 is termintaed from An App");
		}
		
	}
}
public class LaunchEH4 {

	public static void main(String[] args) 
	{
		System.out.println("Connection1 is Established to An App");
		try
		{
		Demo d=new Demo();
		d.alpha();
		}
		catch(Exception e)
		{
			System.out.println("Exception is handled in main method");
		}
		
		System.out.println("Connection1 is termintaed from An App");



	}

}
