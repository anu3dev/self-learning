/*
 * 
 * Vector and Dictionary are legacy classes which they have again introduced after collection
 * 
 * Vector is from .9 i.e. alpha version and iterator is from 1.2
 * 
 */

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class VectorEx1 {
	public VectorEx1() {
		
		Vector<Integer> vec = new Vector<>();
		
		vec.add(10);
		vec.add(20);
		vec.add(30);
		vec.add(40);
		
		System.out.println(vec);
		
		System.out.println("######################");
		
		Iterator<Integer> itr = vec.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("######################");
		
		Enumeration<Integer> env = vec.elements();
		
		while(env.hasMoreElements()) {
			System.out.println(env.nextElement());
		}	
	}
}
public class P15Vector {
	public static void main(String[] args) {
		new VectorEx1();
	}
}
