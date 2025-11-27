import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App{
	public static void main(String[] args) {
		String str1 = "papaya";
		
		// acts like JavaScript object
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(Character c : str1.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		List<Character> characters = new ArrayList<Character>();
		for(Map.Entry<Character, Integer> filteredMapEntry : map.entrySet()) {
			if(filteredMapEntry.getValue() == 1) {
				characters.add(filteredMapEntry.getKey());
			}
		}
		
		System.out.println(characters);
	}
}