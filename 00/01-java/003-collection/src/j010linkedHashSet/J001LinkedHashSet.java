package j010linkedHashSet;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * maintains insertion order
 */

public class J001LinkedHashSet {
	public static void main(String[] args) {
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(40);
		linkedHashSet.add(10);
		linkedHashSet.add(20);
		linkedHashSet.add(30);
		System.out.println(linkedHashSet); // [40, 10, 20, 30]
		linkedHashSet.remove(10);
		System.out.println(linkedHashSet); // [40, 20, 30]
	}
}
