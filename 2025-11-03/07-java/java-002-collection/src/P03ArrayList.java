/*
 * ===========================  ARRAYLIST IN JAVA  ===========================
 *
 * 1️⃣  Definition:
 *  • An **Array** in Java is a fixed-length data structure.
 *    Once its size is declared, it cannot grow or shrink.
 *  • An **ArrayList**, on the other hand, is a **dynamic array** —
 *    it can automatically resize itself as elements are added or removed.
 *
 * ---------------------------------------------------------------------------
 * 2️⃣  Key Characteristics of ArrayList:
 *  • `ArrayList` is a **class** in `java.util` package.
 *  • It implements the **List** interface and uses a **dynamic array**
 *    as its underlying data structure.
 *  • Can store **homogeneous** (same type) or **heterogeneous**
 *    (different types, when using raw type) elements.
 *
 * ---------------------------------------------------------------------------
 * 3️⃣  Important Features:
 *  • **Implements:** `List`, `RandomAccess`, `Cloneable`, `Serializable`
 *  • **Type of Structure:** Dynamic array (resizable)
 *  • **Insertion Order:** Maintained (elements remain in the order they were added)
 *  • **Duplicates:** Allowed
 *  • **Indexing:** Elements can be accessed or modified using an index (0-based)
 *  • **Default Capacity:** 10 (increases by 50% when exceeded in modern JDK versions)
 *  • **Growth Behavior:** Automatically grows or shrinks based on operations
 *  • **Null Values:** Allowed
 *  • **Thread Safety:** Not synchronized (use `Collections.synchronizedList()` or 
 *  `CopyOnWriteArrayList` for thread safety)
 *
 * ---------------------------------------------------------------------------
 * 4️⃣  Commonly Used Methods:
 *  • `add(E e)`              → Add element at the end
 *  • `add(int index, E e)`   → Insert element at a specific index
 *  • `get(int index)`        → Retrieve element at a given index
 *  • `set(int index, E e)`   → Replace element at a specific index
 *  • `remove(int index)`     → Remove element at a specific index
 *  • `size()`                → Returns the number of elements
 *  • `clear()`               → Removes all elements
 *  • `isEmpty()`             → Checks if the list is empty
 *  • `contains(Object o)`    → Checks if an element exists in the list
 *
 * ---------------------------------------------------------------------------
 * 5️⃣  Traversing an ArrayList:
 *  • ArrayList supports multiple traversal techniques:
 *       🔸 Using **for loop** (index-based)
 *       🔸 Using **enhanced for-each loop**
 *       🔸 Using **Iterator** (preferred for Collections)
 *       🔸 Using **ListIterator** (can traverse both directions)
 *       🔸 Using **forEach()** with lambda expressions (Java 8+)
 *
 *  Example:
 *      ArrayList<String> list = new ArrayList<>();
 *      list.add("Java");
 *      list.add("Spring");
 *      list.add("Hibernate");
 *
 *      Iterator<String> itr = list.iterator();
 *      while (itr.hasNext()) {
 *          System.out.println(itr.next());
 *      }
 *
 * ---------------------------------------------------------------------------
 * 6️⃣  Performance Notes:
 *  • Insertion at **end** → Fast (amortized O(1))
 *  • Insertion or removal **in middle** → Slower (O(n)) due to shifting elements
 *  • Access by index → Very fast (O(1)) since it’s array-backed
 *  • Searching → O(n)
 *
 * ---------------------------------------------------------------------------
 * 7️⃣  When to Use ArrayList:
 *  • When data needs frequent access (read operations).
 *  • When insertion/removal mostly happens at the **end**.
 *  • When dynamic resizing is required.
 *  • When order of insertion must be preserved.
 *
 * ---------------------------------------------------------------------------
 * 8️⃣  Comparison: Array vs ArrayList
 *  | Feature              | Array                 | ArrayList                |
 *  |----------------------|-----------------------|---------------------------|
 *  | Size                 | Fixed                 | Dynamic (Resizable)       |
 *  | Data Type            | Homogeneous only      | Can be homogeneous or heterogeneous |
 *  | Memory Location       | Heap                  | Heap                     |
 *  | Duplicates            | Allowed               | Allowed                  |
 *  | Thread Safety         | Not synchronized      | Not synchronized         |
 *  | Performance           | Faster (no overhead)  | Slight overhead (resize) |
 *
 * ---------------------------------------------------------------------------
 * ✅  Summary:
 *  • ArrayList is a **dynamic array-based data structure**.
 *  • Maintains insertion order, allows duplicates, supports random access.
 *  • More suitable for **retrieval and appending operations**.
 *  • Must use **Iterator** or **enhanced for loop** for safe traversal.
 *
 * =========================================================================== 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P03ArrayList {
	static class P03ArrayListEx01{
		public P03ArrayListEx01() {
			List<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(12, 13, 25));
			System.out.println(arrayList1);
			
			
			
			System.out.println();
			List<Integer> arrayList2 = new ArrayList<Integer>();
			arrayList2.add(25);
			arrayList2.add(13);
			arrayList2.remove(1);
			arrayList2.add(41);
			for(int item : arrayList2) {
				System.out.print(item + " ");
			}
			
			
			
			System.out.println("\n");
			List<String> arrayList3 = new ArrayList<String>();
			arrayList3.add("anurag");
			arrayList3.add("nitish");
			arrayList3.forEach(n -> System.out.print(n + " "));
			
			
			
			System.out.println("\n");
			List<Object> arrayList4 = new ArrayList<Object>();
			arrayList4.add("anurag");
			arrayList4.add(23);
			arrayList4.forEach(n -> System.out.print(n + " "));
		}
	}
	
	public static void main(String[] args) {
		new P03ArrayListEx01();
	}
}
