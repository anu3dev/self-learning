package j012hashMap;

import java.util.HashMap;
import java.util.Map;

public class J001HashMap {
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(5, "30");
		hashMap.put(1, "10");
		hashMap.put(2, "20");
		hashMap.put(3, "30");
		System.out.println(hashMap); // {1=10, 2=20, 3=30, 5=30}
		hashMap.remove(1);
		System.out.println(hashMap); // {2=20, 3=30, 5=30}
	}
}
