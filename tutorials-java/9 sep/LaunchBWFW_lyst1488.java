import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LaunchBWFW {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			File dir=new File("D:\\Project\\InputOutput");
			
			File file1=new File(dir, "telusko.txt");
			
			
			 FileWriter fw=new FileWriter(file1, true);
			 BufferedWriter bw=new BufferedWriter(fw);
			 
			 bw.write("Java");
			 bw.newLine();
			 bw.write(65);
			 
			 
			 
			
			
			
			bw.flush();
			bw.close();
			fw.close();
			
			System.out.println("Go and check file in local systenm");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Some exception");
		}
		

	}

}
