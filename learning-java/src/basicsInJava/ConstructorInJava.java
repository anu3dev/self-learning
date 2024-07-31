/*
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
 */
package basicsInJava;

class ConstructorInJavaEx1 {
    private String name;
    private int age;
    private int cost;
    
    ConstructorInJavaEx1() {
        this.name = "Lobo";
        this.age = 7;
        this.cost = 14333;
    }
    
    ConstructorInJavaEx1(String name, int age, int cost) {
        this.name = name;
        this.age = age;
        this.cost = cost;
    }
    /*
     * above is also a example of constructor overloading, two constructor with same name but with different parameter.
     */
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCost() {
        return cost;
    }
}

class ConstructorInJavaEx2 {
    private String name;
    private int age;
    private int cost;
    
    ConstructorInJavaEx2() {
        System.out.println("I am from constructor with zero param.");
    }
        
    ConstructorInJavaEx2(String name, int age, int cost) {
    	this();
        this.name = name;
        this.age = age;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCost() {
        return cost;
    }
}

public class ConstructorInJava {
	public static void main(String[] args) {
		ConstructorInJavaEx1 ex1 = new ConstructorInJavaEx1(); 
		/*
		 * example of call to a constructor with no parameter.
		 * constructor with no parameter will be called here.
		 * 
		 *  output -> Lobo 7 14333
		 */
        System.out.println(ex1.getName() +" "+ ex1.getAge() +" "+ ex1.getCost());
        
        ConstructorInJavaEx1 ex2 = new ConstructorInJavaEx1("Sheru", 2, 12000); 
		/*
		 * example of call to a constructor with parameter.
		 * constructor with parameter will be called here.
		 * 
		 *  output -> Sheru 2 12000
		 */
        System.out.println(ex2.getName() +" "+ ex2.getAge() +" "+ ex2.getCost());
        
        ConstructorInJavaEx2 ex3 = new ConstructorInJavaEx2(); 
        /*
		 *  output -> I am from constructor with zero param. - null 0 0
		 *  null 0 0 bcos it is just printing the default value as we aren't setting any value.
		 */
        System.out.println(ex3.getName() +" "+ ex3.getAge() +" "+ ex3.getCost());
        
        ConstructorInJavaEx2 ex4 = new ConstructorInJavaEx2("Sheru", 2, 12000);
        /*
         * example of this(), it will call constructor within same class first.
         * 
         * output -> I am from constructor with zero param. - Sheru 2 12000
         * 
         * since we have added this method, it will fetch the constructor with zero param from same class only.
         */
        System.out.println(ex4.getName() +" "+ ex4.getAge() +" "+ ex4.getCost()); 
	}
}
