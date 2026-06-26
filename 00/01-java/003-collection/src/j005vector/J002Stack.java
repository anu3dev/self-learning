package j005vector;

import java.util.LinkedList;

/**
 * Stack is being extended to Vector -> LIFO structure built on Vector (legacy)
 */

import java.util.Stack;

public class J002Stack {
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack<Integer>();
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		System.out.println(stack1); // [10, 20, 30]
		stack1.pop();
		System.out.println(stack1); // [10, 20]
		
		
		
		LinkedList<Integer> stack2 = new LinkedList<Integer>();
		stack2.push(10);
		stack2.push(20);
		stack2.push(30);
		System.out.println(stack2); // [30, 20, 10] -> just insert values in front means order is reverse but does the same
		stack2.pop();
		System.out.println(stack2); // [20, 10]
	}
}
