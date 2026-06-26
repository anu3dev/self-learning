package j014treeMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * SortedMap
 */

public class J001TreeMap {
	public static void main(String[] args) {
		Map<Integer, String> treeMapMap = new TreeMap<>();
		treeMapMap.put(5, "30");
		treeMapMap.put(1, "10");
		treeMapMap.put(2, "20");
		treeMapMap.put(3, "30");
		System.out.println(treeMapMap); // {1=10, 2=20, 3=30, 5=30} (sorted)
		treeMapMap.remove(1);
		System.out.println(treeMapMap); // {2=20, 3=30, 5=30}
	}
}
