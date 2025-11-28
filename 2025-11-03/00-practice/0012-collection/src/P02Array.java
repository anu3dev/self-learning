/*
 * ==============================  ARRAYS IN JAVA  ==============================
 *
 * 1️⃣  Definition:
 *  • In Java, an array is an object that stores multiple values of the same type.
 *  • Hence, arrays are created in the **heap memory** (like any other object).
 *  • Syntax:
 *        dataType[] arrayName = new dataType[size];
 *    Example:
 *        int[] array = new int[5];
 *
 * -----------------------------------------------------------------------------
 * 2️⃣  Characteristics:
 *  • Arrays are **index-based** data structures.
 *  • Index starts from 0 → last index = (size - 1).
 *  • Every element is accessed using its index (array[0], array[1], ...).
 *  • Arrays store a **fixed-size**, **homogeneous** (same data type) collection.
 *
 * -----------------------------------------------------------------------------
 * 3️⃣  Memory Allocation:
 *  • Array reference (variable) is stored in the **stack**, but
 *    the actual array object (data) is stored in the **heap area**.
 *  • When you create an array, JVM automatically allocates contiguous memory
 *    for all its elements.
 *
 * -----------------------------------------------------------------------------
 * 4️⃣  Boundary Protection:
 *  • Java arrays are **bounds-checked**.
 *  • If you try to access an index outside the valid range (0 to size-1),
 *    Java throws a **ArrayIndexOutOfBoundsException**.
 *
 * -----------------------------------------------------------------------------
 * 5️⃣  Major Limitations of Arrays:
 *  • Can store only **homogeneous data types** (no mix of int, double, String, etc.).
 *  • Requires **contiguous memory allocation**, which can cause fragmentation.
 *  • **Fixed size** → once declared, cannot grow or shrink dynamically.
 *  • To resize, you must create a **new array** and copy old data.
 *  • Does not provide direct built-in methods for adding/removing elements
 *    (though utility methods exist in `java.util.Arrays`).
 *
 * -----------------------------------------------------------------------------
 * 6️⃣  Types of Arrays:
 *  • **Single-Dimensional Array:** A simple list of elements.
 *        int[] array = new int[5];
 *  • **Multi-Dimensional Array:** Array of arrays (e.g., 2D matrices).
 *        int[][] matrix = new int[3][3];
 *  • **Jagged Array:** A special type of multi-dimensional array where
 *    each inner array can have a different length.
 *        int[][] jagged = new int[3][];
 *        jagged[0] = new int[2];
 *        jagged[1] = new int[4];
 *        jagged[2] = new int[3];
 *
 * -----------------------------------------------------------------------------
 * 7️⃣  Advantages:
 *  • Simple and efficient for storing a large number of elements.
 *  • Easy to access elements using index.
 *  • Memory-efficient compared to collections (no overhead).
 *
 * -----------------------------------------------------------------------------
 * 8️⃣  When to Use:
 *  • When the number of elements is fixed and known in advance.
 *  • When you need fast, index-based access to elements.
 *  • For primitive data processing, mathematical or matrix operations.
 *
 * -----------------------------------------------------------------------------
 * ✅  Tip:
 *  • For dynamic data handling, prefer Java Collections (e.g., ArrayList, HashSet)
 *    as they overcome most of the array’s limitations.
 *
 * =============================================================================
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02Array {
	static class P01ArrayEx01 {
		public P01ArrayEx01() {
			System.out.println("1-D array with Integer values");
			
			int[] array1 = {87, 54, 25};
			
			// printing array
			System.out.println(Arrays.toString(array1));
			
			// 1-D array for loop using lambda, available after java 5
			for(int item : array1) {
				System.out.print(item + " ");
			}
			System.out.println();
			
			
			
			System.out.println("\n1-D array with String values");
			
			String[] array2 = {"anurag", "nitish", "seema"};
			
			// printing array
			System.out.println(Arrays.toString(array2));
			
			// 1-D array for loop using lambda, available after java 5
			for(String item : array2) {
				System.out.print(item + " ");
			}
			System.out.println();
			
			
			
			System.out.println("\n2-D array with Integer values");
			
			int[][] array3 = {{53, 78, 94}, {32, 47}};
			
			for(int[] arr : array3) {
				for(int item : arr) {
					System.out.print(item + " ");
				}
			}
			System.out.println();
			
			
			
			System.out.println("\n1-D array declaration");
			
			int[] array4 = new int[3];
			
			array4[2] = 25;
			array4[0] = 35;

			System.out.println(Arrays.toString(array4));
			
			
			
			System.out.println("\n2-D array declaration");
			
			int[][] array5 = new int[3][2];
			
			array5[0][0] = 25;
			array5[0][1] = 35;
			array5[1][0] = 45;
			array5[1][1] = 55;
			array5[2][0] = 65;
			array5[2][1] = 75;
			
			for(int[] arr : array5) {
				for(int item : arr) {
					System.out.print(item + " ");
				}
			}
			System.out.println();
			
			
			
			System.out.println("\narray declaration with object");
			
			class P01ArrayEx01Student{
				String name;
				int age;
			}
			
			P01ArrayEx01Student[] array6 = new P01ArrayEx01Student[2];
			
			array6[0] = new P01ArrayEx01Student();
			array6[0].name = "anurag";
			array6[0].age = 28;
			
			array6[1] = new P01ArrayEx01Student();
			array6[1].name = "nitish";
			array6[1].age = 29;
			
			for(P01ArrayEx01Student item : array6) {
				System.out.println(item.name + " " + item.age);
			}
			
			
			
			System.out.println("\narray declaration with multiple objects");
			
			class P01ArrayEx01Byke{
				String brand;
				int cost;
			}
			
			Object[] array7 = new Object[2];
			
			array7[0] = new P01ArrayEx01Student();
			array7[1] = new P01ArrayEx01Byke();
			
			((P01ArrayEx01Student) array7[0]).name = "seema";
			((P01ArrayEx01Student) array7[0]).age = 30;
			((P01ArrayEx01Byke) array7[1]).brand = "bajaj";
			((P01ArrayEx01Byke) array7[1]).cost = 3000;
			
			P01ArrayEx01Student student = (P01ArrayEx01Student) array7[0];
			P01ArrayEx01Byke byke = (P01ArrayEx01Byke) array7[1];
			
			System.out.println("Student name is : " + student.name + " and age is : " + student.age);
			System.out.println("Bike brand is : " + byke.brand + " and cost is : " + byke.cost);
			
			
			
			System.out.println("\nsorting an array by pre-defined method");
			
			int[] array8 = {87, 67, 34, 99, 19};
			System.out.println("before sorting : " + Arrays.toString(array8));
			Arrays.sort(array8);
			System.out.println("after sorting : " + Arrays.toString(array8));
			
			
			
			System.out.println("\nsorting an array - selection sort");
			int[] array9 = {87, 67, 34, 99, 19};
			for(int i = 0; i < array9.length; i++) {
				for(int j = i + 1; j < array9.length; j++) {
					if(array9[i] > array9[j]) {
						int temp = array9[j];
						array9[j] = array9[i];
						array9[i] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(array9));
			
			
			
			System.out.println("\nsorting an array - bubble sort");
			int[] array10 = {87, 67, 34, 99, 19};
			for(int i = 0; i < array10.length - 1; i++) {
				for(int j = 0; j < array10.length - 1 - i; j++) {
					if(array10[j] > array10[j + 1]) {
						int temp = array10[j + 1];
						array10[j + 1] = array10[j];
						array10[j] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(array10));
			
			
			
			System.out.println("\nsorting an array - quick sort");
			List<Integer> array11 = new ArrayList<Integer>(Arrays.asList(87, 67, 34, 99, 19));
			System.out.println(arrayQuickSort(array11));
		}
		
		List<Integer> arrayQuickSort(List<Integer> arr) {
			if(arr.size() < 2){
	            return arr;
	        }
			
			List<Integer> left = new ArrayList<Integer>();
			List<Integer> right = new ArrayList<Integer>();
			int pivot = arr.get(arr.size() - 1);
			
			for(int i = 0; i < arr.size() - 1; i++) {
				if(arr.get(i) < pivot) {
					left.add(arr.get(i));
				} else {
					right.add(arr.get(i));
				}
			}
			
			List<Integer> sortedArr = new ArrayList<Integer>();
			sortedArr.addAll(arrayQuickSort(left));
			sortedArr.add(pivot);
			sortedArr.addAll(arrayQuickSort(right));
			
			return sortedArr;
		}
	}
	
	public static void main(String[] args) {
		new P01ArrayEx01();
	}
}
