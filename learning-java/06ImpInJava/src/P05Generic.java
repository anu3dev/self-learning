/*
 * 
 * Collection introduced in java 1.2
 * Generic introduced in java 1.5
 * 
 * Primitive type data is not allowed in Generic, only object type data is allowed.
 * Using Generic, we achieve type safety.
 * 
 * whenever we are sure about size and type of data then we should prefer array.
 * It provides type safety.
 * 
 */

import java.util.ArrayList;
import java.util.List;

class GenericEx1{
	public GenericEx1() {
		String []ar = new String[5];
		ar[0] = "Anu";
		ar[1] = "Rag";
		
		/*
		 * 
		 * we can't push any other data type in same array
		 * 
		 */
		//ar[2] = 5;
		
		/*
		 * 
		 * we can directly use method like below at array.
		 * 
		 */
		String str0 = ar[0];
		System.out.println(str0.toUpperCase());
		String str1 = ar[1];
		System.out.println(str1.toLowerCase());
	}
}

class GenericEx2{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericEx2() {
		ArrayList arrayList = new ArrayList();
		
		arrayList.add("Anu");
		arrayList.add("Rag");
		arrayList.add(5);
		
		/*
		 * 
		 * we have to downcast the data because in ArrayList we are not sure about data type.
		 * 
		 */
		String str0 = (String) arrayList.get(0);
		System.out.println(str0.toUpperCase());
		
		String str1 = (String) arrayList.get(1);
		System.out.println(str1.toLowerCase());
		
		int str2 = (int) arrayList.get(2);
		System.out.println(str2);
		
		/*
		 * 
		 * below line will break the code at run time because in ArrayList, validation is not happening.
		 * no compile time error will occur in below scenario
		 * 
		 */
		//String str3 = (String) arrayList1.get(3);
		//System.out.println(str3.toLowerCase());
	}
}

/*
 * 
 * using Generic, string type is only being stored so now no down casting or up casting is required.
 * 
 */
class GenericEx3{
	public GenericEx3() {
		ArrayList<String> arrayList1 = new ArrayList<String>();
		arrayList1.add("Anu");
		arrayList1.add("Rag");
		
		/*
		 * 
		 * if we use Generic, we can't push other data type
		 * 
		 */
		//arrayList1.add(5);
		
		String str0 = arrayList1.get(0);
		System.out.println(str0.toUpperCase());
		
		String str1 = arrayList1.get(1);
		System.out.println(str1.toLowerCase());
	}
}

class Animal{}

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

class GenericEx4{
	public GenericEx4() {
		DogEx animal1 = new DogEx(5, "jimmy");
		DogEx animal2 = new DogEx(7, "lobo");
		
		/*
		 * 
		 * we can ignore generic name from right side but left side is compulsory in newer version of Java.
		 * 
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
 * 
 * example of custom generic
 * 
 */
class GenericEx5{
	public GenericEx5() {
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

public class P05Generic {
	public static void main(String[] args) {
		//new GenericEx1();
		
		//new GenericEx2();
				
		//new GenericEx3();
		
		//new GenericEx4();
		
		new GenericEx5();
	}
}
