package j004linkedList;

import java.util.LinkedList;

class StackUsingLinkedList {
	private LinkedList<Integer> stack = new LinkedList<Integer>();
	
	void push(Integer val) {
		stack.push(val);
		/**
		 * add() vs offer(), both add the element at the end. like [10, 20, 30]
		 * push add each new element on the front like [30, 20, 10]
		 * since pop removes last added element first so it logically follow stack
		 * 
		 * 
		 * List → add(), remove(), get()
		 * Queue (FIFO) → offer(), poll(), peek()
		 * Stack (LIFO) → push(), pop(), peek()
		 */
	}
	
	void print() {
		System.out.println(stack);
	}
	
	void pop() {
		if(stack.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		stack.pop();
	}
}

public class J003ImplementStack {
	public static void main(String[] args) {
		StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
		
		stackUsingLinkedList.push(10);
		stackUsingLinkedList.push(20);
		stackUsingLinkedList.push(30);
		stackUsingLinkedList.print();
		
		stackUsingLinkedList.pop();
		stackUsingLinkedList.print();
		
		stackUsingLinkedList.pop();
		stackUsingLinkedList.print();
		
		stackUsingLinkedList.pop();
		stackUsingLinkedList.print();
		
		stackUsingLinkedList.push(40);
		stackUsingLinkedList.push(50);
		stackUsingLinkedList.print();
	}
}

