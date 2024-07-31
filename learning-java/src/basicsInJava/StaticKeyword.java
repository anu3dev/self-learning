/*
 * we can have static/non-static variable, static/non-static block, static/non-static method etc.
 * non-static variables created while object creation, if object is not there, instance variable will also be not there.
 * but static variables are not dependent on object creation.
 * Static variable memory will be allocated on Heap area during class loading itself.
 * class loader subsystem -> linking -> prepration
 * JVM will also intilize default value to static variable at this stage.
 * 
 * Static block will be executed during class loading itself. 
 * 
 * Static variable and block will be invoked automatically, 
 * rest of all the things we have to invoke.
 * 
 * static variable and static method called even before the main method.
 * 
 * static and abstract can't use together
 */
package basicsInJava;

class StaticKeywordEx1 {
	static int a;
	int x,y;
	
	static {
		a = 10;
		
		System.out.println("value of a from static block: "+a);
	}
	
	{
		x = 15;
		y = 20;
		
		System.out.println("non static block...");
	}
	
	public void disp() {
		System.out.println("value of x: "+ x);
		System.out.println("value of y: "+ y);
	}
}

class StaticKeywordEx2 {
	static int a,b;
	int x,y;
	
	static {
		a = 10;
		b = 12;
		
		System.out.println("static block...");
	}
	
	{
		x = 15;
		y = 20;
		
		System.out.println("non static block...");
	}
	
	public static void disp1() {
		System.out.println("value of a: "+ a);
		System.out.println("value of b: "+ b);
	}
	
	public void disp2() {
		System.out.println("value of x: "+ x);
		System.out.println("value of y: "+ y);
	}
}

public class StaticKeyword {
	
	/*
	 * example of static variable in main object.
	 */
	static int a;
	
	/*
	 * example of static block in main object.
	 */ 
	static {
		a = 10;
		System.out.println("Static block from main...");
	}
	
	public static void main(String[] args) {
		
		/*
		 * below will be output here
		 * 
		 * Static block from main...
		 * main method which is also static...
		 * 
		 * Static variable and block will be invoked automatically even before main.
		 */
		System.out.println("main method which is also static...");
		
		/*
		 * below will be output here
		 * 
		 * value of a from static block: 10
		 * non static block...
		 * value of x: 15
		 * value of y: 20
		 * 
		 * Static variable and block will be invoked automatically even without invoking.
		 */
		StaticKeywordEx1 ex1 = new StaticKeywordEx1();
		ex1.disp();
		
		/*
		 * below will be output here
		 * 
		 * static block...
		 * value of a: 10
		 * value of b: 12
		 * 
		 * method from static block can be called even without creating the object.
		 */
		StaticKeywordEx2.disp1();
	}
}
