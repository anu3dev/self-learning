/*
 * 
 * we can have static/non-static variable, static/non-static block, static/non-static method etc.
 * non-static variables created while object creation, if object is not there, instance variable will also be not there.
 * but static variables are not dependent on object creation.
 * Static variable memory will be allocated on Heap area during class loading itself.
 * class loader subsystem -> linking -> preparation
 * JVM will also initialize default value to static variable at this stage.
 * 
 * Static block will be executed during class loading itself. 
 * Static variable and block will be invoked automatically, rest of all the things we have to invoke.
 * static variable and static method called even before the main method.
 * static and abstract can't use together.
 * 
 * Outer class can't be static but inner class can be.
 * inner class can be of three types-
 * member inner class - not used very often
 * static inner class - used very often
 * anonymous inner class - used very often
 * 
 */

class StaticEx1 {
	static int a;
	int x,y;
	
	static {
		a = 10;
		System.out.println("value of a from static block: " + a);
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

class StaticEx2 {
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

class StaticEx3 {
	public void show() {
		System.out.println("in StaticEx3 show method");
	}
	
	/*
	 * 
	 * member inner class example
	 * 
	 */
	class InnerStaticEx1 {
		public void show() {
			System.out.println("in StaticEx3 in InnerStaticEx1 show method");
		}
	}
	
	/*
	 * 
	 * outer class can't be static but inner class can be.
	 * static inner class example
	 * 
	 */
	static class InnerStaticEx2 {
		public void show() {
			System.out.println("in StaticEx3 in InnerStaticEx2 show method");
		}
	}
}

class StaticEx4 {
	public void show() {
		System.out.println("in StaticEx4 show method");
	}
}


public class P05StaticKeyword {
	
	/*
	 * 
	 * example of static variable in main object.
	 * 
	 */
	static int a;
	
	/*
	 * 
	 * example of static block in main object.
	 * 
	 */ 
	static {
		a = 10;
		System.out.println("Static block from main...");
	}
	
	public static void main(String[] args) {
		
		/*
		 * 
		 * below will be output here-
		 * Static block from main...
		 * main method which is also static...
		 * 
		 * Static variable and block will be invoked automatically even before main.
		 * 
		 */
		System.out.println("main method which is also static...");
		
		/*
		 * 
		 * below will be output here-
		 * value of a from static block: 10
		 * non static block...
		 * value of x: 15
		 * value of y: 20
		 * 
		 * Static variable and block will be invoked automatically even without invoking.
		 * 
		 */
		System.out.println();
		StaticEx1 ex1 = new StaticEx1();
		ex1.disp();
		
		/*
		 * 
		 * below will be output here-
		 * static block...
		 * value of a: 10
		 * value of b: 12
		 * 
		 * method from static block can be called even without creating the object.
		 * 
		 */
		System.out.println();
		StaticEx2.disp1();
		
		System.out.println();
		StaticEx3 ex2 = new StaticEx3();
		ex2.show();
		
		System.out.println();
		/*
		 * 
		 * to crate the object of inner class, we need object of outer class.
		 * 
		 */
		StaticEx3.InnerStaticEx1 ex3 = ex2.new InnerStaticEx1();
		ex3.show();
		
		System.out.println();
		/*
		 * 
		 * if inner class is static then this is how we can create obj
		 * 
		 */
		StaticEx3.InnerStaticEx2 ex4 = new StaticEx3.InnerStaticEx2();
		ex4.show();
		
		System.out.println();
		/*
		 * 
		 * anonymous inner class
		 * 
		 */
		StaticEx4 ex5 = new StaticEx4() {
			@Override
			public void show() {
				System.out.println("in StaticEx4 anonymous inner show method");
			}
			/*
			 * 
			 * we can write more classes here but while calling it will generate error
			 * 
			 */
			 @SuppressWarnings("unused")
			 public void disp() {
				 System.out.println("in InterfaceAdvEx3 inner show");
			 }
		};
		ex5.show();
		/*
		 * 
		 *  we are getting error here while calling this method
		 *  
		 */
		// ex4.disp();
	}
}
