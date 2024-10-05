/*
 * 
 * threads has states like => new -> runnable OR ready -> running -> dead
 * running has states like sleep, blocked, waiting etc.
 * sleep, blocked or waiting will go to runnable state once it is ready.
 * 
 * in running state, only one thread will be there.
 * 
 * creation of thread is a new state.
 * start() i.e. starting of a thread is a runnable state.
 * run() i.e. run method is a running state.
 * 
 * we can't interrupt a running thread, it can be interrupted only if it is other than running state.
 * 
 */


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

/*
 * 
 * Here single resource is there but due to multi-threading, everyone is occupying and it is not expected behavior.
 * Using synchronized keyword we can handle this situation.
 * 
 */
class ThreadsStateEx1{
	public ThreadsStateEx1() {
		Bathroom1 b = new Bathroom1();
		
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

class ThreadsStateEx2{
	public ThreadsStateEx2() {
		Bathroom2 b = new Bathroom2();
		
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

/*
 * 
 * synchronized keyword can be used at part of code, like in example below.
 * everyone can enter to parking and reach to car but can be driven by only one and once he will be back, other will get chance
 * 
 */

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

class ThreadsStateEx3{
	public ThreadsStateEx3() {
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

public class P03ThreadsState {
	public static void main(String[] args) {
		//new ThreadsStateEx1();
		
		//new ThreadsStateEx2();
		
		//new ThreadsStateEx3();
	}
}
