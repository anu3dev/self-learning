/*
 * 
 * introduced in Java 8 in 2014
 * in object oriented programming, objects are first class citizen, same in Java, exp = new A();
 * in functional programming, functions are first class citizen, same in JavaScript, exp = function() {}
 * 
 * purpose of Stream API, Mutations are good in Java, Threads are good in Java, but Mutation + Threads are
 * not so efficient in Java, Immutability + Threads are amazing in Java
 * 
 */


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * 
 * example of Stream API ->
 * we can't re-use the Stream, once we use it then it will be passed to garbage collector
 * 
 */
class StreamAPIEx1{
	public StreamAPIEx1() {
		List<Integer> list = Arrays.asList(23, 34, 45, 12, 15);
		
		/*
		 * 
		 * by below code, Java tried to achieve functional programming
		 * 
		 */
		list.forEach(System.out::println);
				
		list.forEach(x -> System.out.println(x*5));
				
		/*
		 * 
		 * if we want to store the x*5 value then we can create a new list and store it.
		 * we can achieve the same using Stream.
		 * 
		 */
		Stream<Integer> stream = list.stream();
		stream.forEach(x -> System.out.println(x*5));
		
		/*
		 * 
		 * below code will through run time exception bcos if you used the stream then we can't re-use it.
		 * 
		 */
		//stream.sorted();
		//stream.forEach(x -> System.out.println(x*5));
	}
}

/*
 * 
 * If we want to re-use the stream then we have to create another stream using previous stream before
 * using the previous stream.
 * 
 */
class StreamAPIEx2{
	public StreamAPIEx2() {
		List<Integer> list = Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list.stream();
		Stream<Integer> stream2 = stream1.sorted();
		
		/*
		 * 
		 * below code will through run time exception, if you used the stream then we can't re-use it.
		 * used stream automatically passed to garbage collector.
		 * 
		 */
		//stream1.forEach(x -> System.out.println(x*2));
		
		stream2.forEach(x -> System.out.println(x*2));
	}
}

/*
 * 
 * we can also pass function to stream methods like below.
 * 
 */
class StreamAPIEx3{
	public StreamAPIEx3() {
		List<Integer> list = Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list.stream();
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
 * 
 * we can also pass the lambda expression to stream methods.
 * 
 */
class StreamAPIEx4{
	public StreamAPIEx4() {
		List<Integer> list = Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list.stream();
		Stream<Integer> stream2 = stream1.sorted();
		
		Stream<Integer> stream3 = stream2.map(x -> x*2);
		
		stream3.forEach(x -> System.out.println(x));
	}
}

/*
 * 
 * we can use multiple methods with stream as well.
 * 
 */
class StreamAPIEx5{
	public StreamAPIEx5() {
		List<Integer> list = Arrays.asList(23, 34, 45, 12, 15);
		
		Stream<Integer> stream1 = list.stream();
		Stream<Integer> stream2 = stream1.filter(x -> x%2 == 0).sorted();
				
		stream2.forEach(x -> System.out.println(x));
	}
}

/*
 * 
 * below is also an example of multiple methods with stream
 * 
 */
class StreamAPIEx6{
	public StreamAPIEx6() {
		List<Integer> list1= Arrays.asList(23, 34, 45, 12, 15);
		
		list1.stream()
			.sorted().filter(x -> x%2 == 0)
			.map(x -> x*3).forEach(x -> System.out.println(x));
	}
}

class StreamAPIEx7{
	public StreamAPIEx7() {
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

public class P06StreamAPI {
	public static void main(String[] args) {
		//new StreamAPIEx1();
				
		//new StreamAPIEx2();
				
		//new StreamAPIEx3();
				
		//new StreamAPIEx4();
								
		//new StreamAPIEx5();
				
		//new StreamAPIEx6();
		
		//new StreamAPIEx7();
	}
}
