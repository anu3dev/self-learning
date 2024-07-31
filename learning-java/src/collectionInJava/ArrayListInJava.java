/*
 * An array is a fixed-length data structure, ArrayList is a variable-length data structure.
 * It can store similar as well as different data types.
 */
package collectionInJava;

import java.util.ArrayList;
import java.util.List;

class ArrayListInJavaEx1{
	ArrayListInJavaEx1(){
		ArrayList<Integer> arrList1 = new ArrayList<Integer>();
		
		arrList1.add(5);
		arrList1.add(6);
		arrList1.add(2);
		
		System.out.println("normal way: " + arrList1);
		
		System.out.println();
		
		/*
		 * enhance for loop
		 */
		for(int num : arrList1) {
			System.out.println(num);
		}
		
		System.out.println();
		
		/*
		 * enhance for each using lambda exp
		 */
		arrList1.forEach(n -> System.out.println(n));	
	}
}

class ArrayListInJavaEx2{
	ArrayListInJavaEx2(){
		ArrayList<String> arrList1 = new ArrayList<String>();
		
		arrList1.add("Hello");
		arrList1.add("World");
		
		System.out.println("normal way: " + arrList1);
		
		System.out.println();
		
		/*
		 * enhance for loop
		 */
		for(String num : arrList1) {
			System.out.println(num);
		}
		
		System.out.println();
		
		/*
		 * enhance for each using lambda exp
		 */
		arrList1.forEach(n -> System.out.println(n));	
	}
}

class ArrayListInJavaEx3{
	ArrayListInJavaEx3(){
		ArrayList<Object> arrList1 = new ArrayList<Object>();
		
		arrList1.add("Hello");
		arrList1.add("World");
		arrList1.add(1);
		arrList1.add(2);
		
		System.out.println("normal way: " + arrList1);
		
		System.out.println();
		
		/*
		 * enhance for loop
		 */
		for(Object num : arrList1) {
			System.out.println(num);
		}
		
		System.out.println();
		
		/*
		 * enhance for each using lambda exp
		 */
		arrList1.forEach(n -> System.out.println(n));	
	}
}


class ArrayListInJavaEx4{
	ArrayListInJavaEx4(){
		@SuppressWarnings("rawtypes")
		List<List> listOfMixedTypes = new ArrayList<List>();

		ArrayList<String> listOfStrings = new ArrayList<String>();
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();

		listOfMixedTypes.add(listOfStrings);
		listOfMixedTypes.add(listOfIntegers);
				
		listOfStrings.add("Hello");
		listOfStrings.add("World");
		listOfIntegers.add(1);
		listOfIntegers.add(2);
		
		System.out.println("normal way: " + listOfMixedTypes);
		
		System.out.println();
		
		/*
		 * enhance for loop
		 */
		for(@SuppressWarnings("rawtypes") List num : listOfMixedTypes) {
			System.out.println(num);
		}
		
		System.out.println();
		
		/*
		 * enhance for each using lambda exp
		 */
		listOfMixedTypes.forEach(n -> System.out.println(n));	
	}
}

public class ArrayListInJava {
	public static void main(String[] args) {
		//new ArrayListInJavaEx1();
		//new ArrayListInJavaEx2();
		//new ArrayListInJavaEx3();
		//new ArrayListInJavaEx4();
	}
}
