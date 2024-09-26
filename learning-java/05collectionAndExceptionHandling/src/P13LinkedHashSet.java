import java.util.LinkedHashSet;

/*
 * 
 * LinkedHashSet  (Hashing algo)
 * implements HashSet interface
 * duplicates are not allowed, it will be simply ignored
 * indexed based accessing or insertion of data is not allowed
 * efficient for search operation
 * order of insertion of data is maintained/preserved
 * 
 */

class LinkedHashSetEx1 {
	public LinkedHashSetEx1() {		
		LinkedHashSet<Integer> linkedHashSet1 = new LinkedHashSet<>();
		
		linkedHashSet1.add(100);
		linkedHashSet1.add(100);
		linkedHashSet1.add(300);
		linkedHashSet1.add(400);
		linkedHashSet1.add(500);
		linkedHashSet1.add(450);
		
		System.out.println(linkedHashSet1);
	}
}

public class P13LinkedHashSet {
	public static void main(String[] args) {
		//new LinkedHashSetEx1();					// [100, 300, 400, 500, 450]
	}
}
