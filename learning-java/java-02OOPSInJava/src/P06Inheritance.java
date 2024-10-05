/*
 * 
 * Whenever child class inherits or extends the parents property it is called inheritance. 
 * single parent and single child - single level inheritance
 * multi parent and multi child - multi level inheritance
 * 
 * more than one parent - multiple inheritance - not supported in java due to Diamond shaped / ambiguity problem.
 * reason is it will be confused, from which parent it should call.
 * 
 * Private properties of a class don't participate in inheritance 
 * however others like protected, default and public member participate.
 * 
 * Using inheritance we can achieve Is-A relationship.
 * 
 * inherited method - inherited in child from parents without modification
 * Overridden method - inherited in child from parents with modification
 * Specialized methods - such methods only present in child class and not in parents class.
 * 
 * Whenever we create Object of a class , reference variable must be of same type as that of the object.
 * ex. Dog d = new Dog();
 * 
 * To Achieve Polymorphism : We must override method to see change in behavior in the output.
 * method overriding - run time polymorphism
 * 
 * access level of variable type:
 * within a class => public, protected, default and private
 * within package outside class => public, protected and default
 * outside package and is-A relation => public and protected
 * outside package and no is-A relation => public
 * 
 * visibility => public > protected > default > private
 * 
 */


/*
 * 
 *  example is an example of multi level inheritance.
 *  
 */
class Calc {
	/*
	 * 
	 *  this is parent class of CalcPro
	 *  
	 */
	public int add(int n1, int n2) {
		return n1 + n2;
	}
}

class CalcPro extends Calc {
	/*
	 * 
	 *  this is parent class of CalcProMax and child class of Calc
	 *  
	 */
	public int sub(int n1, int n2) {
		return n1 - n2;
	}
}

class CalcProMax extends CalcPro {
	/*
	 * 
	 *  this is child class of CalcPro
	 *  
	 */
	public int mul(int n1, int n2) {
		return n1 * n2;
	}
}

/*
 * 
 *  below example is an example of super(), whether a developer will add or not, super() will be called automatically.
 *  
 */
class A {
	public A() {
		/*
		 * 
		 *  whenever write a constructor, best practice to add a public keyword with it.
		 *  it will call object class, in Java every main parent extends to object class.
		 *  output will be same, whether developer writes super() method or not.
		 *  
		 */
		super();
		System.out.println("int A");
	}
}

class B extends A {
	public B() {
		super();
		/*
		 * 
		 *  will call constructor from class A due to super keyword.
		 *  
		 */
		System.out.println("int B");
	}
}

class C extends B {
	public C() {
		super();
		/*
		 * 
		 *  will call constructor from class B due to super keyword.
		 *  output -> int A - int B - int C
		 *  
		 */
		System.out.println("int C");
	}
}

/*
 * 
 *  Below example is also an example of constructor overloading, if we pass param then constructor 
 *  with param will be called else without param constructor will be called.
 *  if we add this() method in child then it won't call parent constructor, it will call constructor within same class.
 *  
 */
class D {
	public D() {
		System.out.println("in D");
	}

	public D(int num) {
		System.out.println("in D int");
	}
}

class E extends D {
	public E() {
		System.out.println("in E");
	}

	public E(int num) {
		this();
		/*
		 * 
		 * output with param -> in D - in E - in E int, 
		 * output without param -> in D - in E,
		 * this() from E will call E constructor with zero-param and it will call parent D due to default super()
		 * 
		 */
		System.out.println("in E int");
	}
}

/*
 * 
 *  below is example of constructor chaining, we are calling one constructor using others.
 *  in this example, all four constructors will be called.
 *  
 *  reason is, since we are passing param to G so G with param will be called and since we are using this()
 *  in G with param, it will call G with zero-param, and due to by default super(), it will call F with zero-param and 
 *  since from F with zero-param, we are calling this(5); so it will call F with param constructor.
 *  
 */
class F {
	public F() {
		this(5);
		System.out.println("in F");
	}

	public F(int num) {
		System.out.println("in F int");
	}
}

class G extends F {
	public G() {
		System.out.println("in G");
	}

	public G(int num) {
		this();
		System.out.println("in G int");
	}
}

/*
 * 
 *  we can fetch method and variable from parent class as well
 *  if child has variable or method with same name then it will call else it will pull from parents
 *  although we can call from parent as well in case of same name in child using super.
 *  
 */
class H {
	int num = 9;
	int num1 = 11;
}

class I extends H {
	int num = 10;

	public void show() {
		System.out.println(num);
		
		/*
		 * 
		 * it will fetch parents only bcos num1 is not present locally.
		 * 
		 */
		System.out.println(num1);
		/*
		 * 
		 *  it will fetch value from self class only and if variable or method name won't
		 *  be there with same name then it will fetch from parent class.
		 *  
		 */
		System.out.println(super.num);
		/*
		 * 
		 *  it will fetch from parent only.
		 *  
		 */
	}
}

public class P06Inheritance {
	public static void main(String[] args) {

		CalcProMax obj = new CalcProMax();
		int res1 = obj.add(9, 7);
		int res2 = obj.sub(9, 7);
		int res3 = obj.mul(9, 7);
		/*
		 * 
		 * object created and constructor called.
		 * 
		 */
		System.out.println(res1 + " " + res2 + " " + res3);

		/*
		 * 
		 *  output is int A then int B then int C because of super(), always goes to parent constructor due to super()
		 *  
		 */
		System.out.println();
		new C();
		
		/*
		 * 
		 * example of this() method.
		 * 
		 */
		System.out.println();
		new E(5);
		System.out.println();
		new E();
		
		/*
		 * 
		 *  example of constructor chaining.
		 *  
		 */
		System.out.println();
		new G(5);
		
		System.out.println();
		I I1 = new I();
		I1.show();
	}
}
