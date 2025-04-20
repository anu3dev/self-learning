
// Data -> 3
// Data1 -> Data2 -> Data3 -> Data4

// FILTER, MAP, REDUCE
// Stream API - Java 8 - 2014
// Functional Programming
// Object oriented Programming

// obj = new A();       // doSomething(function1)
// go = function() {}   // doSomething(go)


// Mutation - Good
// Threads - Good
// Mutation + Threads = Bad
// Immutability + Thread = Amazing..

// i = 9
// j = i - 1


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(25,14,68,36,74,15);

//        Stream<Integer> stream1 = nums.stream();
//        Stream<Integer> stream2 = stream1.sorted();
//
//
//        Stream<Integer> stream3 = stream2.filter(x -> x%2==0);
//        Stream<Integer> stream4 = stream3.map(x -> x*2);
//
//        stream4.forEach(x -> System.out.println(x));

        nums.stream()
                .sorted()
                .filter(x -> x%2==0)
                .map(x -> x*2)
                .forEach(x -> System.out.println(x));


        System.out.println(nums);

    }
}









