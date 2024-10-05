import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayAsListEx1{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayAsListEx1() {
		ArrayList list1 = new ArrayList();
		
		list1.add(10);
		list1.add(20);
		list1.add(40);
		list1.add(50);
		
		System.out.println(list1);
		list1.forEach(n->System.out.println(n));
		
		List list2 = Arrays.asList(10,20,30,40);
		for(Object item:list2) {
			System.out.println(item);
		}	
	}
}

public class P22ArrayList {
	public static void main(String[] args) {
		new ArrayAsListEx1();
	}
}
