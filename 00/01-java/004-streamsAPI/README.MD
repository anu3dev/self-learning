# Java Streams API - Quick Revision Notes

## Why Streams?

Streams provide a declarative way to process collections.

Instead of telling Java **HOW** to process data (loops), we tell Java **WHAT** we want.

```text
Collection
     │
     ▼
Stream Pipeline
     │
filter()
map()
sorted()
collect()
     │
     ▼
Result
```

---

# Stream Lifecycle

Every Stream has three stages:

```text
Source
    ↓
Intermediate Operations
    ↓
Terminal Operation
```

### Source

```java
employees.stream()
```

### Intermediate Operations

```java
filter()

map()

sorted()

distinct()

limit()

skip()
```

### Terminal Operations

```java
collect()

forEach()

count()

reduce()

findFirst()

anyMatch()
```

Without a terminal operation, Stream does not execute (Lazy Evaluation).

---

# filter()

### Purpose

Filters elements based on a condition.

```java
employees.stream()
    .filter(emp -> emp.getDepartment().equals("IT"))
    .collect(Collectors.toList());
```

Use when:

* Searching
* Filtering records
* WHERE clause equivalent

---

# map()

### Purpose

Transforms one object into another.

```java
employees.stream()
    .map(Employee::getName)
    .collect(Collectors.toList());
```

Examples:

```text
Employee → Name

Employee → Salary

Employee → DTO
```

---

# filter() vs map()

| filter()                 | map()                         |
| ------------------------ | ----------------------------- |
| Removes unwanted data    | Transforms data               |
| Returns same object type | Returns different object type |
| WHERE                    | SELECT                        |

---

# sorted()

Sort elements.

Ascending

```java
.sorted(Comparator.comparing(Employee::getSalary))
```

Descending

```java
.sorted(Comparator.comparing(Employee::getSalary).reversed())
```

---

# distinct()

Removes duplicate values.

```java
employees.stream()
    .map(Employee::getDepartment)
    .distinct()
```

---

# limit()

Returns first N records.

```java
.limit(3)
```

Common Use:

* Top 10
* Latest 5
* Pagination

---

# skip()

Skips first N records.

```java
.skip(3)
```

Common Use:

Pagination.

---

# count()

Counts matching records.

```java
.count()
```

Returns:

```java
long
```

---

# anyMatch()

Returns true if at least one element matches.

```java
.anyMatch(emp -> emp.getSalary() > 100000)
```

---

# allMatch()

Returns true if every element matches.

```java
.allMatch(emp -> emp.getSalary() > 50000)
```

---

# noneMatch()

Returns true if no element matches.

```java
.noneMatch(emp -> emp.getSalary() < 50000)
```

---

# findFirst()

Returns first matching element.

```java
.findFirst()
.orElse(null)
```

Return Type:

```java
Optional<T>
```

---

# forEach()

Iterates through Stream.

```java
.forEach(System.out::println);
```

---

# reduce()

Reduces multiple values into a single value.

Examples:

* Sum
* Max
* Min
* Product
* String Concatenation

### Sum

```java
.reduce(0.0, Double::sum)
```

### Maximum

```java
.reduce(Double::max)
.orElse(0.0)
```

---

# collect()

Converts Stream into a desired collection.

Examples

```java
Collectors.toList()

Collectors.toSet()

Collectors.toMap()

Collectors.joining()
```

---

# Collectors.toMap()

Converts List into Map.

```java
Collectors.toMap(
Employee::getId,
Employee::getName
)
```

Result

```text
1 → Anurag

2 → Rahul
```

---

# Collectors.toSet()

Removes duplicates.

```java
Collectors.toSet()
```

---

# Collectors.joining()

Joins Strings.

```java
Collectors.joining(", ")
```

Output

```text
Anurag, Rahul, John
```

---

# Collectors.groupingBy()

Equivalent of SQL GROUP BY.

```java
Collectors.groupingBy(Employee::getDepartment)
```

Return Type

```java
Map<Key, List<Value>>
```

---

# counting()

Count records inside grouping.

```java
Collectors.counting()
```

Example

```text
IT → 3

HR → 2
```

---

# averagingDouble()

Average values.

```java
Collectors.averagingDouble(Employee::getSalary)
```

---

# summingDouble()

Total values.

```java
Collectors.summingDouble(Employee::getSalary)
```

---

# mapping()

Transforms grouped values.

```java
Collectors.mapping(
Employee::getName,
Collectors.toList()
)
```

Result

```text
IT

Anurag

John

Amit
```

---

# maxBy()

Maximum value inside each group.

```java
Collectors.maxBy(
Comparator.comparing(Employee::getSalary)
)
```

Return Type

```java
Optional<Employee>
```

---

# Stream Pipeline

Typical Production Pipeline

```java
employees.stream()

.filter(...)

.map(...)

.sorted(...)

.limit(...)

.collect(...);
```

---

# Real Production Usage

Streams are heavily used for:

* Filtering API responses
* Entity → DTO conversion
* Report generation
* Dashboard statistics
* Grouping data
* Pagination
* Sorting
* Data transformation
* Aggregation

---

# Most Used Collectors

| Collector         | Purpose                |
| ----------------- | ---------------------- |
| toList()          | Convert to List        |
| toSet()           | Remove duplicates      |
| toMap()           | Convert to Map         |
| joining()         | Join Strings           |
| groupingBy()      | SQL GROUP BY           |
| counting()        | Count                  |
| summingDouble()   | Sum                    |
| averagingDouble() | Average                |
| maxBy()           | Maximum                |
| mapping()         | Transform grouped data |

---

# Interview Cheat Sheet

```text
filter()      → Remove

map()         → Transform

sorted()      → Sort

distinct()    → Remove Duplicates

limit()       → First N Records

skip()        → Skip N Records

count()       → Count Records

findFirst()   → First Match

anyMatch()    → Any?

allMatch()    → All?

noneMatch()   → None?

reduce()      → Single Result

collect()     → Convert Stream

groupingBy()  → SQL GROUP BY

mapping()     → Transform Group

summingDouble() → Sum

averagingDouble() → Average

maxBy() → Maximum
```

---

# Common Interview Questions

* Difference between `filter()` and `map()`
* Difference between `map()` and `flatMap()` *(next topic)*
* What is Lazy Evaluation?
* Difference between Intermediate and Terminal Operations.
* Why does `findFirst()` return `Optional`?
* Difference between `Collectors.toList()` and `Stream.toList()` *(Java 16+)*
* Difference between `groupingBy()` and `partitioningBy()`
* Explain `reduce()` with a practical example.

---