/*
 * Below is a example of deadlock in java
 * 
 * multiple thread gets block due to mutual dependency is called deadlock in java
 * it happens bcos we don't use synchronized keyword in proper order
 * 
 * lifelock concept is also there, in lifelock, resource is available but noone able to use it due to mutual dependency
 */

/*
 * at first, either student1 or student2 will acquire res1 and go to sleep state
 * then, other student will try to get the resource res1 but res1 is not available so it will go to block state
 * then first student will again come back and acquire res2 then res 3 then it will release all resource
 * then other student will go and acquire the res1 then res2 then res3
 */
package threadsInJava;

class Library implements Runnable {
	String res1 = new String("JAVA");
	String res2 = new String("DSA");
	String res3 = new String("SpringBoot");
					
	public void run() {
		String tName = Thread.currentThread().getName();
		
		if("Student1".equals(tName)) {
			try {
				Thread.sleep(4000);
				synchronized(res1) {
					System.out.println("Student1 has acquired : " + res1);
					Thread.sleep(4000);
					synchronized(res2) {
						System.out.println("Student1 has acquired : " + res2);
						Thread.sleep(4000);
						synchronized(res3) {
							System.out.println("Student1 has acquired : " + res3);
						}
					}
				}
			} catch(Exception e) {
				System.out.println("some problem");
			}
		} else {
			try {
				Thread.sleep(4000);
				synchronized(res1) {
					System.out.println("Student2 has acquired : " + res1);
					Thread.sleep(4000);
					synchronized(res2) {
						System.out.println("Student2 has acquired : " + res2);
						Thread.sleep(4000);
						synchronized(res3) {
							System.out.println("Student2 has acquired : " + res3);
						}
					}
				}
			} catch(Exception e) {
				System.out.println("some problem");
			}
		}
	}
}

/*
 * at first, either student1 or student2 will acquire res1 and go to sleep state
 * then, other student will acquire the res3 and go to sleep state
 * then first will come and acquire the res2 and go to sleep state
 * now program will go to dedlock 
 * bcos second student will not not able to get res2 and go to block state
 * and first will not able to get res3 bcos it is taken by second so it will go to block state
 */
class Library1 implements Runnable {
	String res1 = new String("JAVA");
	String res2 = new String("DSA");
	String res3 = new String("SpringBoot");
					
	public void run() {
		String tName = Thread.currentThread().getName();
		
		if("Student1".equals(tName)) {
			try {
				Thread.sleep(4000);
				synchronized(res1) {
					System.out.println("Student1 has acquired : " + res1);
					Thread.sleep(4000);
					synchronized(res2) {
						System.out.println("Student1 has acquired : " + res2);
						Thread.sleep(4000);
						synchronized(res3) {
							System.out.println("Student1 has acquired : " + res3);
						}
					}
				}
			} catch(Exception e) {
				System.out.println("some problem");
			}
		} else {
			try {
				Thread.sleep(4000);
				synchronized(res3) {
					System.out.println("Student2 has acquired : " + res3);
					Thread.sleep(4000);
					synchronized(res2) {
						System.out.println("Student2 has acquired : " + res2);
						Thread.sleep(4000);
						synchronized(res1) {
							System.out.println("Student2 has acquired : " + res1);
						}
					}
				}
			} catch(Exception e) {
				System.out.println("some problem");
			}
		}
	}
}

public class ThreadsDeadlock {
	public static void main(String[] args) {
		
		/*
		 * exaple without deadlock with synchronized keyword
		 */
		//Library lib = new Library();
		
		/*
		 * exaple with deadlock with synchronized keyword
		 */
		Library1 lib = new Library1();
		
		Thread t1 = new Thread(lib);
		Thread t2 = new Thread(lib);
		
		t1.setName("Student1");
		t2.setName("Student2");
		
		t1.start();
		t2.start();
	}
}
