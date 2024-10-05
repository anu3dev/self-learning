/*
 * 
 * TreeSet : (BST DS) or binary search tree
 * implements SortedSet interface sub of Set interface
 * It will store data in sorted ascending order ( in order traversal)
 * duplication are not allowed
 * indexed based accessing or insertion of data is not allowed
 * order of insertion of data is NOT maintained/preserved
 * 
 * if the tree we get based on data happens to be Balanced binary search tree then search operation 
 * is efficient however if the tree we get is skewed tree than like other classes below, 
 * here also it is not so efficient for search operation
 * 
 */

import java.util.TreeSet;

class TreeSetEx1 {
	public TreeSetEx1() {		
		TreeSet<Integer> treeSet1 = new TreeSet<>();
		
		treeSet1.add(100);
		treeSet1.add(50);
		treeSet1.add(150);
		treeSet1.add(25);
		treeSet1.add(75);
		treeSet1.add(125);
		treeSet1.add(175);
		
		System.out.println(treeSet1);				// [25, 50, 75, 100, 125, 150, 175]
		
		System.out.println(treeSet1.ceiling(65));	// 75
		System.out.println(treeSet1.higher(65));	// 75
		System.out.println(treeSet1.ceiling(75));	// 75		
		System.out.println(treeSet1.higher(75));	// 100
		
		System.out.println(treeSet1.floor(75));		// 75
		System.out.println(treeSet1.floor(65));		// 50
		System.out.println(treeSet1.lower(75));		// 50
		
		System.out.println(treeSet1.tailSet(50));	// 50 75 100 125  150 175
		System.out.println(treeSet1.headSet(50));	// 25
	}
}

public class P11TreeSet {
	public static void main(String[] args) {
		//new TreeSetEx1();
	}
}
