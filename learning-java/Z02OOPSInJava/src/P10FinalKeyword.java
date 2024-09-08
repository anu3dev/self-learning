/*
 * 
 * final keyword is used to restrict class to participate in inheritance.
 * final keyword can be applied to class and method.
 * we can inheritate final method from a class .
 * however we can't override final method in child class.
 * we can't make abstract method as final bcos child class won't be able to provide implementation
 * 
 * inheritance promotes code reusability.
 * 
 */

/*
 * 
 * below class can't be extended due to final keyword.
 * 
 */
final class Human1 {
	public void disp() {
		System.out.println("Printing from Human1 class");
	}
}


/*
 * 
 *  illegal to use final and abstract together like below.
 *  
 */
//final abstract class Human2 {}

class Human3 {
	/*
	 * 
	 * final keyword can be applied to a variable and it will behave like a const.
	 *  
	 */
	final float pi = 3.14f;
	
	/*
	 * 
	 * we can't override below final method in child.
	 * 
	 */
	final public void disp() {
		System.out.println("Printing from Human1 class");
	}
}

class Employee extends Human3 {
	
/*
 * 
 * we can't override final method here.
 * 
 */
//	public void disp() {
//		System.out.println("Printing from Employee class");
//	}
}

public class P10FinalKeyword {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.disp();
	}
}
