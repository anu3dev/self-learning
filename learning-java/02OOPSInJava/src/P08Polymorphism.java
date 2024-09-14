/*
 * 
 * polymorphism - same thing with different behavior.
 * two types, compile and run time polymorphism.
 * method overloading - compile time polymorphism.
 * method overriding - run time polymorphism
 * 
 */


class Phone {
	public void call() {
		System.out.println("Calling.");
	}
}

class IPhone extends Phone {
	public void call() { 
		/*
		 * 
		 * method overriding - call method from sub class instead of super class.
		 * 
		 */
		System.out.println("Calling from IPhone.");
	}
}

class Pixel extends Phone {
	public void call() { 
		/*
		 * 
		 *  method overriding - call method from sub class instead of super class.
		 *  
		 */
		System.out.println("Calling from Pixel.");
	}
}

/*
 * if call method is not present in sub class then it will print from super else it will take from sub.
 */
public class P08Polymorphism {
	public static void main(String[] args) {
		Phone obj = new IPhone();
		/*
		 *  we can also create super class by referring sub class.	
		 */
		obj.call(); 
		/*
		 *  run time polymorphism because it doesn't know, whether it going to run Pixel method or Iphone method.
		 */
		Phone obj1 = new Pixel();
		/*
		 *  we can also create super class by referring sub class.	
		 */
		obj1.call(); 
	}
}
