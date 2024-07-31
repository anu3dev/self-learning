/*
 * Collection was not part of Java initially, it was implemented as part of freelancing project
 * and later it was included in java 1.2
 * 
 * Collection - it consist of interfaces and classes, and it has class with specific data structure 
 * and algorithm to handle large data whether it is hemogenious or hetrogenious
 * 
 * there are major three type of interfaces and those are List, Queue and Set
 * 
 * List -> ArrayList
 * Queue -> Deque -> ArrayDeque
 * List + Deque -> LinkedList
 * Queue -> PriorityQueue
 * Set -> SortedSet -> TreeSet
 * Set -> HashSet -> LinkedHashSet
 */

/*
 * Iterator must be used to access the data present within the Collection. 
 * Iterator Object is invoked by calling iterator method.
 * 
 * FailFast: If we use Iterator to access the data present within collection and if we attempt 
 * for concurrent modification then it will lead to Exception and 
 * program will fail (No concurrent modification)
 * 
 * FailSafe: If we want to achive fail safe we must use classes present in java.util.concurrent package 
 * example: CopyOnWriteArrayList and so on....
 * If concurrent modification is attempted program will fail safe without leading to an Exception 
 * ( No Exception No and concurrent modification)
 */
package collectionInJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * ArrayList: (Dynamic Array DS)
 * arrayList is a class name and dynamic data structure it follows
 * implements List interface
 * can store both homogenius(Similar) and heterogenius type of data
 * add() is used to add data at rear end into Collection and it will store data as Object
 * indexed based accessing or insertion of data is allowed
 * order of insertion of data is maintained/preserved
 * duplicates are allowed
 * more suitable to perform insertion operation rear end(last end)
 * size can grow or shrink
 */
class CollectionArrayList {
	CollectionArrayList(){
		ArrayList<Object> arrayList1 = new ArrayList<Object>();
		
		arrayList1.add(5);
		arrayList1.add("Anurag");
		arrayList1.add('n');
		arrayList1.add(13.5);
		
		System.out.println(arrayList1);	
		
		System.out.println("************************************");
		
		/*
		 * since ArrayList implements the list interface, we can call it using List as well
		 * if we are creating parents refrence type, then we won't able to call specilized methods
		 */
		List<Object> arrayList2 = new ArrayList<Object>();
		
		arrayList2.add(5);
		arrayList2.add("Anurag");
		arrayList2.add('n');
		arrayList2.add(13.5);
		
		System.out.println(arrayList2);	
		
		System.out.println("************************************");
		
		/*
		 * we can add new element to an existing arraylist
		 * we can insert an array to a arraylist.
		 */
		ArrayList<Object> arrayList3 = new ArrayList<Object>();
		
		arrayList3.add(100);
		arrayList3.add(200);
		arrayList3.add(300);
		
		System.out.println(arrayList3);	
		
		arrayList3.add(400);
		System.out.println(arrayList3);
		
		arrayList3.addAll(arrayList2);
		System.out.println(arrayList3);
		
		System.out.println("************************************");
		
		/*
		 * indexed based access is allowed in arraylist
		 * using indexing we can insert element but it is not efficient with time complexity
		 * bcos it shifts the position
		 * whenever we insert any new element then every element shifts the position
		 */
		ArrayList<Object> arrayList4 = new ArrayList<Object>();
		
		arrayList4.add(100);
		arrayList4.add(200);
		arrayList4.add(300);
		
		System.out.println(arrayList4);	
		
		arrayList4.add(1, 150);
		System.out.println(arrayList4);
		
		System.out.println("************************************");
		
		/*
		 * example of few in-build methods of ArrayList.
		 */
		ArrayList<Object> arrayList5 = new ArrayList<Object>();
		
		arrayList5.add(100);
		arrayList5.add(200);
		
		System.out.println(arrayList5);
		
		arrayList5.clear();
		System.out.println(arrayList5);
		
		arrayList5.add(250);
		arrayList5.add(300);
		System.out.println(arrayList5);	
		
		System.out.println(arrayList5.indexOf(300));
		System.out.println(arrayList5.contains(300));	
		System.out.println(arrayList5.size());
		
		System.out.println("#######################");
		
		ArrayList<Integer> arrayList6 = new ArrayList<>();
		
		arrayList6.add(10);
		arrayList6.add(20);
		arrayList6.add(30);
		arrayList6.add(50);
		arrayList6.add(40);
	   		
		for(int i=0;i<arrayList6.size();i++){
			System.out.println(arrayList6.get(i));
		}
		
		System.out.println("#######################");
		
		ArrayList<Integer> arrayList7 = new ArrayList<>();
		
		arrayList7.add(10);
		arrayList7.add(20);
		arrayList7.add(30);
		arrayList7.add(50);
		arrayList7.add(40);
		
		Iterator<Integer> itr = arrayList7.iterator();
		
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		System.out.println("#######################");
		
		ArrayList<Integer> arrayList8 = new ArrayList<>();
		
		arrayList8.add(10);
		arrayList8.add(20);
		arrayList8.add(30);
		arrayList8.add(50);
		arrayList8.add(40);
		
		ListIterator<Integer> listIterator1 = arrayList8.listIterator();
		
		while(listIterator1.hasNext()){
			System.out.println(listIterator1.next());
		}
		
		System.out.println("##################");
		
		ListIterator<Integer> listIterator2 = arrayList8.listIterator(arrayList8.size());
		
		while(listIterator2.hasPrevious()){
			System.out.println(listIterator2.previous());
		}
	}
}

