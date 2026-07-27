import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A Process is an independent program running in memory like Chrome, VS Code, Spotify etc.
 * Inside every process there are one or more threads like Chrome loads youtube, downloads image, runs javaScript etc. 
 * A thread goes through different states like NEW --> RUNNABLE --> RUNNING --> WAITING / BLOCKED --> TERMINATED
 * 
 * Java Program Starts With One Thread i.e. Main Thread
 * 
 * Thread Lifecycle: NEW --> RUNNABLE (start()) --> RUNNING --> WAITING/BLOCKED (sleep(), wait(), lock) --> RUNNING --> TERMINATED.
 * A thread starts in NEW, becomes RUNNABLE after start(), executes in RUNNING, may temporarily enter WAITING/BLOCKED, 
 * 	resumes RUNNING, and finally reaches TERMINATED.
 * 
 * Thread: A class that represents and controls a thread of execution; extending it limits you to single inheritance 
 * and is less flexible.
 * Runnable: An interface that represents only the task to execute; it's more flexible, avoids inheritance limitations, 
 * and is the preferred approach in production.
 * 
 * A thread is an Operating System resource, not just a Java object.
 * 
 * new Thread(): Creates a new thread for every task, which is expensive, requires manual management, scales poorly, and is rarely 
 * used in production.
 * ExecutorService (Thread Pool): Creates a fixed number of threads and reuses them for multiple tasks, providing efficient 
 * resource usage, automatic management, excellent scalability, and is the standard approach in production.
 */



// oldest way to create thread
class DownloadThread extends Thread{
	@Override
	public void run() {
		System.out.println("Downloading...");
	}
}



class DownloadTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading File");
    }
}



