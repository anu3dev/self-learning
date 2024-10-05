import java.util.TreeMap;
/*
 * 
 * in case of TreeMap, inserted data will be sorted as per key.
 * we can't set key as String value in TreeMap, it will be run time error.
 * 
 */

class TreeMapAnimal{
	int age;
	String name;
}


class TreeMapEx1{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TreeMapEx1() {
		TreeMap treeMap = new TreeMap();
		
		treeMap.put(2,  "rag");
		treeMap.put(1,  "anu");
		treeMap.put(4,  "ish");
		treeMap.put(3,  "nit");
		
		/*
		 * 
		 * we can't set key as String, object, null etc. value in TreeMap, it will be run time error.
		 * 
		 */
		//treeMap.put("p",  "nit");
		
		//TreeMapAnimal tree = new TreeMapAnimal();
		//treeMap.put(tree, "hello");
		
		//treeMap.put(null, "anurag");
		
		System.out.println(treeMap);
		// {1=anu, 2=rag, 3=nit, 4=ish}
	}
}

public class P20TreeMap {
	public static void main(String[] args) {
		new TreeMapEx1();
;	}
}
