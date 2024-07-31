/*
 * in Java, array is trated as an object and hence memory allocated in heap area.
 * whenever we create object, we use new keyword and refrence variable.
 * int []ar = new int[5]; i.e. dataType []arrayName = new dataType[size]
 * array is an index based data structure to store large volume of homogenous 
 * type of data.
 * 
 * In Java, array is guarded with boundaries, howmuch memory we will ask,
 * Java will create, if we try to surpass then it will lead to 
 * arrayIndexOutOfBoundaryException.
 * 
 * major limitation of array: 
 * it can store only homogenious type of data
 * it demands contigous memory location
 * size is fixed, can't grow or shrink
 * if we try to change size then new array will be created
 * we don't have any direct class to work with data and array elemnets although 
 * we have utility class.
 * 
 * Jagged array is an array of different size of objects.
 */
package collectionInJava;

import java.util.Scanner;
import java.util.Arrays;

/*
 * create one dimentional array with fix size.
 */
class ArrayInJavaEx1 {
	@SuppressWarnings("resource")
	ArrayInJavaEx1() {
		
		int []arr = new int[5];
	
		Scanner scan = new Scanner(System.in);
	
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Enter markes of student " + i);
			arr[i] = scan.nextInt();
		}
		
		System.out.println("Marks of student as below: ");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}	
}

/*
 * create two dimentional array with fix size.
 */
class ArrayInJavaEx2 {
	@SuppressWarnings("resource")
	ArrayInJavaEx2() {
		
		int [][]arr = new int[5][5];
	
		Scanner scan = new Scanner(System.in);
	
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println("Enter markes of class " + i + " and student " + j);
				arr[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("Marks of student as below: ");
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}	
}

/*
 * create two dimentional jagged array with fix size.
 */
class ArrayInJavaEx3 {
	@SuppressWarnings("resource")
	ArrayInJavaEx3() {
		
		int [][]arr = new int[5][5];
		
		arr[0]=new int[4];
		arr[1]=new int[2];
		arr[2]=new int[3];
		arr[3]=new int[1];
		arr[4]=new int[5];
	
		Scanner scan = new Scanner(System.in);
	
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println("Enter markes of class " + i + " and student " + j);
				arr[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("Marks of student as below: ");
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}	
}

/*
 * below is an example of valid type of array creation
 */
class ArrayInJavaEx4 {
	ArrayInJavaEx4(){
		
		int ar[]=new int[3];
		
		/*
		 * below ex is wrong as array stores only homogenius type of data.
		 */
		//ar[0]=10;
		//ar[1]="Hyder";
				
		ar[0]=13;
		ar[1]=12;
		ar[2]=11;
		/*
		 * we can't store items in array more than its size as below.
		 */
		//ar[3]=20;
		
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		
		/*
		 * below is example of valid type of array creation.
		 */
		char ch1[]=new char[4];
		System.out.println(ch1.length);
		
		char ch2[]= {'t','a'};
		for(int i = 0; i < ch2.length; i++) {
			System.out.print(ch2[i] + " ");
		}
		
		String []st1=new String[4];
		System.out.println(st1.length);
		
		String st2[]= {"Navin Reddy","Hyder Abbas"};
		for(int i = 0; i < st2.length; i++) {
			System.out.print(st2[i] + " ");
		}
	}
}

class Student {
	String name;
	int age;
}

class ArrayInJavaEx5 {
	ArrayInJavaEx5(){
		Student []sampleArray=new Student[1];
		
		System.out.println(sampleArray.length);
		
		sampleArray[0]=new Student();
				
		sampleArray[0].name="Rohan";
		sampleArray[0].age=16;
		
		System.out.println(sampleArray[0].name);
		System.out.println(sampleArray[0].age);
	}
}

/*
 * since array is an object, we can create from class as well.
 */
class Fan {
	String brand;
	int speed;
}

class Dog {
	String name;
	float price;
}

class ArrayInJavaEx6 {
	ArrayInJavaEx6(){
		
		Object []sampleArray=new Object[3];
		
		sampleArray[0]=new Student();
		sampleArray[1]=new Fan();
		sampleArray[2]=new Dog();
		
		for(int i = 0; i < sampleArray.length; i++) {
		System.out.println(sampleArray[i]);
		}
	}
}

/*
 * example of 1-D enhanced or advance for loop, available after java 5.
 */
class ArrayInJavaEx7{
	ArrayInJavaEx7(){
		int arr[] = {10, 20, 30};
		
		for(int elem:arr) {
			System.out.print(elem + " ");
		}
	}
}

/*
 * example of 2-D enhanced or advance for loop.
 */
class ArrayInJavaEx8{
	ArrayInJavaEx8(){
		int arr[][] = {{15,25,35},{16, 26,36}};
		
		for(int a[]:arr) {
			for(int elem:a) {
				System.out.print(elem + " ");
			}
		}
	}
}

/*
 * example of few default array method
 */
class ArrayInJavaEx9 {
	ArrayInJavaEx9(){
		int ar1[][]= {{10,20,30},{1,2,3}};
		System.out.println(ar1.getClass().getName());
		
		int ar2[]=new int[3];
		System.out.println(ar2.getClass().getName());
		
		int ar3[]= {2,3,5,1,6,0};
		System.out.println("Before sorting");
		for(int ab:ar3){
			System.out.print(ab + " ");
		}
		System.out.println();
		
		Arrays.sort(ar3);
		System.out.println("After sorting");
		for(int ab:ar3){
			System.out.print(ab  + " ");
		}
	}
}


public class ArrayInJava {
	public static void main(String[] args) {
		new ArrayInJavaEx1();
		new ArrayInJavaEx2();
		new ArrayInJavaEx3();
		new ArrayInJavaEx4();
		new ArrayInJavaEx5();
		new ArrayInJavaEx6();
		new ArrayInJavaEx7();
		new ArrayInJavaEx8();
		new ArrayInJavaEx9();
	}
}
