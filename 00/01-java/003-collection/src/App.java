/**
 * Collection vs Collections -> 
 * 
 * Collections is Utility class --> 
 * 	Collections.sort()
 *  Collections.reverse()
 *  Collections.shuffle()
 * 
 * Collection is Interface -->
 *  List
 *  Set
 *  Queue
 *  
 *  
 *  
 * Iterable -> The root interface for all collection types (except Map)
 * Collection -> Extends Iterable, Base for all collection types except Map, Defines core methods like add(), remove(), size(), contains()
 * 		List -> ordered, duplicates allowed, Maintains insertion order
 * 			ArrayList → fast lookup
 * 			LinkedList → fast insertion/deletion
 * 			Vector
 * 				Stack (legacy)
 * 		Queue -> Deque -> Deque extends Queue -> Queue extends Collection -> Collection extends Iterable
 * 			PriorityQueue
 * 			Deque
 * 				ArrayDeque
 * 				LinkedList
 * 		Set -> no duplicates
 * 			HashSet
 * 				LinkedHashSet
 * 			SortedSet
 * 				TreeSet
 * 
 * Map is NOT part of Collection hierarchy
 * Map (Separate Hierarchy) -> key-value pairs
 *  	HashMap
 *  		LinkedHashMap
 *  	SortedMap
 *  		TreeMap
 */

public class App {
	public static void main(String[] args) {}
}
