package j004linkedList;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList (Doubly Linked List) - LinkedList is a dynamic, doubly linked list implementation of the List and Deque interfaces. It maintains 
 * 	insertion order, allows duplicates and null values, and is best suited for frequent insertions and deletions, while random access is slower 
 * 	than ArrayList.
 *
 * 1. LinkedList is a dynamic data structure.
 *    - Size grows and shrinks automatically.
 *
 * 2. It implements both List and Deque interfaces.
 *
 * 3. Stores data in insertion order.
 *    - Elements are retrieved in the order they were added.
 *
 * 4. Allows duplicate elements.
 *
 * 5. Allows null values.
 *
 * 6. Uses a Doubly Linked List internally.
 *    - Each node stores:
 *      Previous Node | Data | Next Node
 *
 * 7. Can store any object.
 *    - Without Generics: different data types
 *    - With Generics: one specific type (recommended)
 *
 * 8. Efficient for insertions and deletions.
 *    - Once the position (node) is reached, adding/removing is O(1).
 *
 * 9. Slow for accessing elements by index.
 *    - It must traverse from the beginning or end.
 *    - get(index) is O(n).
 *
 * 10. Best when frequent insertions or deletions are required,
 *     especially in the beginning or middle of the list.
 */

public class J001LinkedList {
	public static void main(String[] args) {
		List<String> list1 = new LinkedList<String>();
		list1.add("anurag");
		list1.add("kumar");
		System.out.println(list1);
		
		Deque<String> deque1 = new LinkedList<String>();
		deque1.add("anurag");
		deque1.add("kumar");
		System.out.println(deque1);
	}
}