public class App {
	public static void main(String[] args) {
		System.out.println("thread name : " + Thread.currentThread().getName());		
		// thread name : Main
		
		
		
		// Thread object created but not started.
		Thread t1 = new Thread();
		System.out.println("thread name : " + t1.getName() + " and state is : " + t1.getState());		
		// thread name : Thread-0 and state is : NEW
		
		
		
		// Thread object is Ready to execute
		t1.start();
		System.out.println("thread name : " + t1.getName() + " and state is : " + t1.getState());		
		// thread name : Thread-0 and state is : RUNNABLE
		
		
		
		DownloadThread t2 = new DownloadThread();
		System.out.println("thread name : " + t2.getName() + " and state is : " + t2.getState());		
		//thread name : Thread-1 and state is : NEW
		
		
		/**
		 * t.start() does NOT directly execute run();
		 * Instead JVM does something like start() --> Ask Operating System --> Create New Thread --> Allocate Stack Memory --> 
		 * 	Schedule Thread --> Call run()
		 * 
		 * What if I do this? t.run() instead of t.start();
		 * No new thread, Just a normal method call.
		 */
		t2.start();
		System.out.println("thread name : " + t2.getName() + " and state is : " + t2.getState());		
		// thread name : Thread-1 and state is : RUNNABLE
		
		t2.run();
		System.out.println("thread name : " + t2.getName() + " and state is : " + t2.getState());		
		// thread name : Thread-1 and state is : WAITING
		
		
		
		/**
		 * Why Extending Thread is Bad?
		 * class DownloadThread extends Thread --> and later needs to --> extends Employee --> not possible as Java supports Single Inheritance
		 * This is the biggest drawback.
		 * 
		 * Java designers realized: Thread is the worker. Work should be separate. So they introduced Runnable
		 * Runnable is an Interface
		 * 
		 * Why Runnable is better?
		 * Multiple inheritance problem solved.
		 * class DownloadTask extends Employee implements Runnable
		 */
		Runnable task = new DownloadTask();
		Thread thread = new Thread(task);
        thread.start();
        
        
        
        /**
         * Java 8 Improved Runnable
         */
        Runnable download = () -> {
            System.out.println("Downloading : " + Thread.currentThread().getName());
        };
        Runnable music = () -> {
            System.out.println("Playing Music : " + Thread.currentThread().getName());
        };

        Runnable email = () -> {
            System.out.println("Sending Email : " + Thread.currentThread().getName());
        };
        new Thread(download).start();
        new Thread(music).start();
        new Thread(email).start();
        
        
        /**
         * All may print in different order because Scheduler decides, not Java. 
         * 
         * Thread: A class that represents and controls a thread of execution; extending it limits you to single inheritance 
         * and is less flexible.
         * Runnable: An interface that represents only the task to execute; it's more flexible, avoids inheritance limitations, 
         * and is the preferred approach in production.
         * 
         * But...Even Runnable is not what modern Spring Boot applications use.
         * 
         * Suppose an e-commerce website gets: 1000 Requests / Second
         * Will Spring Boot create 1000 Threads / Second?
         * No.
         * It uses something much smarter.
         * ExecutorService
         * This is why you'll almost never see new Thread() in production Spring Boot code.
         * 
         * A thread is an Operating System resource, not just a Java object.
         * 
         * Imagine a busy restaurant. In a bad design, every new customer gets a brand-new chef. 
         * If 1,000 customers arrive, the restaurant would need 1,000 chefs—clearly impossible and very inefficient.
         * In a good design, the restaurant has a fixed team of 10 chefs. As customers arrive, 
         * an available chef takes the next order. If all chefs are busy, customers wait in a queue until a chef becomes free. 
         * The same chefs keep serving different customers throughout the day. 
         * This is exactly how a **Thread Pool** works: a fixed number of threads are created once and 
         * reused to execute many tasks efficiently.
         * 
         * Thread Pool: Instead of creating a new thread for every task (e.g., 1000 threads for 1000 tasks), 
         * create a fixed number of threads (e.g., 10) and reuse them. New tasks wait in a queue until 
         * a thread becomes available, making the application faster, more efficient, and less resource-intensive.
         * 
         * Java provides ExecutorService to manage thread pools.
         */
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Meaning Maximum 3 Threads
        executor.submit(() -> {
            System.out.println(
                Thread.currentThread().getName());		// pool-1-thread-1
        });
        
        
        
        ExecutorService executor1 = Executors.newFixedThreadPool(2);
        		
        for(int i=1; i<=5; i++){
        	int taskNo = i;
        	
        	executor1.submit(() -> {
        		System.out.println("Task " + taskNo + " " + Thread.currentThread().getName());
        		}
        	);
        }
        // Notice --> Only 2 Threads are reused.
        
        
        // why shutdown() --> / Thread pool keeps running. Application may not terminate.
        executor.shutdown();		
        
        
        /**
         * submit() vs execute()
         */
        executor1.execute(() -> {
            System.out.println("Hello");
        });
        
        Future<String> future = executor1.submit(() -> {
        	return "Done";
        });
        
        /**
         * execute() --> Returns void --> No result.
         * submit() --> Returns Future --> Can get result later.
         * 
         * Executors.newFixedThreadPool(5) --> Meaning Maximum 5 Threads, Extra tasks wait.
         * Executors.newCachedThreadPool() --> Creates threads as needed. --> Unused threads are reused.
         * Executors.newSingleThreadExecutor() --> Only One Thread --> Tasks execute one after another. useful in audit logs
         * 
         * Instead of Thread.sleep() Use ScheduledExecutorService
         * scheduler.schedule(task, 5, TimeUnit.SECONDS); --> Runs after 5 Seconds
         * 
         * new Thread(): Creates a new thread for every task, which is expensive, requires manual management, scales poorly, and is rarely 
		 * used in production.
		 * ExecutorService (Thread Pool): Creates a fixed number of threads and reuses them for multiple tasks, providing efficient 
		 * resource usage, automatic management, excellent scalability, and is the standard approach in production.
		 * 
		 * Callable & Future
		 * Runnable interface doesn't return any value so Java introduced Callable
         */
        ExecutorService executor2 = Executors.newFixedThreadPool(2);
        
        Callable<Integer> task1 = () -> {
        	return 11 * 11;
        	};

        Future<Integer> future1 = executor2.submit(task1);

        try {
        	System.out.println(future1.isDone());		// false
        	// System.out.println(future1.cancel(true));	// to cancel a thread
			System.out.println(future1.get());			// 121
			System.out.println(future1.isDone());		// true
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        executor2.shutdown();
        
        
        
        /**
         * What is a Race Condition? How do you solve it?
         * A Race Condition occurs when:
         * 		Multiple threads access the same shared data.
         * 		At least one thread modifies it.
         * 		The final result depends on which thread executes first.
         * 
         * Example:
		 * Initial Balance = ₹10,000
		 • Thread A reads ₹10,000 and withdraws ₹5,000.
		 • Before updating, CPU switches to Thread B.
		 • Thread B also reads ₹10,000 and withdraws ₹7,000.
		 • Thread A writes ₹5,000.
		 • Thread B then writes ₹3,000.
		 * Final Balance = ₹3,000 ❌
		 * Although ₹12,000 was withdrawn from an account containing only ₹10,000, the system allowed both 
		 * transactions because both threads read the same initial balance.
		 * 
		 * 
		 * How do we fix it?
		 * Java provides synchronized
		 * What does synchronized do?
		 * Think Bathroom. --> Only One Person can enter. Second person waits.
		 * Thread A --> Lock Acquired --> increment() --> Lock Released --> Thread B enters
		 * 
		 * 
		 * Why not synchronize everything?
		 * synchronized void downloadMovie(){
            download();
            playMusic();
            sendEmail();
        }
        * Everything waits --> No parallelism --> Performance drops --> Synchronize only --> Critical Section
         */
        
        
        
        /**
         * Deadlock example
         * Lock Room A --> Waiting for Room B
         * Lock Room B --> Waiting for Room A
         * 
         * Without proper locking --> Race Condition.
         * With wrong locking --> Deadlock.
         */
//        synchronized(lock1){
//            synchronized(lock2){
//            }
//        }
//        synchronized(lock2){
//            synchronized(lock1){
//            }
//        }
        
        
        
        /**
         * Can we achieve thread safety without locking?
         * Java says: Yes.
         * This is where AtomicInteger, volatile, Lock, and ConcurrentHashMap come in.
         * 
         * using synchronized --> it is correct but not fast.
         * 
         * 
         * What is Atomic? --> An operation that completes entirely or not at all, without interference from other threads.
         */
        AtomicInteger count = new AtomicInteger(0);
        count.incrementAndGet();
        count.decrementAndGet();
        count.get();
        count.set(100);
        count.addAndGet(50);
        // No synchronized but Still thread-safe.
        
        
        /*
         * When to Use volatile
         *
         * ✅ Good Use Cases (Visibility Only)
         * - Shutdown Flag
         * - Configuration Settings
         * - Status Flag
         * - Signal Variable
         * - Feature Toggle
         *
         * ❌ Bad Use Cases (Read-Modify-Write Operations)
         * - Counter
         * - Bank Balance
         * - Inventory Count
         * - Money / Wallet
         * - Total Sales
         *
         * Rule:
         * Use volatile when multiple threads only need to see the latest value
         * (visibility). Do NOT use volatile when multiple threads update the
         * same value because volatile does not provide atomicity or thread safety.
         * For updates, use synchronized, Lock, or Atomic classes.
         */
        
        
        
        /*
         * synchronized vs ReentrantLock
         *
         * synchronized
         * -----------------------------
         * - Automatic lock management
         * - Less flexible
         * - No timeout support
         * - No tryLock()
         * - Best for simple synchronization
         *
         * ReentrantLock
         * -----------------------------
         * - Manual lock/unlock management
         * - More flexible
         * - Supports timeout (tryLock(timeout))
         * - tryLock() available
         * - Preferred for advanced concurrency
         *
         * Rule:
         * Use synchronized for simple thread-safe blocks.
         * Use ReentrantLock when you need features like tryLock(),
         * timeout, interruptible locking, or multiple Conditions.
         */
        
        
        
        /*
         * HashMap vs ConcurrentHashMap
         *
         * HashMap
         * -----------------------------
         * - Not thread-safe
         * - Faster in single-threaded applications
         * - Allows one null key
         * - Allows multiple null values
         *
         * ConcurrentHashMap
         * -----------------------------
         * - Thread-safe
         * - Optimized for concurrent access by multiple threads
         * - Does NOT allow null keys
         * - Does NOT allow null values
         *
         * Rule:
         * Use HashMap when only one thread accesses the map.
         * Use ConcurrentHashMap when multiple threads read/write
         * the map concurrently without external synchronization.
         */
        
        
        
        /*
         * Future vs CompletableFuture
         *
         * Future
         * -----------------------------
         * - Blocking (get() waits for result)
         * - Cannot chain multiple tasks
         * - Limited API
         * - Legacy concurrency API
         *
         * CompletableFuture
         * -----------------------------
         * - Supports non-blocking asynchronous programming
         * - Can chain multiple tasks (thenApply, thenCompose, thenAccept, etc.)
         * - Rich and powerful API
         * - Modern concurrency API (Java 8+)
         *
         * Rule:
         * Use Future for simple asynchronous tasks.
         * Use CompletableFuture for complex async workflows,
         * task chaining, combining results, and better error handling.
         */
        
        
        
        /*
         * Interview Question:
         * Why not always use parallelStream()?
         *
         * Because parallelStream() introduces thread management overhead.
         * For small datasets or lightweight operations, this overhead can make it
         * slower than a normal stream(). It is most beneficial for large datasets
         * with CPU-intensive tasks running on multi-core processors.
         *
         * stream() vs parallelStream()
         *
         * stream()
         * -----------------------------
         * - Uses a single thread
         * - Predictable processing order
         * - Best for small datasets
         * - Lower overhead
         *
         * parallelStream()
         * -----------------------------
         * - Uses multiple threads (ForkJoinPool)
         * - Processing order may vary
         * - Best for large, CPU-intensive datasets
         * - Higher overhead due to thread management
         *
         * Rule:
         * Use stream() by default. Choose parallelStream() only after confirming
         * that the workload is large enough and benefits from parallel execution.
         */
	}
}
