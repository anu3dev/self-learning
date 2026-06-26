package j003arrayList;

import java.util.ArrayList;

class QueueUsingArrayList {
	private ArrayList<Integer> queue = new ArrayList<Integer>();
	
	void enqueue(int val) {
		queue.add(val);
	}
	
	void print() {
		System.out.println(queue);
	}
	
	void dequeue() {
		if(queue.isEmpty()) {
			throw new RuntimeException("queue is empty");
		}
		queue.remove(0);
	}
}

public class J002ImplementQueue {
	public static void main(String[] args) {
		QueueUsingArrayList queueUsingArrayList = new QueueUsingArrayList();
		
		queueUsingArrayList.enqueue(10);
		queueUsingArrayList.enqueue(20);
		queueUsingArrayList.enqueue(30);
		queueUsingArrayList.print();
		
		queueUsingArrayList.dequeue();
		queueUsingArrayList.print();
		
		queueUsingArrayList.dequeue();
		queueUsingArrayList.print();
		
		queueUsingArrayList.dequeue();
		queueUsingArrayList.print();
		
		queueUsingArrayList.enqueue(40);
		queueUsingArrayList.enqueue(50);
		queueUsingArrayList.print();
	}
}
