package j003arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList (Dynamic Array) - ArrayList is a dynamic, index-based collection that maintains insertion order, allows duplicates and 
 * 	null values, provides fast random access, and is best suited for frequent read operations and insertions/removals at the end.
 *
 * 1. ArrayList is a resizable (dynamic) array.
 *    - Size increases or decreases automatically.
 *
 * 2. It implements the List interface.
 *
 * 3. Stores data in insertion order.
 *    - Elements come out in the same order they were added.
 *
 * 4. Allows duplicate elements.
 *    Example: [10, 20, 10]
 *
 * 5. Allows null values.
 *
 * 6. Stores elements by index.
 *    - First element -> index 0
 *    - Supports get(index), set(index), add(index)
 *
 * 7. Best for fast data access.
 *    - get(index) is O(1)
 *
 * 8. Best when adding/removing elements at the end.
 *    - add(element) -> O(1) (amortized)
 *    - remove(last) -> O(1)
 *
 * 9. Adding/removing in the middle or beginning is slow.
 *    - Remaining elements need to be shifted.
 *    - Time Complexity: O(n)
 *
 * 10. Can store any object.
 *     - Without Generics: different data types (stored as Object)
 *     - With Generics: only one specific type (recommended)
 *
 * Example:
 * ArrayList list = new ArrayList();      // Heterogeneous
 * ArrayList<String> list = new ArrayList<>(); // Homogeneous
 */

class Employee {
	String name;
	String dept;
	int age;
	
	Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", dept=" + dept + ", age=" + age + "]";
	}
}

public class J001ArrayList {
	public static void main(String[] args) {
		List<String> cart = new java.util.ArrayList<String>();
		
		cart.add("iphone");
		cart.add("android");
		cart.add("windows");
		
		System.out.println(cart);				// printing arraylist
		System.out.println(cart.get(1));		// printing arraylist elements with index
		
		cart.set(1, "macbook");		
		cart.remove(2);
		System.out.println(cart);				// printing arraylist after update and removal of an element with index
		
		// cart.set(5, "iPad");					// index out of bounds error
		// cart.remove(5);						// index out of bounds error
		
		for(int i = 0; i < cart.size(); i++) {
			System.out.println("index is " + i + " element is " + cart.get(i));
		}
		
		for(String item : cart) {
			System.out.println("element is " + item);
		}
		
		cart.forEach(item -> System.out.println(item));
		
		
		
		List<Integer> numbers = new java.util.ArrayList<Integer>();
		numbers.add(97);
		numbers.add(51);
		System.out.println(numbers);
		
		
		
		List<Employee> emp1 = new java.util.ArrayList<Employee>();
		emp1.add(new Employee("anurag", "patna", 32));
		emp1.add(new Employee("amit", "mumbai", 35));
		System.out.println(emp1);
		
		List<Employee> emp2 = Arrays.asList(
				new Employee("anurag", "patna", 32),
			    new Employee("amit", "mumbai", 35)
		);
		System.out.println(emp2);
		
		
		
		List<Object> obj = new ArrayList<Object>();
		obj.add("hello");
		obj.add(1993);
		obj.add("world");
		obj.addFirst("first");
		obj.addLast("last");
		System.out.println(obj);
	}
}
