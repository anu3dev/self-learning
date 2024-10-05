/*
 * 
 * Thread is an execution of sequence of line.
 * java has a default thread and we can create as well.
 * To use thread in java, we have a pre-written Thread class in java.
 * 
 * There is two way to create thread in java.
 * 1. by extending threads i.e. extends Thread
 * 2. by implementing runnable interface i.e. implements Runnable
 * 
 * thread object will be created using Thread class, and thread will be only executed through run method.
 * thread scheduler is boss of all threads, whether it is default thread or user created thread.
 * once thread will be created then it will be handed over to thread scheduler using start method.
 * we have no control on thread scheduler, JVM will manage it.
 * thread scheduler will make sure, CPU time should not be wasted.
 * 
 */

import java.util.Scanner;

class BankDetailsEx1 {
	public BankDetailsEx1() {
		try {
			System.out.println("activity 1 started");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("enter account number");
			int ac = scan.nextInt();
			System.out.println("enter password");
			int pw = scan.nextInt();
			System.out.println("please see details " + ac + " and " + pw);
			System.out.println("activity 1 ended");
		} catch (Exception e) {
			System.out.println("thread 1 intruppted");
		}
	}
}

class PrintNumEx1 {
	public PrintNumEx1() {
		try {
			System.out.println("activity 2 started");
			for(int i = 0; i < 5; i++) {
				System.out.println(i);
				Thread.sleep(3000);
			}
			System.out.println("activity 2 ended");
		} catch (Exception e) {
			System.out.println("thread 2 intruppted");
		}
	}
}

class PrintCharEx1 {
	public PrintCharEx1()  {
		try {
			System.out.println("activity 3 started");
			for(int i = 65; i < 70; i++) {
				System.out.println((char)i);
				Thread.sleep(3000);
			}
			System.out.println("activity 3 ended");
		} catch (Exception e) {
			System.out.println("thread 3 intruppted");
		}
	}
}

/*
 * 
 * example of normal code flow, it will be a single threaded program
 * every normal program without a thread also has a thread and that is default thread
 * we can also change the name and priority of default thread
 * 
 */
class ThreadsEx1 {
	public ThreadsEx1() {
		new BankDetailsEx1();
		new PrintNumEx1();
		new PrintCharEx1();
		
		Thread thread = Thread.currentThread();
		
		/*
		 * 
		 * getting the thread name
		 * 
		 */
		String tName = thread.getName();
		System.out.println("name of thread: " + tName);
		
		/*
		 * 
		 * getting the thread priority
		 * 
		 */
		int p = thread.getPriority();
		System.out.println("priority of thread: " + p);
		
		/*
		 * 
		 * changing the thread name and priority
		 * 
		 */
		thread.setName("anu");
		thread.setPriority(2);
		
		/*
		 * 
		 * validating the tread name
		 * 
		 */
		String tName1 = thread.getName();
		System.out.println("name of thread after change: " + tName1);
		
		/*
		 * 
		 * validating the thread priority
		 * 
		 */
		int p1 = thread.getPriority();
		System.out.println("name of thread after change: " + p1);
	}
}

/*
 * 
 * example - thread created - by implementing runnable interface i.e. Runnable
 * thread will only be executed through run method automatically
 * 
 */
class BankDetailsEx2 implements Runnable {
	public void run() {
		System.out.println("activity 1 started");	
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("enter account number");
			int ac = scan.nextInt();
			System.out.println("enter password");
			int pw = scan.nextInt();
			System.out.println("please see details " + ac + " and " + pw);
		}
		System.out.println("activity 1 ended");
	}
}

class PrintNumEx2 implements Runnable{
	public void run() {
		System.out.println("activity 2 started");	
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("activity 2 ended");
	}
}

class PrintCharEx2 implements Runnable{
	public void run()  {
		System.out.println("activity 3 started");
		for(int i = 65; i < 70; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("activity 3 ended");
	}
}


/*
 * 
 * thread created - by implementing runnable interface i.e. Runnable
 * in below example, thread object is created using Thread class and passing the object as parameter.
 * only creation is not sufficient, we have to start the thread so it can be passed to thread scheduler
 * 
 */
class ThreadsEx2 {
	public ThreadsEx2() {
		BankDetailsEx2 bn = new BankDetailsEx2();
		PrintNumEx2 pn = new PrintNumEx2();
		PrintCharEx2 pc = new PrintCharEx2();
		
		Thread t1 = new Thread(bn);
		Thread t2 = new Thread(pn);
		Thread t3 = new Thread(pc);
		
		System.out.println(t1.isAlive());//false
		System.out.println(t2.isAlive());//false
		System.out.println(t3.isAlive());//false
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println(t1.isAlive());//true
		System.out.println(t2.isAlive());//true
		System.out.println(t3.isAlive());//true
	}
}

/*
 * 
 * example - thread created - by extending threads class, thread will only be executed through run method automatically.
 * 
 */
class BankDetailsEx3 extends Thread {
	public void run() {
		System.out.println("activity 1 started");	
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("enter account number");
			int ac = scan.nextInt();
			System.out.println("enter password");
			int pw = scan.nextInt();
			System.out.println("please see details " + ac + " and " + pw);
		}
		System.out.println("activity 1 ended");
	}
}

class PrintNumEx3 extends Thread {
	public void run() {
		System.out.println("activity 2 started");
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("activity 2 ended");
	}
}

class PrintCharEx3 extends Thread {
	public void run()  {
		System.out.println("activity 3 started");
		for(int i = 65; i < 70; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(3000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("activity 3 ended");
	}
}

/*
 * 
 * thread created - by extending threads
 * 
 */
class ThreadsEx3{
	public ThreadsEx3() {
		BankDetailsEx3 bn = new BankDetailsEx3();
		PrintNumEx3 pn = new PrintNumEx3();
		PrintCharEx3 pc = new PrintCharEx3();
		
		bn.start();
		pn.start();
		pc.start();
	}
}

/*
 * 
 * if we call run method manually then program will behave as single threaded.
 * 
 */
class ThreadsEx4{
	public ThreadsEx4() {
		BankDetailsEx3 bn = new BankDetailsEx3();
		PrintNumEx3 pn = new PrintNumEx3();
		PrintCharEx3 pc = new PrintCharEx3();
		
		bn.run();
		pn.run();
		pc.run();
	}
}

public class P01Threads {
	public static void main(String[] args) {
		//new ThreadsEx1();
		
		//new ThreadsEx2();
		
		//new ThreadsEx3();
		
		//new ThreadsEx4();
	}
}
