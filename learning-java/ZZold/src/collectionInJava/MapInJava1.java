package collectionInJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.WeakHashMap;

class MapInJava1Ex1Method1 {
	int id;
	String name;
	
	@Override
	public String toString() {
		return "Employee4 [id=" + id + ", name=" + name + "]";
	}

	@Override
	public void finalize() {
		System.out.println("Obj cleaning by Garbage collector");
	}
}

class MapInJava1Ex1 {
	@SuppressWarnings("unchecked")
	public MapInJava1Ex1() {
		MapInJava1Ex1Method1 emp = new MapInJava1Ex1Method1();
		
		@SuppressWarnings("rawtypes")
		WeakHashMap hm = new WeakHashMap();
		
		hm.put(emp, "Telusko");
			
		System.out.println(hm);
						
		emp=null;
			
		System.gc();
			
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println(hm);
	}
}
class MapInJava1Ex2Method1 {
	private int age;
	private String name;
	private String city;
	
	public MapInJava1Ex2Method1(int age, String name, String city) {
		super();
		this.age = age;
		this.name = name;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "[age=" + age + ", name=" + name + ", city=" + city + "]";
	}
}

class MapInJava1Ex2 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapInJava1Ex2() {
		MapInJava1Ex2Method1 info1 = new MapInJava1Ex2Method1(16, "Mehu", "Bengaluru");
		MapInJava1Ex2Method1 info2 = new MapInJava1Ex2Method1(17, "Rohan", "Pune");
		MapInJava1Ex2Method1 info3 = new MapInJava1Ex2Method1(18, "Saurabh", "Mumbai");
		
		HashMap hm = new HashMap<>();
		hm.put(123, info1);
		hm.put(111, info2);
		hm.put(222, info3);
		
		System.out.println("Welcome to information center");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the idenity number to get your infor");
		
		Integer key = scan.nextInt();
		Set set = hm.entrySet();
		boolean flag=false;
		
		Iterator itr=set.iterator();
		while(itr.hasNext()) {
			Map.Entry entry=(Entry) itr.next();
			Integer k=(Integer) entry.getKey();
			
			if(k==key) {
				System.out.println("The infor is : "+ entry.getValue());
				flag =true;
			}
			
		}
		
		if(flag==false) {
			System.out.println("Invalid ID");
		}

	}
}

public class MapInJava1 {
	public static void main(String[] args) {
		new MapInJava1Ex1();
		
		new MapInJava1Ex2();
	}
}
