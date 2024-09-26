import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/*
 * 
 * collection is interface as well as class, caps c is interface and small c is class.
 * Iterators are used in the Collection framework to retrieve elements one by one.
 * 
 */

class CollectionEx1{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CollectionEx1() {
		HashMap hashMap = new HashMap();
		
		hashMap.put(2,  "rag");
		hashMap.put(1,  "anu");
		hashMap.put(4,  "ish");
		hashMap.put(3,  "nit");
		
		System.out.println(hashMap); // {1=anu, 2=rag, 3=nit, 4=ish}
		
		/*
		 * 
		 * printing the value using Collection
		 * 
		 */
		Collection col = hashMap.values();
		Iterator itr1 = col.iterator();
		
		while(itr1.hasNext()) {
			String str = (String) itr1.next();
			System.out.println(str.toUpperCase());
		}
		
		/*
		 * 
		 * printing the value using Set
		 * 
		 */
		Set set1 = hashMap.keySet();
		Iterator itr2 = set1.iterator();
		
		while(itr2.hasNext()) {
			Integer i = (Integer) itr2.next();
			System.out.println("Key is : "+ i);
		}
		
		/*
		 * 
		 * printing the key and value using Set
		 * 
		 */
		Set set2 = hashMap.entrySet();
		Iterator itr3 = set2.iterator();
		
		while(itr3.hasNext()) {
			Map.Entry pair = (Entry) itr3.next();
			System.out.println(pair.getKey() + " : " +pair.getValue());
		}
	}
}

public class P21Collection {
	public static void main(String[] args) {
		new CollectionEx1();
	}
}
