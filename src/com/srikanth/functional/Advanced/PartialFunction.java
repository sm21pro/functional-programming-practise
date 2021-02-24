package com.srikanth.functional.Advanced;

import com.srikanth.functional.Functions.interfaces.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialFunction {

    public static void main(String[] args) {

        // A function with certain arguments
        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

        // Partial add function
        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                // Takes one argument - Could be split into 2 and 1. No limitation on Order of arguments or number of arguments to split
                (x) ->
                        // Return a function that takes rest of the arguments
                        (y, z) ->
                                // Once the function has all the arguments, apply the add function
                                add.apply(x, y, z);

        // Define a Partial Function - Fixing 5
        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);

        // Invoke a partial function
        System.out.println(add5.apply(4, 6));

        // Lets see currying
        currying();
    }

    private static void currying() {
        // Now, writing the same function but that takes argument one by one

        Function<Integer, Function<Integer, Function<Integer, Integer>>> addPartial = x -> y -> z -> x + y + z;

        Function<Integer, Function<Integer, Integer>> add5 = addPartial.apply(5);
        Function<Integer, Integer> add5and4 = add5.apply(4);
        Integer sum = add5and4.apply(6);

        System.out.println(sum);
    }
}
