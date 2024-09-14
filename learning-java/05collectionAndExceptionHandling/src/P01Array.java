/*
 * 
 * in Java, array is treated as an object and hence memory allocated in heap area.
 * whenever we create object, we use new keyword and reference variable.
 * 
 * int []ar = new int[5]; i.e. dataType []arrayName = new dataType[size]
 * 
 * array is an index based data structure to store large volume of homogeneous type of data.
 * 
 * In Java, array is guarded with boundaries, how much memory we will ask, Java will create.
 * if we try to surpass then it will lead to arrayIndexOutOfBoundaryException.
 * 
 * major limitations of array: 
 * it can store only homogeneous type of data
 * it demands contiguous memory location
 * size is fixed, can't grow or shrink
 * if we try to change size then new array will be created
 * we don't have any direct class to work with data and array elements although we have utility class.
 * 
 * Jagged array is an array of different size of objects.
 * 
 */

import java.util.Scanner;

/*
 * 
 * example of 1-D array for loop using lambda, available after java 5.
 * 
 */
class ArrayP01Ex1{
	ArrayP01Ex1(){
		int arr[] = {10, 20, 30};
		
		for(int elem:arr) {
			System.out.print(elem + " ");
		}
	}
}

/*
 * 
 * example of 2-D array for loop using lambda.
 * 
 */
class ArrayP01Ex2{
	ArrayP01Ex2(){
		int arr[][] = {{15,25,35},{16, 26,36}};
		
		for(int a[]:arr) {
			for(int elem:a) {
				System.out.print(elem + " ");
			}
		}
	}
}

/*
 * 
 * create one dimensional array with fix size.
 * 
 */
class ArrayP01Ex3 {
	@SuppressWarnings("resource")
	ArrayP01Ex3() {
		
		int []arr = new int[3];
	
		Scanner scan = new Scanner(System.in);
	
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Enter markes of student " + i);
			arr[i] = scan.nextInt();
		}
		
		System.out.println("Marks are: ");
		for(int elem:arr) {
			System.out.print(elem +" ");
		}
	}	
}

/*
 * 
 * create two dimensional array with fix size.
 * 
 */
class ArrayP01Ex4 {
	@SuppressWarnings("resource")
	ArrayP01Ex4() {
		
		int [][]arr = new int[3][3];
	
		Scanner scan = new Scanner(System.in);
	
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				int classVal = i+1;
				int studentval = j+1;
				System.out.println("Enter markes of class " + classVal + " and student " + studentval);
				arr[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("Marks are: ");
		for(int a[]:arr) {
			for(int elem:a) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}	
}

/*
 * 
 * create two dimensional jagged array with fix size.
 * 
 */
class ArrayP01Ex5 {
	@SuppressWarnings("resource")
	ArrayP01Ex5() {
		
		int [][]arr = new int[3][3];
		
		arr[0]=new int[2];
		arr[1]=new int[1];
		arr[2]=new int[3];
	
		Scanner scan = new Scanner(System.in);
	
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println("Enter markes of class " + i + " and student " + j);
				arr[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("Marks are: ");
		for(int a[]:arr) {
			for(int elem:a) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}	
}

/*
 * 
 * below is an example of valid type of array creation
 * 
 */
class ArrayP01Ex6 {
	ArrayP01Ex6(){
		
		int ar[] = new int[3];
		
		/*
		 * 
		 * below exp is wrong, array stores only homogeneous type of data.
		 * 
		 */
		//ar[0]=10;
		//ar[1]="Anurag";
				
		ar[0]=13;
		ar[1]=12;
		ar[2]=11;
		
		/*
		 * 
		 * we can't store items in array more than its size as below.
		 * 
		 */
		//ar[3]=20;
		
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		
		/*
		 * 
		 * below is example of valid type of array creation.
		 * 
		 */
		System.out.println();
		char ch1[] = new char[4];
		System.out.println(ch1.length);
		
		char ch2[] = {'t','a'};
		for(int i = 0; i < ch2.length; i++) {
			System.out.print(ch2[i] + " ");
		}
		
		System.out.println();
		String []st1 = new String[4];
		System.out.println(st1.length);
		
		String st2[] = {"Navin Reddy","Hyder Abbas"};
		for(int i = 0; i < st2.length; i++) {
			System.out.print(st2[i] + " ");
		}
	}
}

public class P01Array {
	public static void main(String[] args) {
		//new ArrayEx1();
		
		//new ArrayEx2();
		
		//new ArrayEx3();
		
		//new ArrayEx4();
		
		//new ArrayEx5();
		
		//new ArrayEx6();
	}
}
