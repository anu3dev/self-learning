import java.util.HashSet;
import java.util.Set;

public class App{
	public static void main(String[] args) {
		String string = "papaya";
		
		// only store unique value
		Set<Character> characters = new HashSet<Character>();
		
		for(Character c : string.toCharArray()) {
			characters.add(c);
		}
		
		System.out.println(characters);
	}
}