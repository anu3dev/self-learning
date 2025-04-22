
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


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1,2,4,5,6,8);


        Predicate<Integer> condi = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                System.out.println("in test predicate");
                return x%2==0;
            }
        };




        Integer sum = nums.stream()
                .filter(condi)
                .map(x -> x*2)
                .reduce(0, (c, e) -> c + e);


        System.out.println(sum);



    }
}









