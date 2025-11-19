### collection

####
<details>
<summary> 🟩 collection </summary>

- The Java Collection Framework (JCF) is a unified architecture for storing, retrieving, and manipulating groups of data. It provides:
    - Interfaces (Abstract Data Types)
        - Collection – Root interface for most collections (except Map).
        - List – Ordered, index-based, allows duplicates (ArrayList, LinkedList).
        - Set – No duplicates (HashSet, LinkedHashSet, TreeSet).
        - Queue – Follows FIFO or priority-based ordering (PriorityQueue, ArrayDeque).
        - Deque – Double-ended queue (ArrayDeque, LinkedList).
        - Map – Key–value pairs, no duplicate keys (HashMap, TreeMap, LinkedHashMap).

    - Classes (Concrete Implementations)
        - ArrayList → dynamic array, fast random access.
        - LinkedList → doubly linked list, good at insertions/deletions.
        - HashSet → hash table–based set, no duplicates, no order guarantee.
        - LinkedHashSet → maintains insertion order.
        - TreeSet → sorted set (uses Red-Black Tree).
        - HashMap → hash table–based key-value map.
        - LinkedHashMap → maintains insertion order.
        - TreeMap → sorted map.

    - Algorithms (Utility Methods)
        - Collections.sort() – sorting lists
        - Collections.reverse() – reversing order
        - Collections.shuffle() – random order
        - Collections.min()/max() – finding extremes
        - Collections.binarySearch() – fast searches on sorted lists
        - Collections.unmodifiableList() – make collection read-only
        - Collections.synchronizedList() – thread-safe wrapper

- Difference between Collection and Collections?
    - Collection → interface
    - Collections → utility class

- Difference between List, Set, and Map?
    - List → ordered, duplicates allowed
    - Set → no duplicates
    - Map → key-value pairs

- Why HashMap is faster?
    - Uses hashing → average O(1) for get/put.

- When to use ArrayList vs LinkedList?
    - ArrayList → fast lookup
    - LinkedList → fast insertion/deletion

- Java Collection Framework Hierarchy
    - **Iterable**
        - **Collection**
            - **List**
                - ArrayList  
                - LinkedList  
                - Vector  
                    - Stack (legacy)
            - **Queue**
                - PriorityQueue
                - **Deque**
                    - ArrayDeque
                    - LinkedList
            - **Set**
                - HashSet
                    - LinkedHashSet
                - SortedSet
                    - TreeSet
    - **Map** (separate hierarchy)
        - HashMap  
            - LinkedHashMap  
        - SortedMap  
            - TreeMap

- ITERABLE INTERFACE
    - The root interface for all collection types (except Map).
    - Defines the ability to iterate through elements using an Iterator.

    - COLLECTION INTERFACE
        - Extends Iterable
        - Base for all collection types except Map
        - Defines core methods like add(), remove(), size(), contains()

        ```java
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers); // [10, 20, 30]
        numbers.remove(Integer.valueOf(10));;
        System.out.println(numbers); // [20, 30]
        ```

        - LIST INTERFACE (Ordered, allows duplicates)
            - Elements are indexed (0-based)
            - Maintains insertion order
            - Allows duplicate elements

                - ArrayList -> best for fast access, slower insert/delete

                ```java
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(10);
                arrayList.add(20);
                arrayList.add(30);
                System.out.println(arrayList); // [10, 20, 30]
                arrayList.remove(0);
                System.out.println(arrayList); // [20, 30]
                ```

                - LinkedList -> best for fast insert/delete, slower access

                ```java
                List<Integer> linkedList = new LinkedList<>();
                linkedList.add(10);
                linkedList.add(20);
                linkedList.add(30);
                System.out.println(linkedList); // [10, 20, 30]
                linkedList.remove(0);
                System.out.println(linkedList); // [20, 30]
                ```

                - Vector -> like ArrayList but thread-safe & legacy

                ```java
                List<Integer> vector = new Vector<>();
                vector.add(10);
                vector.add(20);
                vector.add(30);
                System.out.println(vector); // [10, 20, 30]
                vector.remove(0);
                System.out.println(vector); // [20, 30]
                ```

                    - Stack -> LIFO structure built on Vector (legacy)

                    ```java
                    Stack<Integer> stack = new Stack<>();
                    stack.push(10);
                    stack.push(20);
                    stack.push(30);
                    System.out.println(stack); // [10, 20, 30]
                    stack.pop();
                    System.out.println(stack); // [10, 20]
                ```

        - QUEUE INTERFACE (FIFO)
            - Used for holding elements prior to processing
            - Typically FIFO (First In, First Out)
            - Defined in java.util

                - PriorityQueue

                ```java
                Queue<Integer> priorityQueue = new PriorityQueue<>();
                priorityQueue.offer(10);
                priorityQueue.offer(20);
                priorityQueue.offer(30);
                System.out.println(priorityQueue); // [10, 20, 30]
                priorityQueue.poll();
                System.out.println(priorityQueue); // [20, 30]
                ```

                - Deque -> Deque extends Queue -> Queue extends Collection -> Collection extends Iterable

                    - ArrayDeque

                    ```java
                    Deque<Integer> arrayDeque = new ArrayDeque<>();
                    arrayDeque.add(10);
                    arrayDeque.add(20);
                    arrayDeque.add(30);
                    arrayDeque.add(40);
                    System.out.println(arrayDeque); // [10, 20, 30, 40]
                    arrayDeque.removeFirst();
                    arrayDeque.removeLast();
                    System.out.println(arrayDeque); // [20, 30]
                    arrayDeque.offer(23);
                    System.out.println(arrayDeque); // [20, 30, 23]
                    arrayDeque.poll();
                    System.out.println(arrayDeque); // [30, 23]
                    ```

                    - LinkedList

                    ```java
                    Deque<Integer> linkedList = new LinkedList<>();
                    linkedList.add(10);
                    linkedList.add(20);
                    linkedList.add(30);
                    linkedList.add(40);
                    System.out.println(linkedList); // [10, 20, 30, 40]
                    linkedList.removeFirst();
                    linkedList.removeLast();
                    System.out.println(linkedList); // [20, 30]
                    linkedList.offer(23);
                    System.out.println(linkedList); // [20, 30, 23]
                    linkedList.poll();
                    System.out.println(linkedList); // [30, 23]
                    ```

        - SET INTERFACE (Unique elements, no duplicates)
            - Does not allow duplicate elements.
            - May or may not maintain order.

            - HashSet -> order not guaranteed

            ```java
            Set<Integer> hashSet = new HashSet<>();
            hashSet.add(10);
            hashSet.add(20);
            hashSet.add(30);
            hashSet.add(30); // will be ignored
            System.out.println(hashSet); // [20, 10, 30]
            hashSet.remove(10);
            System.out.println(hashSet); // [20, 30]
            ```
            
                - LinkedHashSet Example (maintains insertion order)
</details>