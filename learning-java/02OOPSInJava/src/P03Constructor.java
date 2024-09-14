/*
 * 
 * constructor is a type of a special method or kind of setter with same name as class and doesn't have any return type.
 * Construction are automatically called during object creation only.
 * If we don't include constructor in class then Java will invoke default constructor with zero parameter.
 * However If programmer has included any constructor either with parameter or no-parameter, Java will not invoke default constructor.
 * 
 * Having more than one constructor with different parameter can be referred as constructor overloading.
 * 
 * Whether you write or not, super() method will be there in constructor as a first method call.
 * super() method won't be there if and only if we write this() method.
 * super() method job is to call parent class constructor and this() method calls contractor within same class.
 * constructor with zero-parameter will be called with this method.
 * 
 * constructor chaining - one constructor calling another one, this can be achieved by super() or this().
 * 
 */

class ConstructorEx1 {
    private String name;
    private int age;
    
    ConstructorEx1() {
        this.name = "Lobo";
        this.age = 7;
    }
    
    /*
     * 
     * above is also a example of constructor overloading, two constructor with same name but with different parameter.
     * 
     */
    ConstructorEx1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ConstructorEx2 {
    private String name;
    private int age;
    
    ConstructorEx2() {
        System.out.println("I am from constructor with zero param.");
    }
        
    ConstructorEx2(String name, int age) {
    	this();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ConstructorEx3 {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ConstructorEx3() {
		super();
		System.out.println("zero param constructor");
	}
	
	public ConstructorEx3(String name) {
		super();
		this.name = name;
	}
}

public class P03Constructor {
	public static void main(String[] args) {
		
		/*
		 * 
		 * example of call to a constructor with no parameter.
		 * constructor with no parameter will be called here.
		 * output -> Lobo 7
		 *  
		 */
		ConstructorEx1 ex1 = new ConstructorEx1(); 
        System.out.println(ex1.getName() +" "+ ex1.getAge());
        
        /*
         * 
		 * example of call to a constructor with parameter.
		 * constructor with parameter will be called here.
		 * output -> Sheru 2
		 * 
		 */
        ConstructorEx1 ex2 = new ConstructorEx1("Sheru", 2); 
        System.out.println(ex2.getName() +" "+ ex2.getAge());
        
        /*
         * 
		 * output -> I am from constructor with zero param. - null 0
		 * null 0 -> bcos it is just printing the default value as we aren't setting any value.
		 * 
		 */
        ConstructorEx2 ex3 = new ConstructorEx2(); 
        System.out.println(ex3.getName() +" "+ ex3.getAge());
        
        /*
         * 
         * example of this(), it will call constructor within same class first.
         * output -> I am from constructor with zero param. - Sheru 2
         * since we have added this method, it will fetch the constructor with zero param from same class only.
         * 
         */
        ConstructorEx2 ex4 = new ConstructorEx2("Sheru", 2);
        System.out.println(ex4.getName() +" "+ ex4.getAge()); 
        
        /*
         * 
         * output -> zero param constructor - Anurag
         * 
         */
        ConstructorEx3 ex5 = new ConstructorEx3();
        ex5.setName("Anurag");
        System.out.println(ex5.getName());
        
        /*
         * 
         * only parameterized constructor will be revoked.
         * output -> Nitish
         * 
         */
        ConstructorEx3 ex6 = new ConstructorEx3("Nitish");
        System.out.println(ex6.getName());
	}
}

