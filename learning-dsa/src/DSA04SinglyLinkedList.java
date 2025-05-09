/**
 * Singly linked list is a data structure used for storing collection 
 * of nodes and has following properties-
 * it contains sequence of nodes.
 * A node has data and reference to next node in a list.
 * first node is the head node.
 * Last node has data and points to null.
 */

public class DSA04SinglyLinkedList {
	
	private ListNode head;
	
	private static class ListNode {
		private int data;
		private ListNode next;
		
		private ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// Displaying values of singly linked list
	public void display() {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	// Calculating length of singly linked list
	public void length() {
		if(head == null) {
			System.out.println("count is zero");
			return;
		}
		int count = 0;
		ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		System.out.println("count is " + count);
	}
	
	// Inserting node at first of singly linked list
	public void insertFirst(int val) {
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
		
		display();
	}
	
	// Inserting node at end of singly linked list
	public void inserLast(int val) {
		ListNode newNode = new ListNode(val);
		if(head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while(null != current.next) {
			current = current.next;
		}
		current.next = newNode;
		
		display();
	}
	
	// Inserting node at any place
	public void insert(int position, int value) {		
		ListNode newNode = new ListNode(value);
		if(position == 1) {
			newNode.next = head;
			head = newNode;
		} else {
			ListNode previous = head;
			int count = 1;
			
			while(count < position - 1) {
				if(previous == null) {
					System.out.println("Invalid position...");
					return;
				}
				previous = previous.next;
				count++;
			}
			
			ListNode current = previous.next;
			previous.next = newNode;
			newNode.next = current;
		}
		display();
	}
	
	public void deleteFirst() {
		if(head == null) {
			System.out.println("Seems linked list has no value...");
			return;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		
		display();
	}
	
	public static void main(String[] args) {
		DSA04SinglyLinkedList sl1 = new DSA04SinglyLinkedList();
		sl1.head = new ListNode(10);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(8);
		ListNode forth = new ListNode(11);
		
		// Now we will connect them together to form a chain
		sl1.head.next = second; // 10 --> 1
		second.next = third;	// 10 --> 1 --> 8
		third.next = forth;		// 10 --> 1 --> 8 --> 11 --> null
		
		System.out.println("Displaying values of singly linked list:-");
		sl1.display();
		// 10 --> 1 --> 8 --> 11 --> null

		System.out.println("\nCalculating length of singly linked list:-");
		sl1.length();
		// count is 4
		
		System.out.println("\nInserting node at first of singly linked list:-");
		sl1.insertFirst(9);
		// 9 --> 10 --> 1 --> 8 --> 11 --> null
		
		System.out.println("\nInserting node at end of singly linked list:-");
		sl1.inserLast(13);
		// 9 --> 10 --> 1 --> 8 --> 11 --> 13 --> null
		
		System.out.println("\nInserting node at any place of singly linked list:-");
		sl1.insert(1, 3);
		// 3 --> 9 --> 10 --> 1 --> 8 --> 11 --> 13 --> null
		sl1.insert(4, 23);
		// 3 --> 9 --> 10 --> 23 --> 1 --> 8 --> 11 --> 13 --> null
		sl1.insert(9, 33);
		// 3 --> 9 --> 10 --> 23 --> 1 --> 8 --> 11 --> 13 --> 33 --> null	
		sl1.insert(19, 33);
		// Invalid position...
		
		System.out.println("\nDeleting first node of singly linked list:-");
		sl1.deleteFirst();
	}
}
