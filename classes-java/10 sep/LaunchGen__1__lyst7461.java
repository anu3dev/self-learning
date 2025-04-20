import java.util.ArrayList;
import java.util.List;

class Human
{
	public void sleep()
	{
		System.out.println("Human needs sleep");
	}
}

class Student1  extends Human
{
	@Override
	public void sleep()
	{
		System.out.println("Student needs extra sleep");
	}
}

class Employee extends Human
{
	}


public class LaunchGen 
{
	public static void main(String[] args) 
	{
		Object obj=new Object();
		
		String str="Telusko";
		
		obj=str;
		
		Human hu=new Human();
		
		Student1 st=new Student1();
		hu=st;
		
//		ArrayList<Human> human=new ArrayList<>();
//		
//		
//		ArrayList<Student> student=new ArrayList<>();
		
//		student=human;
		//human=student; error
		
//		ArrayList<?> human=new ArrayList<>(); //? --> Unkown type ---> wild card --> Type of data doesnt matter
//		
//		
//		ArrayList<Student> student=new ArrayList<>();
//		
//		human=student;
		
		ArrayList<? extends Human> human=new ArrayList<>(); //upper bound <? extends Human> 
		//it can any child ref of Human or Human --? hihest is hierarchy is Human
		
		ArrayList<Student1> student=new ArrayList<>();
		
		human=student;
//		ArrayList<String> student=new ArrayList<>();
//		
//		human=student; error String is not child of human
		
		ArrayList<? super Human> human1=new ArrayList<>(); //lower bound either or upper hierarchy of Human
		
		//ArrayList<Student> student1=new ArrayList<>();// student is child of human not parent hence error
		
		
		ArrayList<Object> student1=new ArrayList<>();
		
		human1=student1;
		
		ArrayList<Human> human2=new ArrayList<>();
		human2.add(new Human());
//		
//		
		ArrayList<Student1> student2=new ArrayList<>();
		
		student2.add(new Student1());
		
		//callSleep(human2);
		
		//callSleep(student2);
		callSleep(student2);
			

	}
	
	public static void callSleep(List<? extends Human>list)
	{
		for(Human h:list)
		{
			h.sleep();
		}
	}

}
