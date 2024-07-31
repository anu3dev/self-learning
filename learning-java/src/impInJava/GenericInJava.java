/*
 * Collection introduced in java 1.2
 * Generic introduced in java 1.5
 * 
 * Primitive type data is not allowed in Generic, only object type data is allowed.
 * Using Generic, we achieve type safety.
 * 
 * whenever we are sure about size and type of data then we should prefer array.
 * It provides type safety.
 */
package impInJava;

import java.util.ArrayList;
import java.util.List;

class GenericInJavaEx1{
	public GenericInJavaEx1() {
		String []ar1 = new String[5];
		ar1[0] = "Anu";
		ar1[1] = "Rag";
		
		/*
		 * we can't push any other data type in same array
		 */
		//ar1[2] = 5;
		
		/*
		 * we can directly apply inserted data type method like below in array.
		 */
		String str0 = ar1[0];
		System.out.println(str0.toUpperCase());
		String str1 = ar1[1];
		System.out.println(str1.toLowerCase());
	}
}

class GenericInJavaEx2{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericInJavaEx2() {
		ArrayList arrayList1 = new ArrayList();
		
		arrayList1.add("Anu");
		arrayList1.add("Rag");
		
		/*
		 * if we don't use Generic, we can't push other data type
		 */
		arrayList1.add(5);
		
		/*
		 * we have to downcast the data because in ArrayList we are not sure about data type.
		 */
		String str0 = (String) arrayList1.get(0);
		System.out.println(str0.toUpperCase());
		String str1 = (String) arrayList1.get(1);
		System.out.println(str1.toLowerCase());
		int str2 = (int) arrayList1.get(2);
		System.out.println(str2);
		
		/*
		 * below line will break the code at run time because in ArrayList no validation is happening.
		 * no compile error will occur in below scenario
		 */
		//String str3 = (String) arrayList1.get(3);
		//System.out.println(str3.toLowerCase());
	}
}

/*
 * using Generic, string type is only being stored so now no down casting or up casting is required.
 */
class GenericInJavaEx3{
	public GenericInJavaEx3() {
		ArrayList<String> arrayList1 = new ArrayList<String>();
		arrayList1.add("Anu");
		arrayList1.add("Rag");
		
		/*
		 * if we use Generic, we can't push other data type
		 */
		//arrayList1.add(5);
		
		String str0 = arrayList1.get(0);
		System.out.println(str0.toUpperCase());
		String str1 = arrayList1.get(1);
		System.out.println(str1.toLowerCase());
	}
}

class Animal{
	
}

class DogEx extends Animal{
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public DogEx(int age, String name){
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Dog [age=" + age + ", name=" + name + "]";
	}
}

class GenericInJavaEx4{
	public GenericInJavaEx4() {
		DogEx animal1 = new DogEx(5, "jimmy");
		DogEx animal2 = new DogEx(7, "lobo");
		
		/*
		 * after Java version, we can ignore generic name from right side but left side is compulsory.
		 */
		List<DogEx> a1 = new ArrayList<>();
		
		a1.add(animal1);
		a1.add(animal2);
		
		System.out.println(a1);
	}
}

class Gen<T> {
	T ref;
	
	public Gen(T ref) {
		this.ref= ref;
	}
	
	public T getRef() {
		return ref;
	}
	
	public void GenEx1() {
		System.out.println("Type of Gen is "+ ref.getClass().getName());
	}
}

/*
 * example of custom generic
 */
class GenericInJavaEx5{
	public GenericInJavaEx5() {
		Gen<Integer> gen1 = new Gen<>(10);
		gen1.GenEx1();
		
		Gen<String> gen2 = new Gen<>("ANU");
		gen2.GenEx1();
		
		Gen<Object> gen3 = new Gen<>("ANU");
		gen3.GenEx1();
		
		Gen<Object> gen4 = new Gen<>(10);
		gen4.GenEx1();
	}
}

public class GenericInJava {
	public static void main(String[] args) {
		new GenericInJavaEx1();

		System.out.println("***************");
		
		new GenericInJavaEx2();
		
		System.out.println("***************");
		
		new GenericInJavaEx3();

		System.out.println("***************");
		
		new GenericInJavaEx4();

		System.out.println("***************");
		
		new GenericInJavaEx5();
	}
}
