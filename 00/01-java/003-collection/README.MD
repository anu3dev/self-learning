# Java Collections Framework - Revision Notes

## 1. String vs Array vs Collection vs Map

| Feature | String | Array | Collection | Map |
|---------|---------|-------|------------|-----|
| Stores | Characters | Same type | Objects | Key-Value Pairs |
| Size | Fixed | Fixed | Dynamic | Dynamic |
| Index Based | Yes | Yes | Depends | No |
| Duplicate | Yes | Yes | Depends | Keys: No, Values: Yes |
| Package | java.lang | Java Language | java.util | java.util |

---

## 2. Java Collection Hierarchy

```
Iterable (Root Interface)
        │
   Collection
   ├───────────────┬──────────────┐
   │               │              │
  List            Set           Queue
                                   │
                                 Deque

Map (Separate hierarchy)
```

---

## 3. Iterable

- Root interface of Collection Framework.
- Allows iteration using Iterator.
- Defines:
  - iterator()

---

## 4. Collection Interface

- Extends Iterable.
- Root interface for all collections except Map.

Common Methods

```java
add()
remove()
contains()
size()
isEmpty()
clear()
```

---

# 5. List Interface

### Features

- Ordered
- Maintains insertion order
- Allows duplicates
- Allows null values
- Index based

Common Methods

```java
add()
add(index)
remove()
get()
set()
contains()
```

---

# 6. ArrayList

## Internal DS

Dynamic Array

### Features

- Dynamic size
- Fast random access
- Indexed
- Ordered
- Allows duplicates
- Allows null values

### Best Use

- Frequent reading
- Random access
- Insert/Delete mostly at end

### Complexity

| Operation | Complexity |
|-----------|------------|
| get() | O(1) |
| add(end) | O(1) Amortized |
| add(index) | O(n) |
| remove(last) | O(1) |
| remove(index) | O(n) |
| contains() | O(n) |

---

# 7. LinkedList

## Internal DS

Doubly Linked List

```
Prev <- Data -> Next
```

### Features

- Dynamic
- Ordered
- Duplicates allowed
- Null allowed
- Implements List & Deque

### Best Use

- Frequent insertion/deletion
- Queue/Deque implementation

### Complexity

| Operation | Complexity |
|-----------|------------|
| get(index) | O(n) |
| addFirst() | O(1) |
| addLast() | O(1) |
| removeFirst() | O(1) |
| removeLast() | O(1) |
| add(index) | O(n) (Traversal + Insert) |

---

# 8. Vector

- Legacy class
- Dynamic Array
- Thread-safe (Synchronized)
- Slower than ArrayList

Use only for legacy applications.

---

# 9. Stack

Legacy class (extends Vector)

LIFO (Last In First Out)

Operations

```java
push()
pop()
peek()
search()
empty()
```

Example

```
Push : 10 20 30

Top
30
20
10

Pop -> 30
```

Modern Alternative

```
ArrayDeque
```

---

# 10. Queue

FIFO (First In First Out)

Common Methods

```java
offer()
poll()
peek()
```

Difference

```
add()   -> throws Exception
offer() -> returns false

remove() -> throws Exception
poll()   -> returns null

element() -> throws Exception
peek()    -> returns null
```

---

# 11. PriorityQueue

Internal DS

Heap

Features

- Orders by priority
- Natural ordering by default
- Not insertion order
- Duplicate allowed
- Null not allowed

Complexity

Offer -> O(log n)

Poll -> O(log n)

Peek -> O(1)

---

# 12. Deque

Double Ended Queue

Supports insertion/removal from both ends.

Common Methods

```java
addFirst()
addLast()

offerFirst()
offerLast()

removeFirst()
removeLast()

pollFirst()
pollLast()

peekFirst()
peekLast()
```

Implementations

- ArrayDeque ✅
- LinkedList

---

# 13. ArrayDeque

Best replacement for

- Stack
- Queue

Advantages

- Faster than Stack
- Faster than LinkedList
- No synchronization overhead

Complexity

All operations

```
O(1)
```

---

# 14. Set Interface

Features

- No duplicates
- Not indexed
- Allows at most one null (implementation dependent)
- Search based collection

---

# 15. HashSet

Internal DS

Hash Table

Features

- No duplicates
- No ordering
- One null allowed

Complexity

```
add()
remove()
contains()

O(1)
```

---

# 16. LinkedHashSet

Features

Everything HashSet provides +

Maintains insertion order.

Complexity

```
O(1)
```

---

# 17. TreeSet

Internal DS

Red Black Tree

Features

