/**
 * Array- 
 * Collection of same type of value with fixed size.
 * Each value is indexed and can be found by its respective position.
 * First index is 0 and last index is length of array minus 1.
 */

class DSA02ArrayEx1 {
	/**
	 * Declaration of array like below
	 */
	int arr1[];
	int[] arr2; // mostly used
	
	String arr3[];
	String[] arr4; // mostly used
	
	/**
	 * Declaration and initialization of array
	 */
	int arr5[] = new int[5];
	int[] arr6 = new int[5];
	
	
	/**
	 * Adding or updating elements in an array
	 */
	public void arrayDemo() {
		int[] arrDemo = new int[4];
		arrDemo[0] = 5;
		arrDemo[2] = 7;
		arrDemo[1] = 8;
		System.out.println(arrDemo[2]); // o/p -> 7
		
		System.out.println(arrDemo.length); // o/p -> 4
		
		arrDemo[2] = 3;
		System.out.println(arrDemo[2]);  // o/p -> 3
		
		//arrDemo[5] = 9; 
		// java.lang.ArrayIndexOutOfBoundException: index 3 is out of bound for length 3
	}
	
	public void printArr(int[] arrDemo) {
		for(int i = 0; i < arrDemo.length; i++) {
			System.out.println("index is " +i+ " and value is "+arrDemo[i]);
		}
	}
	
	public void removeEvenNumberFromArray(int[] arrDemo) {
		int oddcount = 0;
		for(int i = 0; i < arrDemo.length; i++) {
			if(arrDemo[i] % 2 != 0) {
				oddcount++;
			}
		}
		
		int[] result = new int[oddcount];
		
		int idx = 0;
		for(int i = 0; i < arrDemo.length; i++) {
			if(arrDemo[i] % 2 != 0) {
				result[idx] = arrDemo[i];
				idx++;
			}
		}
		printArr(result);
	}
	
	public void reverseArrayAsPerStartAndEndIndex(int[] arrDemo, int start, int end) {
		while(start < end) {
			int temp = arrDemo[start];
			arrDemo[start] = arrDemo[end];
			arrDemo[end] = temp;
			start++;
			end--;
		}
		printArr(arrDemo);
	}
	
	public void findMinimumValueInArray(int[] arrDemo) {
		int min = arrDemo[0];
		for(int i = 1; i < arrDemo.length; i++) {
			if(arrDemo[i] < min) {
				min = arrDemo[i];
			}
		}
		System.out.println("min value is " +min);
	}
	
	public void findSecondMaxValueInArray(int[] arrDemo) {
		int maxVal = Integer.MIN_VALUE;
		int secondMaxVal = Integer.MIN_VALUE;
		
		for(int i = 0; i < arrDemo.length; i++) {
			if(arrDemo[i] > maxVal) {
				secondMaxVal = maxVal;
				maxVal = arrDemo[i];
			} else if(arrDemo[i] > secondMaxVal && arrDemo[i] != maxVal) {
				secondMaxVal = arrDemo[i];
			}
		}
		System.out.println("Second max value is " +secondMaxVal);
	}
	
	public void moveAllZeroToEndOfArray(int[] arrDemo) {
		// solution 1
		int j = 0;
		
		for(int i = 0; i < arrDemo.length; i++) {
			if(arrDemo[i] != 0 && arrDemo[j] == 0) {
				int temp = arrDemo[i];
				arrDemo[i] = arrDemo[j];
				arrDemo[j] = temp;
			}
			if(arrDemo[j] != 0) {
				j++;
			}
		}
		printArr(arrDemo);
		
		// solution 2
		System.out.println();
		int[] tempArr = new int[arrDemo.length];
		int arrIndex = 0;
		
		for(int i = 0; i < arrDemo.length; i++) {
			if(arrDemo[i] > 0) {
				tempArr[arrIndex] = arrDemo[i];
				arrIndex++;
			}
		}
		arrDemo = tempArr;
		printArr(arrDemo);
	}
	
	public void resizeAnArray(int[] arrDemo, int capacity) {
		int[] tempArr = new int[capacity];
		
		for(int i = 0; i < arrDemo.length; i++) {
			tempArr[i] = arrDemo[i];
		}
		arrDemo = tempArr;
		printArr(arrDemo);
	}
	
	public void findMissingNumberFromArray(int[] arrDemo) {
		int n = arrDemo.length + 1;
		int sum = n*(n + 1) / 2;
		int missingNum = 0;
		
		for(int i = 0; i < arrDemo.length; i++) {
			sum = sum - arrDemo[i];
			missingNum = sum;
		}
		System.out.println("Missing no is " +missingNum);
	}
}

public class DSA02Array {
	public static void main(String[] args) {
		DSA02ArrayEx1 arr = new DSA02ArrayEx1();
		
		System.out.println("\n\nIntro of an array:-");
		arr.arrayDemo();
		
		System.out.println("\n\nPrint an array:-");
		int[] arrDemo1 = {4, 6, 9, 13};
		arr.printArr(arrDemo1);
		
		System.out.println("\n\nRemove even number from an array:-");
		int[] arrDemo2 = {3,2,4,7,10,6,5};
		arr.removeEvenNumberFromArray(arrDemo2);
		
		System.out.println("\n\nReverse part of an array on basis of start and end index:-");
		int[] arrDemo3 = {2,11,5,10,7,8};
		arr.reverseArrayAsPerStartAndEndIndex(arrDemo3, 0, 4);
		
		System.out.println("\n\nFind min value in an array");
		int[] arrDemo4 = {5,9,3,15,1,2};
		arr.findMinimumValueInArray(arrDemo4);
		
		System.out.println("\n\nFind second max value in an array:-");
		int[] arrDemo5 = {12,34,2,34,33,1};
		arr.findSecondMaxValueInArray(arrDemo5);
		
		System.out.println("\n\nMove all zero value to last of an array:-");
		int[] arrDemo6 = {8,1,0,2,1,0,3};
		arr.moveAllZeroToEndOfArray(arrDemo6);
		
		System.out.println("\n\nResize an existing array to n count:-");
		int[] arrDemo7 = {8,1,9,2};
		arr.resizeAnArray(arrDemo7, 9);
		
		System.out.println("\n\nFind missing number of n - 1 distinct numbers in the range of 1 to n:-");
		int[] arrDemo8 = {2,4,1,8,6,3,7};
		arr.findMissingNumberFromArray(arrDemo8);
	}
}
