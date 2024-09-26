/*
 * 
 * LinkedList : (Doubly LinkedList DS)
 * implements List and Deque interface
 * can store both homogeneous(Similar) and heterogeneous type of data
 * add() is used to add data at rear end into Collection and it will store data as Object
 * duplicate are allowed
 * order of insertion of data is maintained/preserved
 * inserting index value is efficient in linkedlist bcos it follows DoublyLinkedList DS
 * indexed based accessing or insertion of data is allowed
 * size can grow or shrink
 * suitable to perform insertion operation at any given index
 * 
 */

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class LinkedListEx1 {
	LinkedListEx1(){
		/*
		 * 
		 * we can use parent reference but we can't use specialized methods
		 * 
		 */
		List<Object> linkedList1 = new LinkedList<Object>();
		
		linkedList1.add(10);
		linkedList1.add(20);
		
		System.out.println(linkedList1);
		
		System.out.println("******");
		
		Deque<Object> linkedList2 = new LinkedList<Object>();
		
		linkedList2.add(10);
		linkedList2.add(20);
		System.out.println(linkedList2);	
	}
}

class LinkedListEx2 {
	LinkedListEx2(){
		/*
		 * 
		 * inserting index value is efficient in linkedlist bcos it follows DoublyLinkedList DS
		 * bcos here no shifting happens, a new node created and added to the rear
		 * 
		 */
		LinkedList<Object> linkedList = new LinkedList<Object>();
		
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(0, 5);
		linkedList.addFirst(3);
		linkedList.addLast(23);
		
		System.out.println(linkedList);
	}
}

class LinkedListEx3 {
	LinkedListEx3(){
		/*
		 * 
		 * example of few in-build methods of LinkedList.
		 * 
		 * difference between peekFirst and pollFirst & peekLast and pollLast
		 * 
		 * add and offer does the same but in case of add, object will be added for sure
		 * but in case of offer, it is not 100% sure like object will be added
		 * 
		 */
		LinkedList<Object> linkedList = new LinkedList<Object>();
		
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		
		System.out.println(linkedList);		// [10, 20, 30, 40, 50]
		
		System.out.println(linkedList.peekFirst());	// 10
		System.out.println(linkedList);				// [10, 20, 30, 40, 50]
		
		System.out.println(linkedList.pollFirst());	// 10
		System.out.println(linkedList);				// [20, 30, 40, 50]
		
		linkedList.add(60);
		System.out.println(linkedList);				// [20, 30, 40, 50, 60]
		
		linkedList.offer(70);
		System.out.println(linkedList);				// [20, 30, 40, 50, 60, 70]	
	}
}

class LinkedListEx4{
	LinkedListEx4(){
		/*
		 * 
		 * example of few in-build methods of LinkedList.
		 * 
		 */
		LinkedList<Integer> linkedList =new LinkedList<>();
		
		linkedList.add(100);
		linkedList.add(20);
		linkedList.add(300);
		linkedList.add(45);
		
		System.out.println(linkedList);
		
		Collections.sort(linkedList);
		System.out.println("Sorted data : ");
		System.out.println(linkedList);
		
		System.out.println("Shuffld data : ");
		Collections.shuffle(linkedList);
		System.out.println(linkedList);
		
		int freq = Collections.frequency(linkedList, 20);
		System.out.println(freq);
	
		Collections.rotate(linkedList, 1);
		System.out.println("After rotating ");
		System.out.println(linkedList);			// [20, 300, 100, 45]
	}
}

public class P08LinkedList {
	public static void main(String[] args) {
		//new LinkedListEx1();
		
		//new LinkedListEx2();
		
		//new LinkedListEx3();
		
		//new LinkedListEx4();
	}
}
