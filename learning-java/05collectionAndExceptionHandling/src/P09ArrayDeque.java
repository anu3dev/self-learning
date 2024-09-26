/*
 * 
 * ArrayDeque : (Double ended Queue)
 * implements Deque interface
 * can store both homogeneous(Similar) and heterogeneous type of data
 * add() is used to add data at rear end into Collection and it will store data as Object
 * duplicates are allowed
 * suitable to perform insertion operation at rear end and front end of the collection
 * order of insertion of data is maintained/preserved
 * it is suitable for inserting data from front or rear but indexing is not allowed
 * indexed based accessing or insertion of data is not allowed
 * 
 */

import java.util.ArrayDeque;

class ArrayDequeEx1{
	ArrayDequeEx1(){
		ArrayDeque<Object> arrayDeque1 = new ArrayDeque<Object>();
		
		arrayDeque1.add(10);
		arrayDeque1.add(20);
		arrayDeque1.add(30);
		arrayDeque1.add(40);
		
		System.out.println(arrayDeque1);
		
		arrayDeque1.addFirst(5);
		arrayDeque1.addLast(40);
		
		System.out.println(arrayDeque1);
	}
}

public class P09ArrayDeque {
	public static void main(String[] args) {
		//new ArrayDequeEx1();
	}
}
