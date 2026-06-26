package j013linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Order not guaranteed, maintains insertion order
 */

public class J001LinkedHashMap {
	public static void main(String[] args) {
		Map<Integer, String> linkedHashMapMap = new LinkedHashMap<>();
		linkedHashMapMap.put(5, "30");
		linkedHashMapMap.put(1, "10");
		linkedHashMapMap.put(2, "20");
		linkedHashMapMap.put(3, "30");
		System.out.println(linkedHashMapMap); // {5=30, 1=10, 2=20, 3=30}
		linkedHashMapMap.remove(1);
		System.out.println(linkedHashMapMap); // {5=30, 2=20, 3=30}
	}
}
