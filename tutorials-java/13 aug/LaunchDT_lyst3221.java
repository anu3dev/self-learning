class WordPad extends Thread
{
	public void run()
	{
		String tName=Thread.currentThread().getName();
		if("Type".equals(tName))
		{
			typing();
		}
		else if("Spell".equals(tName))
		{
			spellCheck();
		}
		else
		{
			autoSave();
		}
		
	}
	
	public void typing()
	{
		try
		{
			for(int i=0;i<3; i++)
			{
				System.out.println("Typing...");
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Some problem");
		}
		
		
	}
	public void spellCheck()
	{
		try
		{
			for(; ; )
			{
				System.out.println("spelling check...");
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Some problem");
		}
		
		
	}
	public void autoSave()
	{
		try
		{
			for(; ; )
			{
				System.out.println("saving...");
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			System.out.println("Some problem");
		}
		
		
	}
	
}


public class LaunchDT 
{

	public static void main(String[] args) 
	{
		WordPad wd1=new WordPad();
		WordPad wd2=new WordPad();
		WordPad wd3=new WordPad();
		
		wd1.setName("Type");
		wd2.setName("Spell");
		wd3.setName("Save");
		
		wd2.setDaemon(true);
		wd3.setDaemon(true);
		
		wd2.setPriority(3);
		wd3.setPriority(2);
		
		wd1.start();
		wd2.start();
		wd3.start();
	}

}
