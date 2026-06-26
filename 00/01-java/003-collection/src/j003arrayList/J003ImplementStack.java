package j003arrayList;

import java.util.ArrayList;

class StackUsingArrayList {
	private ArrayList<Integer> stack = new ArrayList<Integer>();
	
	void push(int val) {
		stack.add(val);
	}
	
	void print() {
		System.out.println(stack);
	}
	
	void pop() {
		if(stack.isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		stack.remove(stack.size() - 1);
	}
}

public class J003ImplementStack {
	public static void main(String[] args) {
		StackUsingArrayList stackUsingArrayList = new StackUsingArrayList();
		
		stackUsingArrayList.push(10);
		stackUsingArrayList.push(20);
		stackUsingArrayList.push(30);
		stackUsingArrayList.print();
		
		stackUsingArrayList.pop();
		stackUsingArrayList.print();
		
		stackUsingArrayList.pop();
		stackUsingArrayList.print();
		
		stackUsingArrayList.pop();
		stackUsingArrayList.print();
		
		stackUsingArrayList.push(40);
		stackUsingArrayList.push(50);
		stackUsingArrayList.print();
	}
}
