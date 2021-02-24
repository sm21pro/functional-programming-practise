package com.srikanth.functional.Functions;

import com.srikanth.functional.Functions.interfaces.NoArgFunction;

import java.util.function.Function;

public class F_ReturningFunctions {

    public static void main(String[] args) {
        // Ability to return Functions from other functions

        // So define a function that returns a function. How? NoArgFunction?

        NoArgFunction<NoArgFunction<String>> createPrinter = () -> {
            return () -> "Hello Function!";
        };

        // Can we written as
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> () -> "Hello Function!";
        NoArgFunction<String> greeter = createGreeter.apply();
        System.out.println(greeter.apply());

        // Read the class definition below before moving forward here

        // Create a function that does the multipliers dynamically rather than defining them
        Function<Integer, Integer> timesTwo = MyMath.createMultiplierFunction(2);
        Function<Integer, Integer> timesThree = MyMath.createMultiplierFunction(3);
        Function<Integer, Integer> timesFour = MyMath.createMultiplierFunction(4);

        // use them
        System.out.println(timesTwo.apply(2));
        System.out.println(timesThree.apply(2));
        System.out.println(timesFour.apply(2));
    }

    // Lets go a step beyond

    protected static class MyMath {
        public static Integer timesTwo(Integer num) {
            return num * 2;
        }

        public static Integer timesThree(Integer num) {
            return num * 2;
        }

        public static Integer timesFour(Integer num) {
            return num * 2;
        }

        // Different functions with only multiplier change.
        // Just think once variables and functions are same.

        // Now, we can write a Function that returns a function that applies the multiplier
        public static Function<Integer, Integer> createMultiplierFunction(Integer multiplier) {
            return (Integer x) -> x * multiplier;
        }

        // Go to main method to see how can we dynamically create the three functions above
    }


}
