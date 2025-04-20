
class Example implements Runnable
{

	@Override
	public void run() 
	{
		for(int i=0;i<3;i++)
		{
			try
			{
				System.out.println("Focus is the key");
				Thread.sleep(4000);
			}
			catch(Exception e)
			{
				System.out.println("Thread is interrupted");
			}
			
		}
		
		
	}
	
}


public class LaunchInterrupt {

	public static void main(String[] args) 
	{
		Example ex=new Example();
		
		Thread t1=new Thread(ex);
		
		t1.start();
		t1.interrupt();
	

	}

}
