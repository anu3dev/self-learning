
class Human
{
	private int age;
	private String name;
	
	public void disp1()
	{
		System.out.println("Disp of parent class");
	}
	
}
class Student extends Human
{
	public void show()
	{
		
//		age=10;
//		name="Sheeru";
//		
//		System.out.println("Age is: "+age);
//		System.out.println("Name is: "+name);
	}
	
}



public class Launch1 {

	public static void main(String[] args) {
		Student s=new Student();
	

	}

}
