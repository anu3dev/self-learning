/*
 * producer and consumer problem OR inter-thread communication in thread
 */
package threadsInJava;

class Producer extends Thread{
	Queue q;
	
	public Producer(Queue y) {
		q = y;
	}
	@Override
	public void run() {
		int i = 1;
		while(true) {
			q.put(i++);
		}	
	}
}

class Consumer extends Thread{
	Queue q;
	
	public Consumer(Queue y) {
		q = y;
	}
	@Override
	public void run() {
		while(true) {
			q.get();
		}
	}
}

class Queue {
	int x;
	
	public void put(int data) {
		x = data;
		System.out.println("I have procuded the data into x : " + x);
	}
	
	public void get() {
		System.out.println("I have consumed the data from x : " + x);
	}
}

class Producer1 extends Thread{
	Queue1 q;
	
	public Producer1(Queue1 y) {
		q = y;
	}
	@Override
	public void run() {
		int i = 1;
		while(true) {
			q.put(i++);
		}	
	}
}

class Consumer1 extends Thread{
	Queue1 q;
	
	public Consumer1(Queue1 y) {
		q = y;
	}
	@Override
	public void run() {
		while(true) {
			q.get();
		}
	}
}

class Queue1 {
	int x;
	boolean flag = false;
	
	synchronized public void put(int data) {
		try {
			if(flag == true) {
				wait();
			} else {
				x = data;
				System.out.println("I have procuded the data into x : " + x);
				flag = true;
				notify();
			}
		} catch (Exception e) {
			System.out.println("some problem in put");
		}
	}
	
	synchronized public void get() {
		try {
			if(flag == false) {
				wait();
			} else {
				System.out.println("I have consumed the data from x : " + x);
				flag = false;
				notify();
			}
		} catch(Exception e) {
			System.out.println("some problem in get");
		}
	}
}

public class ThreadsProducerAndConsumerProblem {
	public static void main(String[] args) {
		
		/*
		 * in this example no inter thread communication is happening
		 * means producer is producing randomly and if consumer is getting time 
		 * then it is consuming randomly
		 */
		//Queue q = new Queue();
		//Producer pd = new Producer(q);
		//Consumer c = new Consumer(q);
		
		/*
		 * in this example inter thread communication is happening
		 * means producer is producing and consumer is consuming
		 */
		Queue1 q = new Queue1();
		Producer1 pd = new Producer1(q);
		Consumer1 c = new Consumer1(q);
		
		pd.start();
		c.start();
	}
}
