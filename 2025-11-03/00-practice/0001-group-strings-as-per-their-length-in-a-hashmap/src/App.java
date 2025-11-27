import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App{
	public static void main(String[] args) {
		List<String> fruitStringsArrayList = new ArrayList<String>(Arrays.asList("apple", "banana", "papaya", "kiwi", "pear"));
		
		// using stream feature
		 Map<Integer, List<String>> fruitsMap1 = fruitStringsArrayList.stream()
				 .collect(Collectors.groupingBy(String :: length));
		 System.out.println(fruitsMap1); 
		 // {4=[kiwi, pear], 5=[apple], 6=[banana, papaya]}
		 
		 
		 
		 
		 
		 // using for loop
		 Map<Integer, List<String>> fruitsMap2 = new HashMap<Integer, List<String>>();
		 for(String fruit : fruitStringsArrayList) {
			 if(!fruitsMap2.containsKey(fruit.length())) {
				 fruitsMap2.put(fruit.length(), new ArrayList<String>());
			 }
			 fruitsMap2.get(fruit.length()).add(fruit);
		 }
		 System.out.println(fruitsMap2); 
		 // {4=[kiwi, pear], 5=[apple], 6=[banana, papaya]}
		 
		 
		 
		 
		 
		 // using for lambda
		 Map<Integer, List<String>> fruitsMap3 = new HashMap<Integer, List<String>>();
		 for(String fruit : fruitStringsArrayList) {
			 fruitsMap3.computeIfAbsent(fruit.length(), f -> new ArrayList<>()).add(fruit);
		 }
		 System.out.println(fruitsMap3); 
		 // {4=[kiwi, pear], 5=[apple], 6=[banana, papaya]}
	}
}