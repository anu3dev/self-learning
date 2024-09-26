/*
 * 
 * FailFast: If we use Iterator to access the data present within collection and if we attempt 
 * for concurrent modification then it will lead to Exception and 
 * program will fail (No concurrent modification)
 * 
 * FailSafe: If we want to achieve fail safe we must use classes present in java.util.concurrent package 
 * example: CopyOnWriteArrayList and so on....
 * If concurrent modification is attempted program will fail safe without leading to an Exception 
 * ( No Exception No and concurrent modification)
 * 
 */

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class CopyOnWriteArrayListEx1 {
	public CopyOnWriteArrayListEx1() {
			
		CopyOnWriteArrayList<Integer> copyOnWriteArrayList1 = new CopyOnWriteArrayList<>();
		
		copyOnWriteArrayList1.add(10);
		copyOnWriteArrayList1.add(20);
		copyOnWriteArrayList1.add(30);
		copyOnWriteArrayList1.add(50);
		copyOnWriteArrayList1.add(40);
	   
		System.out.println(copyOnWriteArrayList1);
		
		System.out.println("#####################");
		
		for(Object obj: copyOnWriteArrayList1){
			System.out.println(obj);
		}
		
		System.out.println("#####################");
		
		Iterator<Integer> itr1 = copyOnWriteArrayList1.iterator();
		
		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
	}
}

public class P14CopyOnWriteArrayList {
	public static void main(String[] args) {
		//new CopyOnWriteArrayListEx1();
	}
}
