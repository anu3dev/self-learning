# Java Multithreading - Quick Revision Notes

## Why Multithreading?

Multithreading allows multiple tasks to execute concurrently, improving application responsiveness and CPU utilization.

### Without Multithreading

```text
Download File
      ↓
Send Email
      ↓
Generate Invoice
```

### With Multithreading

```text
Download File      Send Email      Generate Invoice
        │               │                 │
        └───────────────┼─────────────────┘
                    Executes Concurrently
```

---

# Process vs Thread

## Process

A Process is an independent program running in memory.

Examples

```text
Chrome
VS Code
Spotify
IntelliJ
```

Each process has its own:

* Memory
* Resources
* Threads

---

## Thread

A Thread is the smallest unit of execution inside a process.

One process can have multiple threads.

```text
Chrome Process

├── UI Thread
├── Network Thread
├── Rendering Thread
├── JavaScript Thread
└── Audio Thread
```

---

# Main Thread

Every Java application starts with one thread.

```java
Thread.currentThread().getName();
```

Output

```text
main
```

---

# Thread Lifecycle

```text
NEW
 ↓
RUNNABLE
 ↓
RUNNING
 ↓
WAITING / BLOCKED
 ↓
TERMINATED
```

| State           | Description                     |
| --------------- | ------------------------------- |
| NEW             | Thread object created           |
| RUNNABLE        | Ready to execute                |
| RUNNING         | CPU executing thread            |
| WAITING/BLOCKED | Waiting for lock/resource/sleep |
| TERMINATED      | Execution completed             |

---

# Creating Threads

## Method 1 - Extend Thread

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Running...");
    }
}

new MyThread().start();
```

### Drawback

Java supports only single inheritance.

---

## Method 2 - Implement Runnable (Preferred)

```java
Runnable task = () -> {

    System.out.println("Running...");

};

new Thread(task).start();
```

### Advantages

* Better design
* No inheritance limitation
* Reusable task
* Preferred in modern Java

---

# start() vs run()

## run()

```java
thread.run();
```

```text
Normal Method Call

No New Thread
```

---

## start()

```java
thread.start();
```

```text
Creates New Thread

Calls run() internally
```

Interview Rule

```text
Always use start() to create a new thread.
```

---

# Thread vs Runnable

| Thread                   | Runnable        |
| ------------------------ | --------------- |
| Class                    | Interface       |
| Represents Thread        | Represents Task |
| Single Inheritance Issue | No Issue        |
| Less Flexible            | More Flexible   |
| Rare in Production       | Preferred       |

---

# ExecutorService

## Why?

Creating threads repeatedly is expensive.

Instead of

```java
new Thread(task).start();
```

Use

```java
ExecutorService executor =
Executors.newFixedThreadPool(3);
```

Threads are reused.

---

# Thread Pool

```text
Tasks
  │
  ▼
Thread Pool

Thread-1
Thread-2
Thread-3
```

Benefits

* Better Performance
* Thread Reuse
* Resource Management
* Scalability

---

# execute() vs submit()

| execute()     | submit()            |
| ------------- | ------------------- |
| Runnable      | Runnable / Callable |
| Returns void  | Returns Future      |
| Fire & Forget | Returns Result      |

---

# shutdown()

Always call

```java
executor.shutdown();
```

Gracefully shuts down thread pool.

---

# Thread Pool Types

### Fixed Thread Pool

```java
Executors.newFixedThreadPool(5)
```

Maximum fixed number of threads.

---

### Cached Thread Pool

```java
Executors.newCachedThreadPool()
```

Creates threads as needed.

---

### Single Thread Executor

```java
Executors.newSingleThreadExecutor()
```

Executes tasks one by one.

---

### Scheduled Thread Pool

```java
ScheduledExecutorService
```

Runs tasks after delay or periodically.

---

# Runnable vs Callable

| Runnable                        | Callable                     |
| ------------------------------- | ---------------------------- |
| run()                           | call()                       |
| Returns void                    | Returns Value                |
| Cannot throw checked exceptions | Can throw checked exceptions |

Example

```java
Callable<Integer> task = () -> 100;
```

---

# Future

Represents a result that will be available later.

```java
Future<Integer> future =
executor.submit(task);

future.get();
```

Common Methods

```java
future.get();

future.isDone();

future.cancel(true);
```

---

# Race Condition

Occurs when multiple threads modify shared data simultaneously, producing inconsistent results.

Example

```java
count++;
```

Internally

```text
Read
 ↓
Increment
 ↓
Write
```

Not Atomic.

---

# synchronized

Allows only one thread to execute the critical section at a time.

```java
synchronized void increment() {

    count++;

}
```

Purpose

* Prevent Race Condition
* Ensure Thread Safety

---

# Critical Section

Code that accesses shared mutable data.

Example

```java
balance = balance - amount;

