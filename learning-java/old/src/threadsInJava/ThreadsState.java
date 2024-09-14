/*
 * threads has below states
 * 
 * new -> runnable OR ready -> running -> dead
 * running has states like sleep, blocked, waiting etc.
 * sleep, blocked or waiting will go to runnable state once it is ready
 * 
 * in running state, only one thread will be there
 * 
 * creation of thread is a new state
 * start() i.e. starting of a thread is a runnable state
 * run() i.e. run method is a running state
 * 
 * we can't intruppt a running thread, it can be intruppted only if it is other than running state
 */
package threadsInJava;

class Bathroom1 implements Runnable {
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " has entered the bathroom");
			Thread.sleep(4000);
			System.out.println(Thread.currentThread().getName() + " is using the bathroom");
			Thread.sleep(4000);
			System.out.println(Thread.currentThread().getName() + " has exited the bathroom");
		}
		catch(Exception e) {
			System.out.println("Thread interrupted");
		}
	}
}

class Bathroom2 implements Runnable {
	synchronized public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " has entered the bathroom");
			Thread.sleep(4000);
			System.out.println(Thread.currentThread().getName() + " is using the bathroom");
			Thread.sleep(4000);
			System.out.println(Thread.currentThread().getName() + " has exited the bathroom");
		}
		catch(Exception e) {
			System.out.println("Thread interrupted");
		}
	}
}

/*
 * here single resource is there but due to multi-threading everyone is occupying and it is not expected behaviour
 * 
 * using suynchronized keyword we can handle this situation
 */
class ThreadsStateEx1{
	public ThreadsStateEx1() {
		//Bathroom1 b=new Bathroom1();
		Bathroom2 b=new Bathroom2();
		
		Thread t1=new Thread(b);
		Thread t2=new Thread(b);
		Thread t3=new Thread(b);
		
		t1.setName("BOY");
		t2.setName("GIRL");
		t3.setName("TIKTOKER");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class Parking implements Runnable {
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " has entered to the parking");
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + " has reached to the car");
			Thread.sleep(2000);
			synchronized(this) {
				System.out.println(Thread.currentThread().getName() + " has started the car");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " has entered back to the parking");
			}
		}
		catch(Exception e) {
			System.out.println("Thread interrupted");
		}
	}
}

/*
 * synchronized keyword can be used at part of code, like in example below,
 * everyone can enter to parking and reach to car but can be drived by only one and once he will be back, other will get chance
 */
class ThreadsStateEx2{
	public ThreadsStateEx2() {
		Parking p = new Parking();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(p);
		Thread t4 = new Thread(p);
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		t4.setName("D");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

public class ThreadsState {
	public static void main(String[] args) {
		//new ThreadsStateEx1();
		//new ThreadsStateEx2();
	}
}
