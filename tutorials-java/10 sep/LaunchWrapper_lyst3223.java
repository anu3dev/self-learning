import java.util.ArrayList;

public class LaunchWrapper 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int age=10;
		
		Integer i=new Integer((int)10);
		Integer ii=new Integer(10);
		
		char a='c';
		Character ch=new Character('c');
		
		Integer it= Integer.valueOf(10);
		System.out.println(it);
		
		int n1=it.intValue();//unboxing
		
		int num=it;// auto unboxing
		
		double ab=14.4;
		
		//Double d=new Double(ab);
		Double d=Double.valueOf(ab);
		//auto boxing
		
		Double dd=14.4;
		//Double dd=Double.valueOf(14.4);
		
		//primitive date into Object ==> Boxing
		//Object into primitive unboxing
		
		ArrayList list=new ArrayList();
		list.add(10);// autoboxing
		
		Integer iii=(Integer) list.get(0);
		

	}

}