count++;
```

Needs synchronization.

---

# Deadlock

Two or more threads wait forever for each other's locks.

```text
Thread A
Lock A
Waiting for Lock B

Thread B
Lock B
Waiting for Lock A
```

Avoid inconsistent lock ordering.

---

# AtomicInteger

Thread-safe counter without using synchronized.

```java
AtomicInteger count =
new AtomicInteger(0);

count.incrementAndGet();
```

Uses

```text
CAS

Compare And Swap
```

instead of locks.

---

# synchronized vs AtomicInteger

| synchronized       | AtomicInteger              |
| ------------------ | -------------------------- |
| Uses Lock          | Lock-Free                  |
| Slower             | Faster                     |
| Complex Operations | Single Variable Operations |

---

# volatile

Ensures visibility of shared variables across threads.

```java
volatile boolean running = true;
```

Good For

* Shutdown Flag
* Status Flag
* Configuration Flag

Not Suitable For

```java
volatile int count;

count++;
```

Still not thread-safe.

---

# volatile vs synchronized

| volatile           | synchronized                  |
| ------------------ | ----------------------------- |
| Visibility         | Visibility + Mutual Exclusion |
| No Lock            | Uses Lock                     |
| No Race Protection | Prevents Race Condition       |

---

# ReentrantLock

Advanced alternative to synchronized.

```java
Lock lock = new ReentrantLock();

lock.lock();

try{

    // work

}finally{

    lock.unlock();

}
```

Advantages

* tryLock()
* Timeout Support
* More Flexible

---

# synchronized vs ReentrantLock

| synchronized   | ReentrantLock   |
| -------------- | --------------- |
| Automatic Lock | Manual Lock     |
| Less Flexible  | More Flexible   |
| No Timeout     | Timeout Support |

---

# ConcurrentHashMap

Thread-safe implementation of HashMap.

```java
ConcurrentHashMap<Integer,String> map =
new ConcurrentHashMap<>();
```

Advantages

* Thread Safe
* Better Performance
* Multiple threads can access different buckets

---

# HashMap vs ConcurrentHashMap

| HashMap              | ConcurrentHashMap   |
| -------------------- | ------------------- |
| Not Thread Safe      | Thread Safe         |
| Allows null          | Does Not Allow null |
| Faster Single Thread | Better Multi Thread |

---

# CompletableFuture

Modern asynchronous programming API.

```java
CompletableFuture.supplyAsync(() -> "Java")
        .thenApply(str -> str + " Spring")
        .thenAccept(System.out::println);
```

Advantages

* Non-blocking
* Chaining
* Async Pipelines

---

# Future vs CompletableFuture

| Future      | CompletableFuture |
| ----------- | ----------------- |
| Blocking    | Non-blocking      |
| Limited API | Rich API          |
| No Chaining | Supports Chaining |

---

# Parallel Stream

Sequential

```java
employees.stream()
```

Parallel

```java
employees.parallelStream()
```

Good For

* CPU-intensive work
* Large datasets
* Independent computations

Avoid For

* Database calls
* HTTP requests
* Small collections
* Ordered processing

---

# Production Usage

| Feature           | Typical Usage                   |
| ----------------- | ------------------------------- |
| ExecutorService   | Thread Pool Management          |
| Callable          | Background task returning value |
| Future            | Async result                    |
| CompletableFuture | Async workflows                 |
| AtomicInteger     | Counters                        |
| ConcurrentHashMap | Shared cache/session data       |
| volatile          | Shutdown flags                  |
| ReentrantLock     | Advanced locking                |
| parallelStream()  | CPU-bound parallel processing   |

---

# Interview Cheat Sheet

```text
Process
    ↓
Contains Threads

Thread
    ↓
Executes Runnable

Runnable
    ↓
Represents Task

start()
    ↓
Creates New Thread

run()
    ↓
Normal Method Call

ExecutorService
    ↓
Thread Pool

Callable
    ↓
Returns Value

Future
    ↓
Future Result

CompletableFuture
    ↓
Async Pipeline

Race Condition
    ↓
Multiple Threads Modify Shared Data

synchronized
    ↓
Protect Critical Section

AtomicInteger
    ↓
Lock-Free Counter

volatile
    ↓
Visibility

ReentrantLock
    ↓
Advanced Locking

ConcurrentHashMap
    ↓
Thread-Safe HashMap

parallelStream()
    ↓
Parallel Processing
```

---

# Most Asked Interview Questions

* Difference between Process and Thread.
* Difference between start() and run().
* Why is Runnable preferred over Thread?
* Why are raw threads bad?
* What is ExecutorService?
* execute() vs submit().
* Runnable vs Callable.
* Future vs CompletableFuture.
* What is a Race Condition?
* Why is `count++` not thread-safe?
* synchronized vs ReentrantLock.
* volatile vs synchronized.
* synchronized vs AtomicInteger.
* HashMap vs ConcurrentHashMap.
* When should you use parallelStream()?
