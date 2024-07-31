/*
 * string is an object and anything within double quote is considered as string object.
 * two types - mutable and immutable.
 * 
 * mutable - when we use StringBuffer and StringBuilder class eg. like social account user name, password etc.
 * eg.
 * 
 * immutable - when we use String class eg. like name, father name etc.
 * eg. 
 * 
 * since string is an object hence heap area is used for memory allocation.
 * 
 * it is stored inside string constant pool in heap area,
 * earliar string constant pool area was part of method area but after java 7, it became part of heap area.
 * speciality of string constant pool is no duplicy.
 * 
 * in heap area, duplicy is allowed.
 * 
 * ways to compare string -> 
 * == -> refrence of string object is compared
 * equal() -> actual string object (value) is compared
 * equalsIgnoreCase() -> ignore case sensetivity
 * compareTo() -> compare the ascii value, return type is int.
 * 
 * garbage collector job is to find any object without refrence and remove it but in case 
 * of constant pool area in heap, garbage collector doesn't do anything.
 * 
 * string is by default immutable
 * 
 * in case of final keyword, we can't attach any othet string refrence.
 * 
 * from java 5, Java introduced StringBuilder to support multi threading,
 * bcos it was creating issue with StringBuffer so Java created new one
 * instread of creating new to support backward compactibility.
 */
package collectionInJava;

class StringInJavaEx1 {
	StringInJavaEx1(){
		
		String str1 = "Anurag";
		/*
		 * here memory will be created only once in constant pool area
		 */
		
		String str2 = new String("Nitish");
		/*
		 * here memory will be allocated in heap area and also a copy wil be generated in constant pool area
		 */
		
		System.out.println(str1 + " " + str2);
	}
}

class StringInJavaEx2 {
	StringInJavaEx2(){
		String str1 = "Anurag";
		
		String str2 = "Anurag";
		
		System.out.println(str1.equals(str2));
		/*
		 * string object is compared
		 */
		
		System.out.println(str1 == str2);
		/*
		 * refrence is compared
		 */
	}
}

class StringInJavaEx3 {
	StringInJavaEx3(){
		String str1 = "Anurag";
		
		String str2 = new String("Anurag");
		
		System.out.println(str1.equals(str2));
		/*
		 * string object is compared and here refering to only one refrence
		 */
		
		System.out.println(str1 == str2);
		/*
		 * refrence is compared and here two refrence is there
		 */
	}
}

class StringInJavaEx4 {
	StringInJavaEx4(){
		String str1 = new String("Anurag");
		
		String str2 = new String("Anurag");
		
		System.out.println(str1.equals(str2));
		/*
		 * string object is compared and here refering to only one refrence
		 */
		
		System.out.println(str1 == str2);
		/*
		 * refrence is compared and here two refrence is there
		 */
	}
}

class StringInJavaEx5 {
	StringInJavaEx5(){
		String str1 = "Anurag";
		String str2 = "Anurag";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
	}
}

class StringInJavaEx6 {
	StringInJavaEx6(){
		String str1 = "Anurag";
		String str2 = "anurag";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		System.out.println(str1.equalsIgnoreCase(str2));
		
		int res = str1.compareTo(str2);
		System.out.println(res);
	}
}

class StringInJavaEx7 {
	StringInJavaEx7(){
		String str1 = "Anurag";
		String str2 = " Kumar";
		
		String res1 = str1.concat(str2);
		System.out.println(res1);
		
		String res2 = "Anurag" + " Kumar";
		System.out.println(res2);
	}
}

class StringInJavaEx8 {
	StringInJavaEx8(){
		String str1 = "AnuRAG";
		
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		System.out.println(str1.charAt(2));
		System.out.println(str1.substring(1,3));
		System.out.println(str1.contains("p"));
		System.out.println(str1.indexOf("A"));
		System.out.println(str1.lastIndexOf("A"));
		System.out.println(str1.length());
		
		char ch1[] = str1.toCharArray();
		for(char c:ch1) {
			System.out.print(c + " ");
		}
		
		String ch2[] = str1.split("A");
		for(String c:ch2) {
			System.out.print(c + " ");
		}
	}
}

/*
 * example of mutable string using StringBuffer and StringBuilder
 * StringBuilder and StringBuffer both has default capacity is 16, and 
 * if we increase then oldcapacity*2+2 and goes on like 16, 34, 70 etc. , 
 * capacity means memory locations
 */
class StringInJavaEx9 {
	StringInJavaEx9(){
		StringBuffer str1 = new StringBuffer("AnuRAG");
		System.out.println(str1);
		System.out.println(str1.capacity());
		
		str1.append(" Kumar Singh From India");
		System.out.println(str1.capacity());
	}
}
// capacity needs to check
class StringInJavaEx10 {
	StringInJavaEx10(){
		StringBuilder str1 = new StringBuilder("AnuRAG");
		System.out.println(str1);
		System.out.println(str1.capacity());
		
		str1.append(" Kumar Singh From India");
		System.out.println(str1);
		System.out.println(str1.capacity());
		
		StringBuilder str2 = new StringBuilder("AnuRAG");
		StringBuilder str3 = new StringBuilder("AnuRAG");
		System.out.println(str2.equals(str3));
		/*
		 * equal method is part of main parent i.e. object class
		 * and it inherited to every child class and it is not overriden 
		 * by team javacompares the refrence.
		 */
//		System.out.println(str2.compareTo(str3));
	}
}

/*
 * mutability and final
 */
class StringInJavaEx11 {
	StringInJavaEx11(){
		final StringBuilder str1 = new StringBuilder("AnuRAG");
		System.out.println(str1);
		str1.append(" Kumar");
		System.out.println(str1);
		
		// str1 = new StringBuilder("ABC");
		/*
		 * final has no impact on imtubality 
		 * but it will impact the refrence of an object
		 */
	}
}

public class StringInJava {
	public static void main(String[] args) {
		
//		new StringInJavaEx1();
//		new StringInJavaEx2();
//		new StringInJavaEx3();
//		new StringInJavaEx4();
//		new StringInJavaEx5();
//		new StringInJavaEx6();
//		new StringInJavaEx7();
//		new StringInJavaEx8();
//		new StringInJavaEx9();
//		new StringInJavaEx10();
//		new StringInJavaEx11();
	}
}
