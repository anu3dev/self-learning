/*
 * 
 * types of interface:
 * Normal interface - interface those are not below two means interface which are neither SAM nor Marker.
 * 
 * SAM interface - single abstract method interface exp. clonable
 * clonable or runnable are interface examples which has only one methods.
 * SAM is also called functional or Lambda.
 * 
 * Marker interface - which has zero methods. exp. serialization
 * using serialization keyword we can ask JVM to store the current state of program.
 * 
 * in Lambda, compiler doesn't create .class file separately, it uses the existing .class file
 * we can use this keyword inside lambda and we can modify the value of instance variable inside Lambda
 * 
 * lambda will only work with functional
 * 
 */

interface calcEx1 {
	void show();
}

class CalcImplementationEx1 implements calcEx1 {
	public void show() {
		System.out.println("one way to call show method for interface Ex1");
	}
}

interface calcEx2 {
	void show();
}

interface calcEx3 {
	void square(int num);
}

interface calcEx4 {
	int square(int num);
}

interface calcEx5 {
	int add(int num1, int num2);
}

public class Lambda {
	public static void main(String[] args) {
		
		/*
		 * 
		 * creating object from class in a normal way and calling interface
		 * 
		 */
		CalcImplementationEx1 obj1 = new CalcImplementationEx1();
		obj1.show();
		
		/*
		 * 
		 * calling interface using anonymous method
		 * 
		 */
		calcEx2 obj2 = new calcEx2() {
			public void show() {
				System.out.println("calling for anonymous class");
			}
		};
		obj2.show();
		
		/*
		 * 
		 * calling interface using lambda expression, lambda will only work with functional
		 * 
		 */
		calcEx2 obj3 = () -> {
			System.out.println("calling for lambda class");
		};
		obj3.show();
		
		/*
		 * 
		 * if single statement then no need to write curly braces
		 * 
		 */
		calcEx2 obj4 = () -> System.out.println("if single statement then now curly brances");
		obj4.show();
		
		/*
		 * 
		 * example of lambda exp with param
		 * 
		 */
		calcEx3 obj5 = (int num) -> {
			int res = num*num;
			System.out.println("sq value:" + res);
		};
		obj5.square(5);
		
		/*
		 * 
		 * example of lambda with return type
		 * 
		 */
		calcEx4 obj6 = num ->  num*num;
		int res1 = obj6.square(6);
		System.out.println("sq value:" + res1);
		
		/*
		 * 
		 * example of lambda with return type and two param
		 * 
		 */
		calcEx5 obj7 = (num1, num2) ->  num1 + num2;
		int res2 = obj7.add(7, 5);
		System.out.println("sq value:" + res2);
	}
}