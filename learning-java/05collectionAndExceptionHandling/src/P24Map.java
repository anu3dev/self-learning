import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class MapEx2Method1 {
	private int age;
	private String name;
	
	public MapEx2Method1(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[age=" + age + ", name=" + name + "]";
	}
}

class MapEx2 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MapEx2() {
		MapEx2Method1 info1 = new MapEx2Method1(16, "Mehu");
		MapEx2Method1 info2 = new MapEx2Method1(17, "Rohan");
		MapEx2Method1 info3 = new MapEx2Method1(18, "Saurabh");
		
		HashMap hm = new HashMap<>();
		hm.put(123, info1);
		hm.put(111, info2);
		hm.put(222, info3);
		
		System.out.println("Welcome to info center");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the idenity number");
		
		Integer key = scan.nextInt();
		Set set = hm.entrySet();
		boolean flag=false;
		
		Iterator itr=set.iterator();
		while(itr.hasNext()) {
			Map.Entry entry=(Entry) itr.next();
			Integer k=(Integer) entry.getKey();
			
			if(k==key) {
				System.out.println("The info is : "+ entry.getValue());
				flag =true;
			}
		}
		
		if(flag==false) {
			System.out.println("Invalid ID");
		}
	}
}

public class P24Map {
	public static void main(String[] args) {
		new MapEx2();
	}
}
