import java.util.Hashtable;
/*
 * 
 * in case of HashTable, we can't set key as null, but in HashMap we can.
 * 
 */

class HashTableAnimal{
	int age;
	String name;
}

class HashTableEx1{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashTableEx1() {
		Hashtable hashTable = new Hashtable();
		
		hashTable.put(2,  "rag");
		hashTable.put(1,  "anu");
		hashTable.put(4,  "ish");
		hashTable.put(3,  "nit");
		
		hashTable.put("hey", "ram");
		
		HashTableAnimal hasTb = new HashTableAnimal();
		hashTable.put(hasTb, "hello");
		
		/*
		 * 
		 * in case of HashTable, we can't set key as null, it will be run time error.
		 * 
		 */
		//hashTable.put(null, "anurag");
		
		System.out.println(hashTable);
		// {HashTableAnimal@75a1cd57=hello, hey=ram, 4=ish, 3=nit, 2=rag, 1=anu}
	}
}

public class P18HashTable {
	public static void main(String[] args) {
		new HashTableEx1();
	}
}
