import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LaunchBrFR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			File dir=new File("D:\\Project\\InputOutput");
			
			File file1=new File(dir, "telusko.txt");
			
			
			
			FileReader reader=new FileReader(file1);
			
			BufferedReader br=new BufferedReader(reader);
			String data=br.readLine();
			
			while(data!=null)
			{
				System.out.println(data);
				data=br.readLine();
			}
			
			
		
			
			
			
			reader.close();
			
		}
		catch(Exception e)
		{
			System.out.println("Some exception");
		}

	}

}
