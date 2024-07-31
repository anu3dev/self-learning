/*
 * outer class can't be static but inner class can be.
 * 
 * inner class can be of three types
 * member inner class - not used very often
 * static inner class - used very often
 * anonymous inner class - used very often
 * 
 * we can instantiate interface by two ways
 * one is implements keyword and second is by anonymous inner class
 */
package oopsInJava;

class InterfaceAdvEx1 {
	public void show() {
		System.out.println("in InterfaceAdvEx1 show");
	}
	
	/*
	 * member innner class example
	 */
	class InterfaceAdvInnerEx1 {
		public void show() {
			System.out.println("in InterfaceAdvEx2 show");
		}
	}
	
	/*
	 * outer class can't be static but inner class can be.
	 * static innner class example
	 */
	static class InterfaceAdvStaticEx2 {
		public void show() {
			System.out.println("in InterfaceAdvEx3 show");
		}
	}
}

class InterfaceAdvEx2 {
	public void show() {
		System.out.println("in InterfaceAdvEx2 show");
	}
}

abstract class InterfaceAdvEx3 {
	public abstract void drive();
}

interface InterfaceAdvEx4 {
	void drive();

	static void ex7() {
		// TODO Auto-generated method stub
		
	}
}

public class InterfaceAdv {
	public static void main(String[] args) {
		InterfaceAdvEx1 ex1 = new InterfaceAdvEx1();
		ex1.show();
		
		/*
		 * to crate the object of inner class, we need object of outer class.
		 */
		InterfaceAdvEx1.InterfaceAdvInnerEx1 ex2 = ex1.new InterfaceAdvInnerEx1();
		ex2.show();
		
		/*
		 * if inner class id static then this is how we can create obj
		 */
		InterfaceAdvEx1.InterfaceAdvStaticEx2 ex3 = new InterfaceAdvEx1.InterfaceAdvStaticEx2();
		ex3.show();
		
		/*
		 * anonymous inner class
		 */
		InterfaceAdvEx2 ex4 = new InterfaceAdvEx2() {
			@Override
			public void show() {
				System.out.println("in InterfaceAdvEx3 inner show");
			}
			/*
			 * we can write more classes here but while calling it will be error
			 */
			// public void disp() {
				// System.out.println("in InterfaceAdvEx3 inner show");
			// }
		};
		ex4.show();
		/*
		 *  we are getting error here
		 */
		// ex4.disp();
		
		/*
		 * we can instantiate abstract by anonymous inner class
		 */
		InterfaceAdvEx3 ex5 = new InterfaceAdvEx3() {
			@Override
			public void drive() {
				System.out.println("calling from InterfaceAdvEx3");
			};
		};
		
		ex5.drive();
		
		/*
		 * we can instantiate interface by anonymous inner class
		 */
		InterfaceAdvEx4 ex6 = new InterfaceAdvEx4() {
			public void drive() {
				System.out.println("calling from InterfaceAdvEx4");
			};
		};
		
		ex6.drive();
		
		/*
		 * lamda exp introduced in java 8
		 */
		// InterfaceAdvEx4 ex7 = () -> System.out.println("calling from lamda");
	}
}
