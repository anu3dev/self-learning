import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable
{
	private int id;
	transient private String name;
	private int age;
	public Student(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public void disp()
	{
		System.out.println("id : "+ id);
		System.out.println("name : "+ name);
		System.out.println("age : "+ age);
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}


public class LaunchSt 
{

	public static void main(String[] args) 
	{
		try
		{
			
		
//		Student st1=new Student(1, "Rohan", 16);
//		st1.disp();
//		
//		FileOutputStream fos=new FileOutputStream("D:\\Project\\InputOutput\\telusko.txt");
//		BufferedOutputStream bos=new BufferedOutputStream(fos);
//		ObjectOutputStream oos=new ObjectOutputStream(bos);
//	
//		oos.writeObject(st1);
//		oos.flush();
//		oos.close();
		
		FileInputStream fis=new FileInputStream("D:\\Project\\InputOutput\\telusko.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		ObjectInputStream ois=new ObjectInputStream(bis);
		
		Student s=(Student) ois.readObject();
		
		s.disp();
		
		
		
		

	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}