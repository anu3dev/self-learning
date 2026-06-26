package j008linkedList;

/**
 * Deque extends Queue -> Queue extends Collection -> Collection extends Iterable
 */

import java.util.Deque;
import java.util.LinkedList;

public class J006LinkedList {
	public static void main(String[] args) {
		Deque<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		System.out.println(linkedList); // [10, 20, 30, 40]
		linkedList.removeFirst();
		linkedList.removeLast();
		System.out.println(linkedList); // [20, 30]
		linkedList.offer(23);
		System.out.println(linkedList); // [20, 30, 23]
		linkedList.poll();
		System.out.println(linkedList); // [30, 23]
	}
}
