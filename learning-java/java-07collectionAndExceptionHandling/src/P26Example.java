import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P26Example {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("mango");
		list.add("orange");
		list.add("Grapes");
		System.out.println(list);
		        
		Set<String> set = new HashSet<String>();
		set.add("mango");
		set.add("orange");
		set.add("Grapes");
		System.out.println(set);
		        
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(100, "Amit");
		map1.put(101, "Vijay");
		map1.put(102, "Rahul");
		System.out.println(map1);
		        
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("hi", "Amit");
		map2.put("bi", "Vijay");
		System.out.println(map2);
	}
}
