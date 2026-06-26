package j011sortedSet;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet -> TreeSet Example (sorted order)
 */

public class J001SortedSet {
	public static void main(String[] args) {
		SortedSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(40);
		treeSet.add(10);
		treeSet.add(55);
		treeSet.add(20);
		treeSet.add(30);
		System.out.println(treeSet); // [10, 20, 30, 40] (always sorted)
		treeSet.remove(10);
		System.out.println(treeSet); // [20, 30, 40]
	}
}
