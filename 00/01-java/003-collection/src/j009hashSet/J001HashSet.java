package j009hashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * May or may not maintain insertion order
 */

public class J001HashSet {
	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(10);
		hashSet.add(20);
		hashSet.add(30);
		hashSet.add(30); // will be ignored
		System.out.println(hashSet); // [20, 10, 30]
		hashSet.remove(10);
		System.out.println(hashSet); // [20, 30]
	}
}