/*
 * LinkedList : (Doubly LinkedList DS)
 * implements List and Deque interface
 * can store both homogenius(Similar) and heterogenius type of data
 * an store both homogenius(Similar) and heterogenius type of data
 * add() is used to add data at rear end into Collection and it will store data as Object
 * dulicate are allowed
 * order of insertion of data is maintained/preserved
 * inserting index value is efficient in linkedlist bcos it follows DoublyLinkedList DS
 * indexed based accessing or insertion of data is allowed
 * size can grow or shrink
 * suitable to perform insertion operation at any given index
 */
class CollectionLinkedList{
	CollectionLinkedList(){
		
		/*
		 * we can use parent refrence but we can't use specilized methods
		 */
		List<Object> linkedList1 = new LinkedList<Object>();
		
		linkedList1.add(10);
		linkedList1.add(20);
		
		System.out.println(linkedList1);
		
		System.out.println("************************************");
		
		Deque<Object> linkedList2 = new LinkedList<Object>();
		
		linkedList2.add(10);
		linkedList2.add(20);
		System.out.println(linkedList2);
		
		System.out.println("************************************");
		
		/*
		 * inserting index value is efficient in linkedlist bcos it follows DoublyLinkedList DS
		 * bcos here no shifting happens, a new node created and added to the rear
		 */
		LinkedList<Object> linkedList3 = new LinkedList<Object>();
		
		linkedList3.add(10);
		linkedList3.add(20);
		linkedList3.add(0, 5);
		linkedList3.addFirst(3);
		linkedList3.addLast(23);
		
		System.out.println(linkedList3);
		
		System.out.println("************************************");
		
		/*
		 * example of few in-build methods of LinkedList.
		 * 
		 * difference between peekFirst and pollFirst & peekLast and pollLast
		 * 
		 * add and offer does the same but in case of add, object will be added for sure
		 * but in case of offer, it is not 100% sure like object will be added
		 */
		LinkedList<Object> linkedList4 = new LinkedList<Object>();
		
		linkedList4.add(10);
		linkedList4.add(20);
		linkedList4.add(30);
		linkedList4.add(40);
		linkedList4.add(50);
		
		System.out.println(linkedList4);		// [10, 20, 30, 40, 50]
		
		System.out.println(linkedList4.peekFirst());	// 10
		System.out.println(linkedList4);				// [10, 20, 30, 40, 50]
		System.out.println(linkedList4.pollFirst());	// 10
		System.out.println(linkedList4);				// [20, 30, 40, 50]
		linkedList4.add(60);
		System.out.println(linkedList4);				// [20, 30, 40, 50, 60]
		linkedList4.offer(70);
		System.out.println(linkedList4);				// [20, 30, 40, 50, 60, 70]
		
		System.out.println("########################");
		
		LinkedList<Integer> linkedList5 =new LinkedList<>();
		
		linkedList5.add(100);
		linkedList5.add(20);
		linkedList5.add(300);
		linkedList5.add(45);
		
		System.out.println(linkedList5);
		
		Collections.sort(linkedList5);
		System.out.println("Sorted data : ");
		System.out.println(linkedList5);
		
		System.out.println("Shuffld data : ");
		Collections.shuffle(linkedList5);
		System.out.println(linkedList5);
		
		int freq=Collections.frequency(linkedList5, 20);
		System.out.println(freq);
	
		Collections.rotate(linkedList5, 1);
		System.out.println("After rotating ");
		System.out.println(linkedList5);
	}
}

