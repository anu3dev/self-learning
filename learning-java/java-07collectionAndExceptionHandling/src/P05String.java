/*
 * 
 * String is an object and anything within double quote is considered as string, two types - mutable and immutable.
 * mutable - when we use StringBuffer and StringBuilder class exp. like social account user name, password etc.
 * immutable - when we use String class exp. like name, father name etc.
 * string is by default immutable
 * 
 * since string is an object hence heap area is used for memory allocation.
 * it is stored inside string constant pool in heap area.
 * Earlier string constant pool area was part of method area but after java 7, it became part of heap area.
 * speciality of string constant pool is no duplicacy, in heap area, duplicacy is allowed.
 * 
 * ways to compare string -> 
 * == 					-> reference of string object is compared
 * equal()				-> actual string object (value) is compared
 * equalsIgnoreCase()	-> ignore case sensitivity
 * compareTo()			-> compare the ASCII value, return type is int.
 * 
 * garbage collector job is to find any object without reference and remove it but in case 
 * of constant pool area in heap, garbage collector doesn't do anything.
 * 
 * in case of final keyword, we can't attach any other string reference.
 * 
 * from java 5, Java introduced StringBuilder to support multi threading, bcos it was creating issue with 
 * StringBuffer so Java created new one in-stead of creating new to support backward compatibility.
 * 
 */


class StringEx1 {
	StringEx1(){
		
		/*
		 * 
		 * here memory will be created only once in constant pool area
		 * 
		 */
		String str1 = "Anurag";
		
		/*
		 * 
		 * here memory will be allocated in heap area and also a copy wil be generated in constant pool area
		 * 
		 */
		String str2 = new String("Nitish");
		
		System.out.println(str1 + " " + str2);
	}
}

class StringEx2 {
	StringEx2(){
		String str1 = "Anurag";
		String str2 = "Anurag";
		
		/*
		 * 
		 * string object is compared
		 * 
		 */
		System.out.println(str1.equals(str2));
		
		/*
		 * 
		 * reference is compared
		 * 
		 */
		System.out.println(str1 == str2);
		
	}
}

class StringEx3 {
	StringEx3(){
		String str1 = "Anurag";
		String str2 = new String("Anurag");
		
		/*
		 * 
		 * string object is compared and here referring to only one reference
		 * 
		 */
		System.out.println(str1.equals(str2));
		
		/*
		 * 
		 * reference is compared and here two reference is there
		 * 
		 */
		System.out.println(str1 == str2);
	}
}

class StringEx4 {
	StringEx4(){
		String str1 = new String("Anurag");
		String str2 = new String("Anurag");
		
		/*
		 * 
		 * string object is compared and here referring to only one reference
		 * 
		 */
		System.out.println(str1.equals(str2));
		
		/*
		 * 
		 * reference is compared and here two reference is there
		 * 
		 */
		System.out.println(str1 == str2);
	}
}

class StringEx5 {
	StringEx5(){
		String str1 = "Anurag";
		String str2 = "Anurag";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
	}
}

class StringEx6 {
	StringEx6(){
		String str1 = "Anurag";
		String str2 = "anurag";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		System.out.println(str1.equalsIgnoreCase(str2));
		
		int res = str1.compareTo(str2);
		System.out.println(res);
	}
}

class StringEx7 {
	StringEx7(){
		String str1 = "Anurag";
		String str2 = " Kumar";
		
		String res1 = str1.concat(str2);
		System.out.println(res1);
		
		String res2 = "Anurag" + " Kumar";
		System.out.println(res2);
	}
}

class StringEx8 {
	StringEx8(){
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
 * 
 * example of mutable string using StringBuffer and StringBuilder, both has default capacity is 16, and if  
 * we increase then old capacity*2+2 and goes on like 16, 34, 70 etc., capacity means memory locations.
 * 
 */
class StringEx9 {
	StringEx9(){
		StringBuffer str1 = new StringBuffer("AnuRAG");
		System.out.println(str1);
		System.out.println(str1.capacity());
		
		str1.append(" Kumar Singh From India");
		System.out.println(str1.capacity());
	}
}

class StringEx10 {
	StringEx10(){
		StringBuilder str1 = new StringBuilder("AnuRAG");
		System.out.println(str1);
		System.out.println(str1.capacity());
		
		str1.append(" Kumar From India");
		System.out.println(str1);
		System.out.println(str1.capacity());
		
		StringBuilder str2 = new StringBuilder("AnuRAG");
		StringBuilder str3 = new StringBuilder("kumar");
		System.out.println(str2.equals(str3));
		/*
		 * 
		 * equal method is part of main parent i.e. object class and
		 * it inherited to every child class and it is not overridden by team java compares the reference.
		 * 
		 */
		System.out.println(str2.compareTo(str3));
	}
}

/*
 * 
 * mutability and final
 * 
 */
class StringEx11 {
	StringEx11(){
		final StringBuilder str1 = new StringBuilder("AnuRAG");
		System.out.println(str1);
		
		str1.append(" Kumar");
		System.out.println(str1);
		
		/*
		 * 
		 * final has no impact on immutability, but it will impact the reference of an object
		 * 
		 */
		//str1 = new StringBuilder("ABC");
	}
}

public class P05String {
	public static void main(String[] args) {
		
		//new StringEx1();
		
		//new StringEx2();
		
		//new StringEx3();
		
		//new StringEx4();
		
		//new StringEx5();
		
		//new StringEx6();
		
		//new StringEx7();
		
		//new StringEx8();
		
		//new StringEx9();
		
		//new StringEx10();
		
		//new StringEx11();
	}
}
