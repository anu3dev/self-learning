/*
 * 
 * PriorityQueue : (Min heap DS)
 * implements Queue interface
 * can only store homogeneous(Similar) type of data
 * add() is used to add data into Collection and it will store data as Object
 * duplicates are allowed
 * order of insertion of data is NOT maintained/preserved
 * indexed based accessing or insertion of data is not allowed
 * highest priority object would be present at the front of the collection using Min Heap DS
 * 
 */

import java.util.PriorityQueue;

class PriorityQueueEx1{
	PriorityQueueEx1(){
		PriorityQueue<Object> priorityQueue1 = new PriorityQueue<Object>();
		
		priorityQueue1.add(100);
		System.out.println(priorityQueue1);		// [100]
		
		priorityQueue1.add(50);
		System.out.println(priorityQueue1);		// [50, 100]
		
		priorityQueue1.add(150);
		System.out.println(priorityQueue1);		// [50, 100, 150]
		
		priorityQueue1.add(25);
		System.out.println(priorityQueue1);		// [25, 50, 150, 100]
		
		priorityQueue1.add(75);
		System.out.println(priorityQueue1);		// [25, 50, 150, 100, 75]	
		
		priorityQueue1.add(125);
		System.out.println(priorityQueue1);		// [25, 50, 125, 100, 75, 150]
		
		priorityQueue1.add(175);
		System.out.println(priorityQueue1);		// [25, 50, 125, 100, 75, 150, 175]
	}
}

public class P10PriorityQueue {
	public static void main(String[] args) {
		//new PriorityQueueEx1();
	}
}
