/*
 * ===========================  STRING IN JAVA  ===========================
 *
 * 1️⃣  Definition:
 *  • In Java, a String is an **object**, and anything enclosed in double quotes 
 *  ("...") is treated as a String literal.
 *  • Strings are of two types:
 *    🔸 Immutable  → Using the `String` class
 *    🔸 Mutable    → Using the `StringBuilder` or `StringBuffer` classes
 *
 * ------------------------------------------------------------------------
 * 2️⃣  Immutable vs Mutable:
 *  • **Immutable (String):**
 *   - Once created, the value cannot be changed.
 *   - Any modification (like concatenation) creates a new object.
 *   - Example use cases: name, address, constants.
 *
 *  • **Mutable (StringBuffer / StringBuilder):**
 *   - Can be modified without creating a new object.
 *   - Example use cases: dynamic data such as username, passwords, text editing, etc.
 *
 * ------------------------------------------------------------------------
 * 3️⃣  Memory Management:
 *  • Strings are stored in the **heap area** (since they are objects).
 *  • Java maintains a special memory region called the 
 *  **String Constant Pool (SCP)** inside the heap.
 *
 *  • Key points:
 *   - The SCP was part of the method area before Java 7, 
 *         but since Java 7 it moved to the **heap**.
 *   - In the SCP, **duplicate string literals are not allowed**.
 *         If an identical literal already exists, the reference to the 
 *         existing object is returned.
 *   - Outside the SCP (normal heap), duplicate string objects can exist.
 *
 * ------------------------------------------------------------------------
 * 4️⃣  String Comparison Methods:
 *  • `==`                 → Compares **references** (memory addresses).
 *  • `equals()`           → Compares **content** (actual string value).
 *  • `equalsIgnoreCase()` → Compares content while **ignoring case** differences.
 *  • `compareTo()`        → Compares **lexicographically** (based on Unicode/ASCII values).
 *                           Returns:
 *                               0   → if both strings are equal
 *                               < 0 → if first string < second string
 *                               > 0 → if first string > second string
 *
 * ------------------------------------------------------------------------
 * 5️⃣  Garbage Collection Behavior:
 *  • Normally, the **Garbage Collector (GC)** removes objects that have no references.
 *  • However, **string literals** stored in the String Constant Pool are **not garbage collected**
 *    until the class loader that loaded them is garbage collected (typically, at JVM shutdown).
 *
 * ------------------------------------------------------------------------
 * 6️⃣  The `final` Keyword and Strings:
 *  • When a String reference is declared `final`, the reference cannot be changed to point to another object.
 *  • However, the original string object remains immutable regardless of `final`.
 *
 * ------------------------------------------------------------------------
 * 7️⃣  StringBuffer vs StringBuilder:
 *  • Both classes create **mutable strings**.
 *  • `StringBuffer` → **Thread-safe** (synchronized) — suitable for multithreaded environments.
 *  • `StringBuilder` → **Not thread-safe**, but faster — suitable for single-threaded applications.
 *
 *  • Historical Note:
 *       - `StringBuffer` existed since Java 1.0.
 *       - `StringBuilder` was introduced in **Java 5** to improve performance in single-threaded scenarios
 *         and to maintain backward compatibility.
 *
 * ------------------------------------------------------------------------
 * ✅  Summary:
 *  • String → Immutable
 *  • StringBuffer → Mutable + Thread-safe
 *  • StringBuilder → Mutable + Non-thread-safe (faster)
 *  • String literals → Stored in String Constant Pool (no duplicates)
 *
 * ========================================================================
 */

public class P01String {
	static class P01StringEx01{
		public P01StringEx01() {
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
	
	public static void main(String[] args) {
		new P01StringEx01();
	}
}
