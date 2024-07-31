/*
 * introduced in Java 8 in 2014
 * 
 * in object oriented programming -> objects are first class citizen like in Java
 * ex = new A();
 * 
 * in functional programming -> functions are first class citizen like in JavaScript
 * ex = function() {}
 * 
 * purpose of Stream API
 * Mutation -> Good
 * Threads -> Good
 * Mutation + Threads -> Bad
 * Imutability + Threads -> Amazing
 */
package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * example of Stream API
 * we can't re-use the Stream, once we use it then it will b epassed to garbage collector
 */
class StreamAPIInJavaEx1{
	public StreamAPIInJavaEx1() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		/*
		 * by below code, Java kind of tried acieveing functional programming
		 */
		list1.forEach(System.out::println);
		
		System.out.println("###################");
		
		list1.forEach(x -> System.out.println(x*5));
		
		System.out.println("###################");
		
		/*
		 * if we want to store the x*5 value then we can create a new list and store 
		 * but we can do also using Stream
		 */
		Stream<Integer> stream1 = list1.stream();
		stream1.forEach(x -> System.out.println(x*5));
		
		/*
		 * below code will through run time exception
		 * means if you used the stream then we can't re-use it.
		 */
		//stream1.sorted();
		//stream1.forEach(x -> System.out.println(x*5));
	}
}

/*
 * If we want to re-use the stream then we have to create another stream using previous stream before
 * using the previous stream
 */
class StreamAPIInJavaEx2{
	public StreamAPIInJavaEx2() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list1.stream();
		Stream<Integer> stream2 = stream1.sorted();
		
		/*
		 * below code will through run time exception
		 * means if you used the stream then we can't re-use it.
		 * used stream automatically passed to garbage collector
		 */
		//stream1.forEach(x -> System.out.println(x*2));
		
		stream2.forEach(x -> System.out.println(x*2));
	}
}

/*
 * we can pass function to stream methods like below
 */
class StreamAPIInJavaEx3{
	public StreamAPIInJavaEx3() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list1.stream();
		Stream<Integer> stream2 = stream1.sorted();
		
		Function<Integer, Integer> func = new Function<>() {
			public Integer apply(Integer x) {
				return x*2;
			}
		};
		
		Stream<Integer> stream3 = stream2.map(func);
		
		stream3.forEach(x -> System.out.println(x));
	}
}

/*
 * we can also pass the lambda expression to stream methods
 */
class StreamAPIInJavaEx4{
	public StreamAPIInJavaEx4() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list1.stream();
		Stream<Integer> stream2 = stream1.sorted();
		
		Stream<Integer> stream3 = stream2.map(x -> x*2);
		
		stream3.forEach(x -> System.out.println(x));
	}
}

/*
 * we can use multiple methods with stream as well
 */
class StreamAPIInJavaEx5{
	public StreamAPIInJavaEx5() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list1.stream();
		
		Stream<Integer> stream2 = stream1.filter(x -> x%2 == 0).sorted();
				
		stream2.forEach(x -> System.out.println(x));
	}
}

/*
 * below is also an example of multiple methods with stream
 */
class StreamAPIInJavaEx6{
	public StreamAPIInJavaEx6() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		list1.stream()
			.sorted().filter(x -> x%2 == 0)
			.map(x -> x*3).forEach(x -> System.out.println(x));
	}
}

class StreamAPIInJavaEx7{
	public StreamAPIInJavaEx7() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		Predicate<Integer> cond1 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				System.out.println("in test predicate");
				return x % 2 == 0;
			}
		};
		
		list1.stream()
			.sorted().filter(cond1)
			.map(x -> x*3).forEach(x -> System.out.println(x));
	}
}

public class StreamAPIInJava {
	public static void main(String[] args) {
		new StreamAPIInJavaEx1();
		
		System.out.println("1******************");
		
		new StreamAPIInJavaEx2();
		
		System.out.println("2******************");
		
		new StreamAPIInJavaEx3();
		
		System.out.println("3******************");
		
		new StreamAPIInJavaEx4();
		
		System.out.println("4******************");
		
		new StreamAPIInJavaEx4();
		
		System.out.println("5******************");
		
		new StreamAPIInJavaEx5();
		
		System.out.println("6******************");
		
		new StreamAPIInJavaEx6();
	}
}
