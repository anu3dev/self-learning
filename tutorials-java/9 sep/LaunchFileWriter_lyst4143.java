import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LaunchFileWriter 
{

	public static void main(String[] args) 
	{
		
		try
		{
			File dir=new File("D:\\Project\\InputOutput");
			
			File file1=new File(dir, "telusko.txt");
			
			
			 FileWriter fw=new FileWriter(file1, true);
			
			fw.write("Java");
			fw.write("\n");
			fw.write(65);
			
			char ch[]= {'j','d','b','c'};
			fw.write(ch);
			
			
			
			fw.close();
			
			System.out.println("Go and check file in local systenm");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Some exception");
		}
		
		

	}

}