/*
 * ArrayDeque : (Double ended Queue)
 * implements Deque interface
 * can store both homogenius(Similar) and heterogenius type of data
 * add() is used to add data at rear end into Collection and it will store data as Object
 * duplicates are allowed
 * suitable to perform insertion operation at rear end and front end of the collection
 * order of insertion of data is maintained/preserved
 * it is suitable for inserting data from front or rear but indexing is not allowed
 * indexed based accessing or insertion of data is not allowed
 */
class CollectionArrayDeque{
	CollectionArrayDeque(){
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

/*
 * PriorityQueue : (Min heap DS)
 * implements Queue interface
 * can only store homogenius(Similar) type of data
 * add() is used to add data into Collection and it will store data as Object
 * duplicates are allowed
 * order of insertion of data is NOT maintained/preserved
 * indexed based accessing or insertion of data is not allowed
 * highest priority object would be present at the front of the collection using Min Heap DS
 */
class CollectionPriorityQueue{
	CollectionPriorityQueue(){
		PriorityQueue<Object> priorityQueue1 = new PriorityQueue<Object>();
		
		priorityQueue1.add(100);
		System.out.println(priorityQueue1);
		
		priorityQueue1.add(50);
		System.out.println(priorityQueue1);	
		
		priorityQueue1.add(150);
		System.out.println(priorityQueue1);	
		
		priorityQueue1.add(25);
		System.out.println(priorityQueue1);	
		
		priorityQueue1.add(75);
		System.out.println(priorityQueue1);		
		
		priorityQueue1.add(125);
		System.out.println(priorityQueue1);	
		
		priorityQueue1.add(175);
		System.out.println(priorityQueue1);
	}
}

/*
 * TreeSet : (BST DS) or binary search tree
 * implements SortedSet interface sub of Set interface
 * It will store data in sorted ascending order ( in order traversal)
 * duplication are not allowed
 * indexed based accessing or insertion of data is not allowed
 * order of insertion of data is NOT maintained/preserved
 * 
 * if the tree we get based on data happens to be Balanced binary search tree then search operation is efficient 
 * however if the tree we get is skewed tree than like other classes below, here also it is not so efficient for search operation
 */
class CollectionTreeSet {
	public CollectionTreeSet() {		
		TreeSet<Integer> treeSet1 = new TreeSet<>();
		
		treeSet1.add(100);
		treeSet1.add(50);
		treeSet1.add(150);
		treeSet1.add(25);
		treeSet1.add(75);
		treeSet1.add(125);
		treeSet1.add(175);
		
		System.out.println(treeSet1);
		
		System.out.println(treeSet1.ceiling(65));	//75
		System.out.println(treeSet1.higher(65));		//75
		System.out.println(treeSet1.ceiling(75));	//75		
		System.out.println(treeSet1.higher(75));		//100
		
		System.out.println(treeSet1.floor(75));		//75
		System.out.println(treeSet1.floor(65));		//50
		System.out.println(treeSet1.lower(75));		//50
		
		System.out.println(treeSet1.tailSet(50));	//50 75 100 125  150 175
		System.out.println(treeSet1.headSet(50));	 //25
	}
}

/*
 * HashSet  (Hashing algo)
 * implements Set interface
 * duplicates are not allowed, it will be simply ignored
 * indexed based accessing or insertion of data is not allowed
 * efficient for search operation
 * order of insertion of data is NOT maintained/preserved
 */
class CollectionHashSet {
	public CollectionHashSet() {		
		HashSet<Integer> hashSet1 = new HashSet<>();
		
		hashSet1.add(100);
		hashSet1.add(100);
		hashSet1.add(300);
		hashSet1.add(400);
		hashSet1.add(500);
		hashSet1.add(450);
		
		System.out.println(hashSet1);
	}
}

/*
 * LinkedHashSet  (Hashing algo)
 * implements HashSet interface
 * duplicates are not allowed, it will be simply ignored
 * indexed based accessing or insertion of data is not allowed
 * efficient for search operation
 * order of insertion of data is maintained/preserved
 */
class CollectionLinkedHashSet {
	public CollectionLinkedHashSet() {		
		LinkedHashSet<Integer> linkedHashSet1 = new LinkedHashSet<>();
		
		linkedHashSet1.add(100);
		linkedHashSet1.add(100);
		linkedHashSet1.add(300);
		linkedHashSet1.add(400);
		linkedHashSet1.add(500);
		linkedHashSet1.add(450);
		
		System.out.println(linkedHashSet1);
	}
}

class CollectionCopyOnWriteArrayList {
	public CollectionCopyOnWriteArrayList() {
			
		CopyOnWriteArrayList<Integer> copyOnWriteArrayList1 = new CopyOnWriteArrayList<>();
		
		copyOnWriteArrayList1.add(10);
		copyOnWriteArrayList1.add(20);
		copyOnWriteArrayList1.add(30);
		copyOnWriteArrayList1.add(50);
		copyOnWriteArrayList1.add(40);
	   
		System.out.println(copyOnWriteArrayList1);
		
		System.out.println("#####################");
		
		for(Object obj: copyOnWriteArrayList1){
			System.out.println(obj);
		}
		
		System.out.println("#####################");
		
		Iterator<Integer> itr1 = copyOnWriteArrayList1.iterator();
		
		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
	}
}

/*
 * Vector and Dictionary are legacy classes which they have again introduced after collection
 * 
 * Vector is from .9 i.e. alpha version and iterator is from 1.2
 */

class CollectionVector {
	public CollectionVector() {
		
		Vector<Integer> vec = new Vector<>();
		
		vec.add(10);
		vec.add(20);
		vec.add(30);
		vec.add(40);
		
		System.out.println(vec);
		
		System.out.println("######################");
		
		Iterator<Integer> itr = vec.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("######################");
		
		Enumeration<Integer> env = vec.elements();
		
		while(env.hasMoreElements()) {
			System.out.println(env.nextElement());
		}	
	}
}

public class CollectionInJava {
	public static void main(String[] args) {
		//new CollectionArrayList();
		
		System.out.println("1******************");
		
		//new CollectionLinkedList();
		
		System.out.println("2******************");
		
		//new CollectionArrayDeque();
		
		System.out.println("3******************");
		
		//new CollectionPriorityQueue();
		
		System.out.println("4******************");
		
		//new CollectionTreeSet();
		
		System.out.println("5******************");
		
		//new CollectionHashSet();
		
		System.out.println("6******************");
		
		//new CollectionLinkedHashSet();
		
		System.out.println("7******************");
		
		//new CollectionCopyOnWriteArrayList();
		
		System.out.println("8******************");
		
		new CollectionVector();
	}
}

