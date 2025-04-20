import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Telusko implements AutoCloseable
{

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Resource is closed! Java is awsome");
		
	}

	
	}


public class LaunchBWFW {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		try(Telusko res=new Telusko())
		{
			System.out.println("Using recource");
		}
		//FileWriter fw=null;
		//BufferedWriter bw=null;
//		try(BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\Project\\InputOutput\\telusko.txt")))
//		{
////			File dir=new File("D:\\Project\\InputOutput");
////			
////			File file1=new File(dir, "telusko.txt");
//			
//			
//			 //fw=new FileWriter(file1, true);
//			 // bw=new BufferedWriter(fw);
//			 
//			 bw.write("Java");
//			 bw.newLine();
//			 bw.write(65);
//			 
//			 
//			 
//			
//			
//			
//			bw.flush();
//		
//			
//			System.out.println("Go and check file in local systenm");
//			
//			
//		}
//		catch(Exception e)
//		{
//			System.out.println("Some exception");
//		}
//		
////		finally 
////		{
////			bw.close();
////			fw.close();
////			
////		}
//		

	}

}
