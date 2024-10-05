import java.util.Arrays;

/*
 * 
 * since array is an object, we can create from class as well.
 * 
 */

class Student {
	String name;
	int age;
}

class P02ArrayEx1 {
	P02ArrayEx1(){
		Student []sampleArray = new Student[1];
		
		System.out.println("sampleArray length: " + sampleArray.length);
		
		sampleArray[0] = new Student();
				
		sampleArray[0].name = "Rohan";
		sampleArray[0].age = 16;
		
		System.out.println(sampleArray[0].name);
		System.out.println(sampleArray[0].age);
	}
}

class Fan {
	String brand;
	int speed;
}

class Dog {
	String name;
	float price;
}

class P02ArrayEx2 {
	P02ArrayEx2(){
		
		Object []sampleArray = new Object[3];
		
		sampleArray[0] = new Student();
		sampleArray[1] = new Fan();
		sampleArray[2] = new Dog();
		
		for(int i = 0; i < sampleArray.length; i++) {
			System.out.println(sampleArray[i]);
		}
	}
}

/*
 * example of few default array method
 */
class P02ArrayEx3 {
	P02ArrayEx3(){
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


public class P02Array {
	public static void main(String[] args) {		
		//new P02ArrayEx1();
		
		//new P02ArrayEx2();
		
		//new P02ArrayEx3();
	}
}
