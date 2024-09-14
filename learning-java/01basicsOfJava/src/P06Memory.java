/*
 * 
 * Java can have multiple files so first file needs to have main method with signature public static void main(String[] args)
 * if return will be there then we can't use void.
 * 
 * 
 * In RAM,  a space or environment has been created to run java application and
 * that is JRE, means Java run time environment.
 * JRE has JVM, Java virtual machine, JVM will execute the code.
 * While executing the code, JVM needs help of data area like method area, runtime stack area, 
 * Heap area, native stack area, PC stack area.
 * 
 * 
 * local variable, methods are part of stack area
 * Instance variable, object creation are part of heap area
 * 
 * 
 * A variable is local or instance, it depends at the place where we are writing it.
 * 
 * 
 * Instance variables are directly declared inside class
 * instance variable memory are allocated inside heap area
 * instance variable memory will be de-allocatde with garbage collector when object became refrence-less
 * 
 * 
 * Local variables are directly declared inside method/block/loop within a class
 * memory is allocated inside stack area
 * memory is de-alloacted when stack frame of that method/block/loop de-alloacted after completion of task
 * 
 */

class Calc {
	
	/*
	 * instance variable
	 */
	int num1;
	int num2;
	
	void add() {
		
		/*
		 * local variable
		 */
		num1 = 10;
		num2 = 20;
		
		int res = num1 + num2;
		System.out.println(res);
	}
}
public class P06Memory {

	public static void main(String[] args) {
		Calc cal = new Calc();
		cal.add();
	}
}