- Sorted
- No duplicates
- No null
- Ascending order by default

Complexity

```
add()
remove()
contains()

O(log n)
```

Implements

```
NavigableSet
      ↑
SortedSet
      ↑
Set
```

---

# 18. Map

Separate hierarchy.

Stores

```
Key -> Value
```

Features

- Unique Keys
- Duplicate Values allowed

Common Methods

```java
put()
get()
remove()
containsKey()
containsValue()
keySet()
values()
entrySet()
```

---

# 19. HashMap

Internal DS

Hash Table

Features

- Unordered
- One null key
- Multiple null values

Complexity

```
put()
get()
remove()

O(1)
```

---

# 20. LinkedHashMap

Everything HashMap +

Maintains insertion order.

Complexity

```
O(1)
```

---

# 21. TreeMap

Internal DS

Red Black Tree

Features

- Sorted by Key
- Null key NOT allowed
- Multiple null values allowed

Complexity

```
put()
get()
remove()

O(log n)
```

Implements

```
NavigableMap
      ↑
SortedMap
      ↑
Map
```

---

# 22. Collection Comparison

| Collection | Order | Duplicate | Null | Thread Safe |
|------------|-------|-----------|------|-------------|
| ArrayList | Yes | Yes | Yes | No |
| LinkedList | Yes | Yes | Yes | No |
| Vector | Yes | Yes | Yes | Yes |
| Stack | LIFO | Yes | Yes | Yes |
| PriorityQueue | Priority | Yes | No | No |
| ArrayDeque | Yes | Yes | No | No |
| HashSet | No | No | One | No |
| LinkedHashSet | Insertion | No | One | No |
| TreeSet | Sorted | No | No | No |
| HashMap | No | Keys-No | 1 Key | No |
| LinkedHashMap | Insertion | Keys-No | 1 Key | No |
| TreeMap | Sorted | Keys-No | Null Key ❌ | No |

---

# 23. ArrayList vs LinkedList

| Feature | ArrayList | LinkedList |
|----------|-----------|------------|
| Internal DS | Dynamic Array | Doubly Linked List |
| Access | O(1) | O(n) |
| Insert/Delete | O(n) | O(1) after traversal |
| Memory | Less | More |
| Best Use | Read Heavy | Insert/Delete Heavy |

---

# 24. Stack vs Queue

Stack

```
LIFO

push()
pop()
peek()
```

Queue

```
FIFO

offer()
poll()
peek()
```

---

# 25. Important Interview Points

✅ Collection extends Iterable.

✅ Map is NOT part of Collection hierarchy.

✅ ArrayList uses Dynamic Array.

✅ LinkedList uses Doubly Linked List.

✅ TreeSet & TreeMap use Red-Black Tree.

✅ PriorityQueue uses Heap.

✅ HashMap uses Hash Table.

✅ ArrayDeque is preferred over Stack.

✅ LinkedList implements both List and Deque.

✅ TreeMap sorts by Key.

✅ TreeSet stores only unique sorted elements.

✅ HashSet internally uses HashMap.

---

# 26. Common Interview Questions

1. Difference between ArrayList and LinkedList.
2. Difference between HashMap and Hashtable.
3. Difference between HashMap, LinkedHashMap and TreeMap.
4. Difference between HashSet and TreeSet.
5. Difference between Queue and Deque.
6. Difference between add(), offer(), push().
7. Difference between remove(), poll(), pop().
8. Difference between peek() and element().
9. Why is HashMap faster than TreeMap?
10. Why is ArrayDeque preferred over Stack?
11. Why does ArrayList remove(0) take O(n)?
12. Why is LinkedList get(index) O(n)?
13. Why can't TreeMap have a null key?
14. How does HashMap work internally? (Buckets, hashCode(), equals())
15. Difference between fail-fast and fail-safe iterators.

---

# 27. Quick Revision (30 Seconds)

String
→ Fixed sequence of characters.

Array
→ Fixed-size indexed collection.

Collection
→ Dynamic group of objects.

List
→ Ordered + Duplicates.

ArrayList
→ Dynamic Array.

LinkedList
→ Doubly Linked List.

Vector
→ Thread-safe ArrayList.

Stack
→ LIFO.

Queue
→ FIFO.

PriorityQueue
→ Heap.

Deque
→ Double-ended Queue.

HashSet
→ Unique + No Order.

LinkedHashSet
→ Unique + Insertion Order.

TreeSet
→ Unique + Sorted.

HashMap
→ Key-Value + Fast.

LinkedHashMap
→ HashMap + Insertion Order.

TreeMap
→ Sorted Key-Value.