import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 * 
 * An array is a fixed-length data structure, ArrayList is a variable-length data structure.
 * ArrayList can store similar as well as different data types.
 * 
 * ArrayList: (Dynamic Array DS)
 * arrayList is a class name and dynamic data structure it follows
 * implements List interface
 * can store both homogeneous(Similar) and heterogeneous type of data
 * add() is used to add data at rear end into Collection and it will store data as Object
 * indexed based accessing or insertion of data is allowed
 * order of insertion of data is maintained/preserved
 * duplicates are allowed
 * more suitable to perform insertion operation rear end(last end)
 * size can grow or shrink
 * 
 * Iterator must be used to access the data present within the Collection. 
 * Iterator Object is invoked by calling iterator method.
 * 
 */

class ArrayListEx1{
	ArrayListEx1(){
		/*
		 * 
		 * Array list of integer type
		 * 
		 */
		ArrayList<Integer> arrList1 = new ArrayList<Integer>();
		
		arrList1.add(5);
		arrList1.add(6);
		arrList1.add(2);
		
		System.out.println("normal way: " + arrList1);
		
		System.out.println();
		
		/*
		 * 
		 * enhance for loop
		 * 
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

class ArrayListEx2{
	ArrayListEx2(){
		/*
		 * 
		 * Array list of string type
		 * 
		 */
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

class ArrayListEx3{
	ArrayListEx3(){
		/*
		 * 
		 * Array list of object type
		 * 
		 */
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


class ArrayListEx4{
	ArrayListEx4(){
		/*
		 * 
		 * Array list of different type inside list
		 * 
		 */
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

class ArrayListEx5{
	ArrayListEx5(){
		/*
		 * 
		 * since ArrayList implements the list interface, we can call it using List as well.
		 * if we are creating parents reference type, then we won't able to call specialized methods
		 * 
		 */
		List<Object> arrayList = new ArrayList<Object>();
		
		arrayList.add(5);
		arrayList.add("Anurag");
		arrayList.add('n');
		arrayList.add(13.5);
		
		System.out.println(arrayList);
		
		/*
		 * 
		 * we can add new element to an existing arraylist
		 * we can insert an array to a arraylist.
		 * 
		 */
		ArrayList<Object> arrayList1 = new ArrayList<Object>();
		
		arrayList1.add(100);
		arrayList1.add(200);
		arrayList1.add(300);
		
		System.out.println(arrayList1);	
		
		arrayList1.add(400);
		System.out.println(arrayList1);
		
		arrayList.addAll(arrayList1);
		System.out.println(arrayList);
	}
}

class ArrayListEx6{
	ArrayListEx6(){
		/*
		 * 
		 * indexed based access is allowed in arraylist
		 * using indexing we can insert element but it is not efficient with time complexity
		 * bcos it shifts the position
		 * whenever we insert any new element then every element shifts the position
		 * 
		 */
		ArrayList<Object> arrayList = new ArrayList<Object>();
		
		arrayList.add(100);
		arrayList.add(200);
		arrayList.add(300);
		
		System.out.println(arrayList);	// [100, 200, 300]
		
		arrayList.add(1, 150);
		System.out.println(arrayList); // [100, 150, 200, 300]
	}
}

class ArrayListEx7{
	ArrayListEx7(){
		/*
		 * 
		 * example of few in-build methods of ArrayList.
		 * 
		 */
		ArrayList<Object> arrayList = new ArrayList<Object>();
		
		arrayList.add(100);
		arrayList.add(200);
		
		System.out.println(arrayList);
		
		arrayList.clear();
		System.out.println(arrayList);
		
		arrayList.add(250);
		arrayList.add(300);
		System.out.println(arrayList);	
		
		System.out.println(arrayList.indexOf(300));		// 1
		System.out.println(arrayList.contains(300));	 // true
		System.out.println(arrayList.size()); 			// 2
	}
}

class ArrayListEx8{
	ArrayListEx8(){	
		/*
		 * 
		 * example of few in-build methods of ArrayList.
		 * 
		 */
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(50);
		arrayList.add(40);
	   		
		for(int i=0; i<arrayList.size(); i++){
			System.out.println(arrayList.get(i));
		}
	}
}

class ArrayListEx9{
	ArrayListEx9(){	
		/*
		 * 
		 * example of few in-build methods of ArrayList.
		 * 
		 */
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(50);
		arrayList.add(40);
		
		Iterator<Integer> itr = arrayList.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}		
	}
}

class ArrayListEx10{
	ArrayListEx10(){	
		/*
		 * 
		 * example of few in-build methods of ArrayList.
		 * 
		 */
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(50);
		arrayList.add(40);
		
		ListIterator<Integer> listIterator1 = arrayList.listIterator();
		while(listIterator1.hasNext()){
			System.out.println(listIterator1.next());
		}
		
		System.out.println("##################");
		
		ListIterator<Integer> listIterator2 = arrayList.listIterator(arrayList.size());
		while(listIterator2.hasPrevious()){
			System.out.println(listIterator2.previous());
		}
	}
}

public class P07ArrayList {
	public static void main(String[] args) {
		//new ArrayListEx1();
		
		//new ArrayListEx2();
				
		//new ArrayListEx3();
				
		//new ArrayListEx4();
		
		//new ArrayListEx5();
		
		//new ArrayListEx6();
		
		//new ArrayListEx7();
		
		//new ArrayListEx8();
		
		//new ArrayListEx9();
		
		//new ArrayListEx10();
	}
}

