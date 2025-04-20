import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LaunchPW 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		File dir=new File("D:\\Project\\InputOutput");
		
		File file1=new File(dir, "telusko.txt");
		
		PrintWriter pw=new PrintWriter(file1);
		
		pw.write(65);
		pw.write("\n");
		
		pw.println(45);
		pw.println("JAVA");
		pw.println(45.5);
		pw.println('T');
		
		pw.close();
		
		

	}

}
