/*
 * 
 * java.lang.Thread class provides the join() method.
 * which allows one thread to wait until another thread completes its execution.
 * If t is a Thread object whose thread is currently executing, then t.join() will make sure 
 * that t is terminated before the next instruction is executed by the program.
 * 
 */


import java.util.Scanner;

class ThreadsJoinBankDetailsEx1 implements Runnable {
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

class ThreadsJoinPrintNumEx1 implements Runnable{
	public void run() {
		System.out.println("activity 2 started");	
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		System.out.println("activity 2 ended");
	}
}

class ThreadsJoinPrintCharEx1 implements Runnable{
	public void run()  {
		System.out.println("activity 3 started");
		for(int i = 65; i < 70; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		System.out.println("activity 3 ended");
	}
}

class ThreadsJoinEx1 {
	ThreadsJoinEx1(){
		ThreadsJoinBankDetailsEx1 bn = new ThreadsJoinBankDetailsEx1();
		ThreadsJoinPrintNumEx1 pn = new ThreadsJoinPrintNumEx1();
		ThreadsJoinPrintCharEx1 pc = new ThreadsJoinPrintCharEx1();
		
		Thread t1 = new Thread(bn);
		Thread t2 = new Thread(pn);
		Thread t3 = new Thread(pc);
		
		t1.start();
		try {
			t1.join();
		} catch(Exception e) {
			System.out.println("something unexpected happened in t1.");
		}
		
		t2.start();
		try {
			t2.join();
		} catch(Exception e) {
			System.out.println("something unexpected happened in t1.");
		}
		
		t3.start();
	}
}

class ThreadsJoinBankDetailsEx2 extends Thread {
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

class ThreadsJoinPrintNumEx2 extends Thread {
	public void run() {
		System.out.println("activity 2 started");
		for(int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("activity 2 ended");
	}
}

class ThreadsJoinPrintCharEx2 extends Thread {
	public void run()  {
		System.out.println("activity 3 started");
		for(int i = 65; i < 70; i++) {
			System.out.println((char)i);
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("activity 3 ended");
	}
}

class ThreadsJoinEx2{
	ThreadsJoinEx2(){
		ThreadsJoinBankDetailsEx2 bn = new ThreadsJoinBankDetailsEx2();
		ThreadsJoinPrintNumEx2 pn = new ThreadsJoinPrintNumEx2();
		ThreadsJoinPrintCharEx2 pc = new ThreadsJoinPrintCharEx2();
		
		bn.start();
		try {
			bn.join();
		} catch(Exception e) {
			System.out.println("something unexpected happened in bn.");
		}
		
		pn.start();
		try {
			pn.join();
		} catch(Exception e) {
			System.out.println("something unexpected happened in pn.");
		}
		
		pc.start();
	}
}

public class P02ThreadsJoin {
	public static void main(String[] args) {
		//new ThreadsJoinEx1();
		
		//new ThreadsJoinEx2();
	}
}