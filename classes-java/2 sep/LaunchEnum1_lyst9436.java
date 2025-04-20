

//class Week extends Enum{
//	
//	
//}

enum Week
{
	//Mon, Tue
	MON, TUE, WED, THU, FRI, SAT, SUN;
	
	//public static final Week THU=new Week();
	
	
}

public class LaunchEnum1 
{
	//final int AGE=10;
	
	enum Result
	{
		PASS, FAIL, NR;
	}
	

	public static void main(String[] args) 
	{
		Week w=Week.MON;
		
		System.out.println(w);//MON
		
		int index=Week.THU.ordinal();
		System.out.println(index);
		
		Week wr[]=Week.values();
		
		for(Week en:wr)
		{
			System.out.print( en.ordinal() + "- " +  en + " , ");
		}
	

	}

}
