package j001string;

public class J001String {
	public static void main(String[] args) {
		// here memory will be created only once in constant pool area
		String str1 = "Anurag";
					
		// here memory will be allocated in heap area 
		// and also a copy will be generated in constant pool area
		String str2 = new String("Nitish");
					
		System.out.println(str1 + " " + str2);
					
					
					
		// string object is being compared
		System.out.println(str1.equals(str2));
		// reference is being compared
		System.out.println(str1 == str2);
	}
}
