package j004linkedList;

import java.util.LinkedList;

class QueueUsingLinkedList {
	private LinkedList<Integer> queue = new LinkedList<Integer>();
	
	void enqueue(Integer val) {
		queue.offer(val);
	}
	
	void print() {
		System.out.println(queue);
	}
	
	void dequeue() {
		if(queue.isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		queue.poll();
	}
}

public class J002ImplementQueue {
	public static void main(String[] args) {
		QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
		
		queueUsingLinkedList.enqueue(10);
		queueUsingLinkedList.enqueue(20);
		queueUsingLinkedList.enqueue(30);
		queueUsingLinkedList.print();
		
		queueUsingLinkedList.dequeue();
		queueUsingLinkedList.print();
		
		queueUsingLinkedList.dequeue();
		queueUsingLinkedList.print();
		
		queueUsingLinkedList.dequeue();
		queueUsingLinkedList.print();
		
		queueUsingLinkedList.enqueue(40);
		queueUsingLinkedList.enqueue(50);
		queueUsingLinkedList.print();
	}
}
