import java.util.Date;


public class LaunchDate {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		java.util.Date date=new java.util.Date();
		System.out.println(date);
		
		int month=date.getMonth();
		System.out.println("Month : "+ month);
		
		int time=(int) date.getTime();
		
		java.sql.Date dt= new java.sql.Date(time);
		System.out.println(dt);
		
		
		//java.util.ArrayList al=new java.util.ArrayList();
		
		

	}

}
