package j007arrayDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque extends Queue -> Queue extends Collection -> Collection extends Iterable
 */

public class J001ArrayDeque {
	public static void main(String[] args) {
		Deque<Integer> arrayDeque = new ArrayDeque<Integer>();
		arrayDeque.add(10);
		arrayDeque.add(20);
		arrayDeque.add(30);
		arrayDeque.add(40);
		System.out.println(arrayDeque); // [10, 20, 30, 40]
		arrayDeque.removeFirst();
		arrayDeque.removeLast();
		System.out.println(arrayDeque); // [20, 30]
		arrayDeque.offer(23);
		System.out.println(arrayDeque); // [20, 30, 23]
		arrayDeque.poll();
		System.out.println(arrayDeque); // [30, 23]
	}
}
