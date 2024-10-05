import java.util.LinkedHashMap;

/*
 * 
 * in case of LinkedHashMap, order of insertion will be maintained.
 * 
 */

class LinkedHashMapAnimal{
	int age;
	String name;
}

class LinkedHashMapEx1{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LinkedHashMapEx1() {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		
		linkedHashMap.put(2,  "rag");
		linkedHashMap.put(1,  "anu");
		linkedHashMap.put(4,  "ish");
		linkedHashMap.put(3,  "nit");
		
		linkedHashMap.put("hey", "ram");
		
		LinkedHashMapAnimal hasTb = new LinkedHashMapAnimal();
		linkedHashMap.put(hasTb, "hello");
		
		linkedHashMap.put(null, "anurag");
		
		System.out.println(linkedHashMap);
		// {2=rag, 1=anu, 4=ish, 3=nit, hey=ram, LinkedHashMapAnimal@6f2b958e=hello, null=anurag}
	}
}

public class P19LinkedHashMap {
	public static void main(String[] args) {
		new LinkedHashMapEx1();
	}
}
