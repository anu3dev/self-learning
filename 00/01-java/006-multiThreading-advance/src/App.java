import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Why synchronized is NOT enough -> Before learning Locks, let's understand why Java introduced them.
 * Suppose we have BankAccount class as below and we need few scenarios like Try acquiring lock for only 2 seconds, Fair scheduling, Multiple Conditions etc.
 * 
 * That's why Java introduced java.util.concurrent.locks
 */
class BankAccount1 {

    private int balance = 1000;

    public synchronized void withdraw(int amount){

        if(balance >= amount){
            balance -= amount;
        }
    }
}



/**
 * What actually is a Lock? 
 * Imagine a bathroom.
 * 
 * Without lock - Chaos
 * Person A enters
 * Person B enters
 * 
 * With lock
 * Person A locks
 * Person B waits
 * Person A unlocks
 * Person B enters
 * 
 * Computer memory works exactly the same. Only one thread should modify critical data.
 */



/**
 * Problems with synchronized
 * Cannot -> tryLock(), Interrupt waiting thread, Timed waiting, Fair lock, Multiple conditions etc. 
 * 
 * Hence ReentrantLock
 */
class BankAccount2 {
	Lock lock = new ReentrantLock();
	
	public void deposit() {
		lock.lock();
		
		try {
			// critical section
		} finally {
			// Always inside finally. Otherwise... Production deadlock.
			lock.unlock();
		}
	}
}



/*
 * Why ReentrantLock instead of synchronized?
 *
 * synchronized               ReentrantLock
 * --------------------------------------------------------
 * JVM-managed                API-managed
 * Automatic unlock           Manual unlock (unlock())
 * No timeout                 tryLock(timeout)
 * No fairness                Fairness supported
 * Not interruptible          lockInterruptibly()
 * No non-blocking attempt    tryLock()
 * Single wait set            Multiple Condition objects
 * Simple & easy              Powerful & flexible
 *
 * Rule of Thumb:
 * Use synchronized for simple synchronization.
 * Use ReentrantLock when you need timeout, fairness,
 * interruptible locking, or advanced lock control.
 */



/**
 * Reentrant means what?
 */
class BankAccount3 {
	Lock lock = new ReentrantLock();

    void method1(){

        lock.lock();

        method2();

        lock.unlock();
    }

    void method2(){

        lock.lock();

        lock.unlock();
    }
}



/**
 * Fair Lock
 * 
 * Default `new ReentrantLock()` Not fair.
 * 
 * If fairness required `Lock lock=new ReentrantLock(true);`
 */



/**
 * tryLock() -> Instead of Wait forever we can do below
 */
class BankAccount4 {
	Lock lock = new ReentrantLock();

	public void method1 () {
		// Timed version `lock.tryLock(5, TimeUnit.SECONDS);`
		if(lock.tryLock()){

		    try{
		        System.out.println("Got Lock");
		    }
		    finally{
		        lock.unlock();
		    }
		}
		else{
		    System.out.println("Didn't get lock");
		}
	}
}



/**
 * lockInterruptibly()
 * 
 * Suppose thread waits 30 minutes, Boss says Cancel it.
 * 
 * Impossible using synchronized.
 * 
 * Using Lock `lock.lockInterruptibly();`
 * 
 * Waiting thread can be interrupted.
 * 
 * Huge production feature.
 */



/**
 * REAL PRODUCTION DEADLOCK
 * 
 * T1 waits forever
 * T2 waits forever
 */
class BankAccount5 {

    static final Object lock1 = new Object();

    static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            synchronized (lock1) {

                System.out.println("Thread1 locked lock1");

                sleep();

                synchronized (lock2) {

                    System.out.println("Thread1 locked lock2");

                }
            }

        });

        Thread t2 = new Thread(() -> {

            synchronized (lock2) {

                System.out.println("Thread2 locked lock2");

                sleep();

                synchronized (lock1) {

                    System.out.println("Thread2 locked lock1");

                }
            }

        });

        t1.start();

        t2.start();
    }

    static void sleep(){

        try{

            Thread.sleep(1000);

        }catch(Exception e){}
    }

}



/*
 * AtomicInteger
 * 
 * Now let's solve another classic concurrency problem. Suppose 100 threads increment a shared counter.
 * 
 * Looks harmless. Actually it's broken.
 */
class Counter1 {

    int count = 0;

    void increment(){

        count++;
    }
}



/**
 * Below is incorrect example
 */
class Counter2 {

    int count = 0;

    void increment() {
        count++;
    }

    public static void main(String[] args) throws Exception {

        Counter1 c = new Counter1();

        Runnable task = () -> {
            for(int i = 0; i < 100000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}



/**
 * Solution: AtomicInteger
 */
class Counter3 {

    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }

    public static void main(String[] args) throws Exception {

        Counter1 c = new Counter1();

        Runnable task = () -> {
            for(int i = 0; i < 100000; i++) {
                c.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}



/**
 * BlockingQueue - One of the most useful concurrent collections.
 * 
 * Imagine a restaurant:
 * 
 * The food counter acts as a queue.
 * The chef (producer) adds dishes.
 * The waiter (consumer) takes dishes.
 * If the counter is full, the chef waits.
 * If the counter is empty, the waiter waits.
 * 
 * This is exactly what BlockingQueue does.
 */
class QueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        new Thread(() -> {

            try {

                queue.put(1);
                queue.put(2);
                queue.put(3); // waits until space exists

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }).start();

        new Thread(() -> {

            try {

                Thread.sleep(2000);

                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }).start();
    }
}
/*
 * ========================= JAVA CONCURRENCY SUMMARY =========================
 *
 * Concept                 Key Take away
 * ---------------------------------------------------------------------------
 * synchronized            Simple monitor-based locking with automatic lock release.
 *
 * ReentrantLock           Explicit (manual) locking with support for timeout,
 *                         fairness, interruptible locking, and tryLock().
 *
 * Reentrant               The same thread can acquire the same lock multiple
 *                         times without causing a deadlock.
 *
 * Deadlock                Two or more threads wait indefinitely for each other
 *                         to release locks, causing permanent blocking.
 *
 * Preventing Deadlock     Acquire locks in a consistent order or use
 *                         tryLock() with timeout/backoff.
 *
 * AtomicInteger           Lock-free, thread-safe atomic operations using
 *                         Compare-And-Swap (CAS).
 *
 * BlockingQueue           Thread-safe queue where producers and consumers
 *                         automatically block when the queue is full or empty.
 *
 * ===========================================================================
 */



public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
