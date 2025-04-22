import java.io.File;

public class LaunchFile1 
{

	public static void main(String[] args) 
	{
		String file="D:\\Project\\InputOutput\\telusko.txt";
		String directory="D:\\Project\\InputOutput\\Telusko";
	   
		try
		{
			//File file1=new File(file);
			//file1.createNewFile();
//			System.out.println(file1.exists());//true
//			System.out.println(file1.isDirectory());//false
//			String path=file1.getPath();
//			System.out.println(path);
			
			//File dir=new File(directory);
			//System.out.println(file2.exists());
			
			//dir.mkdir();
			//System.out.println(dir.exists());//true
			//System.out.println(dir.isDirectory());//true
			
			File file3=new File("D:\\Project\\Inheritance\\src");
			String str[]=file3.list();
			
			int count=0;
			for(String f:str)
			{
				count++;
				System.out.println(f);
			}
			System.out.println("The number of files are : "+ count);
			
		}
		catch(Exception e)
		{
			System.out.println("Some exception at run time");
		}

	}

}
