package j005vector;

import java.util.List;
import java.util.Vector;

public class J001Vector {
	public static void main(String[] args) {
		List<Integer> vector = new Vector<>();
		vector.add(10);
		vector.add(20);
		vector.add(30);
		System.out.println(vector); // [10, 20, 30]
		vector.remove(0);
		System.out.println(vector); // [20, 30]
	}
}
