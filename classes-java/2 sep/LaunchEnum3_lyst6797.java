

enum Result1
{
	PASS, FAIL, NR;
}
public class LaunchEnum3 
{

	public static void main(String[] args) 
	{
//		int i=10;
//		String str="JAVA";
		
		Result1 res=Result1.PASS;
		
		
		
		switch(res)
		{
		 	case PASS: System.out.println("Passed the exam");
		 	break;
		 	case FAIL: System.out.println("Failed!");
		 	break;
		 	case NR: System.out.println("No result");
		
		}
	}

}
