/*
 * 
 * HashSet  (Hashing algo)
 * implements Set interface
 * duplicates are not allowed, it will be simply ignored
 * indexed based accessing or insertion of data is not allowed
 * efficient for search operation
 * order of insertion of data is NOT maintained/preserved
 * 
 */

import java.util.HashSet;

class HashSetEx1 {
	public HashSetEx1() {		
		HashSet<Integer> hashSet1 = new HashSet<>();
		
		hashSet1.add(100);
		hashSet1.add(100);
		hashSet1.add(300);
		hashSet1.add(400);
		hashSet1.add(500);
		hashSet1.add(450);
		
		System.out.println(hashSet1);
	}
}
public class P12HashSet {
	public static void main(String[] args) {
		//new HashSetEx1();						// [400, 450, 100, 500, 300]
	}
}
