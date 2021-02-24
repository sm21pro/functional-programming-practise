package com.srikanth.functional.Functions;

import java.util.function.BiFunction;

public class E_FunctionsAsArgs {

    // Passed arguments to functions so far
    // What if we pass behaviour to be applied on data?

    protected static class MyMath {
        public static Integer add(Integer x, Integer y) {
            return x + y;
        }

        public static Integer subtract(Integer x, Integer y) {
            return x - y;
        }

        // Takes a function as input and applies it on hardcoded data (2 and 3 for demo purpose)
        public static Integer compute2And3(BiFunction<Integer, Integer, Integer> combineFunc) {
            return combineFunc.apply(2, 3);
        }

    }

    public static void main(String[] args) {

        // Pass the behaviour we want to apply

        System.out.println(MyMath.compute2And3(MyMath::add));
        System.out.println(MyMath.compute2And3(MyMath::subtract));

        // Or define your own behaviour as lambda function
        System.out.println(MyMath.compute2And3((x, y) -> 2 * x + 2 * y));
    }

}
