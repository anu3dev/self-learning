/*
 * example of Map are HashMap, Hashtable, LinkedHashMap, TreeMap, WeakHashMap etc.
 * 
 * for every type of data in Map, there will be associated unique key and value.
 * we can store data in form of key and value pair and it is together called as entry.
 * 
 * collection is interface as well as class, caps c is interface and small c is class
 */
package collectionInJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class AnimalEx1{
	int age;
	String name;
}

/*
 * in case of HashMap, we can pass an object as well as a key.
 * we can set key as null as well.
 */
class MapInJavaEx1{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJavaEx1() {
		HashMap hashMap1 = new HashMap();
		
		hashMap1.put(2,  "rag");
		hashMap1.put(1,  "anu");
		hashMap1.put(4,  "ish");
		hashMap1.put(3,  "nit");
		
		hashMap1.put("hey", "ram");
		
		hashMap1.put("bye", 7);
		
		/*
		 * we can pass an object as well as a key
		 */
		AnimalEx1 a = new AnimalEx1();
		hashMap1.put(a, "laila");
		
		/*
		 * in case of HashMap, we can set key as null as well
		 */
		hashMap1.put(null, "po");
		
		System.out.println(hashMap1);
	}
}

/*
 * in case of Hashtable, we can't set key as null
 */
class MapInJavaEx2{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJavaEx2() {
		Hashtable hashTable1 = new Hashtable();
		
		hashTable1.put(2,  "rag");
		hashTable1.put(1,  "anu");
		hashTable1.put(4,  "ish");
		hashTable1.put(3,  "nit");
		
		hashTable1.put("hey", "ram");
		
		/*
		 * in case of Hashtable, we can't set key as null
		 */
		//hashTable1.put(null, "shiv");
		
		System.out.println(hashTable1);
	}
}

/*
 * in case of LinkedHashMap, order of insertion will be maintained.
 */
class MapInJavaEx3{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJavaEx3() {
		LinkedHashMap linkedHashMap1 = new LinkedHashMap();
		
		linkedHashMap1.put(2,  "rag");
		linkedHashMap1.put(1,  "anu");
		linkedHashMap1.put(4,  "ish");
		linkedHashMap1.put(3,  "nit");
		
		linkedHashMap1.put("hey", "ram");
		
		System.out.println(linkedHashMap1);
	}
}

/*
 * in case of TreeMap, inserted data will be sorted as per key.
 * we can't set key as String value in TreeMap, it will be run time error.
 */
class MapInJavaEx4{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJavaEx4() {
		TreeMap treeMap1 = new TreeMap();
		
		treeMap1.put(2,  "rag");
		treeMap1.put(1,  "anu");
		treeMap1.put(4,  "ish");
		treeMap1.put(3,  "nit");
		
		/*
		 * we can't set key as String value in TreeMap, it will be run time error.
		 */
		//treeMap1.put("p",  "nit");
		//treeMap1.put("a",  "nit");
		
		System.out.println(treeMap1);
	}
}

/*
 * collection is interface as well as class, caps c is interface and small c is class
 */
class MapInJavaEx5{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJavaEx5() {
		HashMap hashMap1 = new HashMap();
		
		hashMap1.put(2,  "rag");
		hashMap1.put(1,  "anu");
		hashMap1.put(4,  "ish");
		hashMap1.put(3,  "nit");
		
		System.out.println(hashMap1);
		
		/*
		 * printing the entry value
		 */
		Collection col = hashMap1.values();
		Iterator itr1 = col.iterator();
		
		while(itr1.hasNext()) {
			String str1=(String) itr1.next();
			System.out.println(str1.toUpperCase());
		}
		
		Set set = hashMap1.keySet();
		Iterator itr2 = set.iterator();
		
		while(itr2.hasNext()) {
			Integer i=(Integer) itr2.next();
			System.out.println("Key is : "+ i);
		}
		
		Set set1 = hashMap1.entrySet();
		Iterator itr3 = set1.iterator();
		
		while(itr3.hasNext()) {
			Map.Entry pair=(Entry) itr3.next();
			System.out.println(pair.getKey() + " : " +pair.getValue());
		}
	}
}

class MapInJavaEx6{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJavaEx6() {
		ArrayList list=new ArrayList();
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(50);
		
		//System.out.println(list);
		
		List list1 = Arrays.asList(10,20,30,40);
		
		for(Object obj:list1) {
			System.out.println(obj);
		}
		list1.forEach(n->System.out.println(n));
	}
}

public class MapInJava {
	public static void main(String[] args) {
		//new MapInJavaEx1();
		
		System.out.println("***************");
		
		//new MapInJavaEx2();

		System.out.println("***************");
		
		//new MapInJavaEx3();

		System.out.println("***************");
		
		//new MapInJavaEx4();

		System.out.println("***************");
		
		//new MapInJavaEx5();

		System.out.println("***************");
		
		new MapInJavaEx6();

		System.out.println("***************");
	}
}
