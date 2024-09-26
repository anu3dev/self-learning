/*
 * 
 * Example of Map are HashMap, HashTable, LinkedHashMap, TreeMap, WeakHashMap etc.
 * For every type of data in Map, there will be associated unique key and value.
 * We can store data in form of key and value pair and it is together called as entry.
 * 
 */

import java.util.HashMap;

class HashMapAnimal{
	int age;
	String name;
}

/*
 * 
 * in case of HashMap, we can keep integer, string, object, null etc. as key.
 * 
 */

class HashMapEx1 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMapEx1(){
		HashMap hashMap = new HashMap();
		
		hashMap.put(2, "rag");
		hashMap.put(1, "anu");
		hashMap.put(4, "ish");
		hashMap.put(3, "nit");
		
		hashMap.put("hey", "ram");	
		
		hashMap.put("bye", 7);

		HashMapAnimal a = new HashMapAnimal();
		hashMap.put(a, "laila");

		hashMap.put(null, "po");
		
		System.out.println(hashMap);
		// {null=po, 1=anu, 2=rag, 3=nit, 4=ish, HashMapAnimal@75a1cd57=laila, hey=ram, bye=7}
	}
}

public class P17HashMap {
	public static void main(String[] args) {
		new HashMapEx1();
	}
}
