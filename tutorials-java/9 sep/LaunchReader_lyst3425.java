import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class LaunchReader 
{

	public static void main(String[] args) 
	{
		try
		{
			File dir=new File("D:\\Project\\InputOutput");
			
			File file1=new File(dir, "telusko.txt");
			
			
			
			FileReader reader=new FileReader(file1);
			
			int size =(int)file1.length();
			
			char ch[]=new char[size];
			
			reader.read(ch);
			
			for(char c:ch)
			{
				System.out.print(c);
			}
//			int i=reader.read();
//			
//			while(i!=-1)
//			{
//				System.out.print(i + " --> ");
//				System.out.println((char)i);
//				i=reader.read();
//				
//			}
			
//			System.out.println((char)i);
			
			
			
			
			reader.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Some exception");
		}
		

	}

}
