/*
 * ======================  JAVA COLLECTION FRAMEWORK HIERARCHY  ======================
 *
 * The Java Collection Framework provides interfaces and classes 
 * for storing, managing, and manipulating groups of data efficiently.
 *
 * -------------------------------------------------------------------------------
 * 🔸 MAIN INTERFACES (java.util)
 * 
 *  Iterable  ← (Root interface for all collection classes)
 *        ↓
 *     Collection
 *        ↓──────────────┬────────────────────────────┬───────────────────────────┐
 *                     List                        Queue                       Set
 *
 * -------------------------------------------------------------------------------
 * 🔹 1️⃣  LIST INTERFACE  (Ordered, Index-based, Allows Duplicates)
 * 
 *  • Implementations:
 *        List → ArrayList
 *        List + Deque → LinkedList   (implements both List and Deque)
 *        List → Vector → Stack       (legacy classes)
 *
 *  • Characteristics:
 *        - Maintains insertion order.
 *        - Allows duplicate elements.
 *        - Provides index-based access and modification.
 *        - Best for ordered collections that need random access.
 *
 * -------------------------------------------------------------------------------
 * 🔹 2️⃣  QUEUE INTERFACE  (FIFO order – First In, First Out)
 * 
 *  • Subinterface: Deque (Double Ended Queue)
 * 
 *  • Implementations:
 *        Queue → PriorityQueue         (ordered by natural/comparator order)
 *        Queue → Deque → ArrayDeque    (resizable array-based Deque)
 *        List + Deque → LinkedList     (can act as both List and Queue)
 *
 *  • Characteristics:
 *        - Typically follows FIFO (First-In-First-Out) principle.
 *        - PriorityQueue orders elements by priority instead of insertion order.
 *        - ArrayDeque supports both FIFO (queue) and LIFO (stack) operations.
 *
 * -------------------------------------------------------------------------------
 * 🔹 3️⃣  SET INTERFACE  (Unordered, Unique Elements)
 * 
 *  • Subinterface: SortedSet (extends Set, provides ordering)
 *
 *  • Implementations:
 *        Set → HashSet → LinkedHashSet     (LinkedHashSet preserves insertion order)
 *        Set → SortedSet → TreeSet         (TreeSet stores elements in sorted order)
 *
 *  • Characteristics:
 *        - Does not allow duplicate elements.
 *        - HashSet is unordered (fast lookup via hashing).
 *        - LinkedHashSet maintains insertion order.
 *        - TreeSet maintains elements in natural or custom sorted order.
 *
 * -------------------------------------------------------------------------------
 * 🔹 4️⃣  MAP INTERFACE  (Key–Value pairs, Unique Keys)
 * 
 *  • Note: Map is **not** part of the Collection interface hierarchy, 
 *          but it is part of the Collection Framework.
 *
 *  • Implementations:
 *        Map → HashMap → LinkedHashMap
 *        Map → SortedMap → TreeMap
 *
 *  • Characteristics:
 *        - Keys are unique, values can be duplicated.
 *        - HashMap is unordered.
 *        - LinkedHashMap preserves insertion order.
 *        - TreeMap sorts entries based on keys (natural or comparator order).
 *
 * -------------------------------------------------------------------------------
 * ✅  SUMMARY TABLE
 * 
 * | Category | Interface | Common Implementations              | Order / Sorting Behavior                | Allows Duplicates | Thread Safe (default) |
 * |-----------|------------|------------------------------------|----------------------------------------|-------------------|-----------------------|
 * | List      | List       | ArrayList, LinkedList, CopyOnWriteArrayList | Maintains insertion order             | Yes               | No                    |
 * | Queue     | Queue      | LinkedList, ArrayDeque, PriorityQueue | FIFO (LinkedList/ArrayDeque), priority order (PriorityQueue) | Yes | No |
 * | Deque     | Deque      | LinkedList, ArrayDeque             | Maintains insertion order (both ends)  | Yes               | No                    |
 * | Set       | Set        | HashSet, LinkedHashSet, TreeSet    | HashSet: unordered; LinkedHashSet: insertion; TreeSet: sorted | No | No |
 * | Map       | Map        | HashMap, LinkedHashMap, TreeMap    | HashMap: unordered; LinkedHashMap: insertion; TreeMap: sorted | Keys unique | No |
 *
 *  (*Order behavior depends on implementation — e.g., LinkedHashMap preserves insertion order, TreeMap sorts.)
 *
 * -------------------------------------------------------------------------------
 * ✅  QUICK NOTES:
 *  • List → Best for ordered, index-based access.
 *  • Queue → Best for FIFO or priority-based processing.
 *  • Deque → Best for double-ended operations (stack + queue).
 *  • Set → Best for unique element storage.
 *  • Map → Best for key–value lookups.
 *
 * -------------------------------------------------------------------------------
 * ✅  THREAD-SAFE VARIANTS (from java.util.concurrent):
 *  • List → CopyOnWriteArrayList
 *  • Set → CopyOnWriteArraySet, ConcurrentSkipListSet
 *  • Map → ConcurrentHashMap, ConcurrentSkipListMap
 *  • Queue → ConcurrentLinkedQueue, ArrayBlockingQueue, LinkedBlockingQueue
 *
 * =============================================================================== 
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Array:-");
        
        int[] array1 = new int[2];
        array1[0] = 56;
        array1[1] = 73;
        System.out.println(Arrays.toString(array1));
        
        String[] array2 = new String[2];
        array2[0] = "aarnaa";
        array2[1] = "aarvee";
        for(int i = 0; i < array2.length; i++) {
        	System.out.print(array2[i] + " ");
        }
        
        System.out.println();
        int[] array3 = {15, 12, 18};
        for(int item : array3) {
        	System.out.print(item + " ");
        }
        
        
        
        System.out.println("\n\nArrayList:-");
        
        List<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(37);
        arrayList1.add(19);
        System.out.println(arrayList1);
        
        List<String> arrayList2 = new ArrayList<String>(Arrays.asList("anurag", "nitish", "kumar"));
        arrayList2.remove(2);
        for(String item : arrayList2) {
        	System.out.print(item + " ");
        }
        
        
        
        System.out.println("\n\nLinkedList:-");
        
        List<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(25);
        linkedList1.add(15);
        linkedList1.remove(1);
        System.out.println(linkedList1);
        
        Queue<Integer> linkedList2 = new LinkedList<>();
        linkedList2.add(25);
        linkedList2.add(33);
        linkedList2.add(15);
        linkedList2.remove(1); // through Queue interface -> index based deletion will not work
        System.out.println(linkedList2);
        
        Queue<Integer> linkedList3 = new LinkedList<>();
        linkedList3.offer(25);
        linkedList3.offer(33);
        linkedList3.offer(15);
        linkedList3.poll(); 
        System.out.println(linkedList3);
        
        // LinkedList means combination of List and Queue -> LIFO
        LinkedList<Integer> queue1 = new LinkedList<>();
        queue1.offer(1);
        queue1.offer(2);
        queue1.offer(3);
        queue1.offer(3);
        queue1.offer(4);
        queue1.offer(5);
        queue1.poll();
        System.out.println(queue1);
        
        // LinkedList means combination of List and Queue -> FIFO
        LinkedList<Integer> stack1 = new LinkedList<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.pop();
        System.out.println(stack1);
        
        // Queue - A linear collection that follows FIFO (First In, First Out) order.
        // Deque - A queue that allows insertion and removal from both ends — front and rear.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(25);
        queue.offer(33);
        queue.offer(15);
        queue.poll(); 
        System.out.println(queue);
        
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.offerFirst(5);
        deque.offerLast(25); // [5, 10, 20, 25]
        deque.removeFirst();
        deque.removeLast(); // [10, 20]
        System.out.println(deque);
        
        // Map







    }
}

