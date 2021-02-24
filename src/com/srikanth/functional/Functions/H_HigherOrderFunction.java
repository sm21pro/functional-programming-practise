package com.srikanth.functional.Functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class H_HigherOrderFunction {

    // Higher Order functions are those that takes Function as input and returns function as output

    public static void main(String[] args) {

        // Define a BiFunction that takes two integers and returns quotient

        BiFunction<Float, Float, Float> divide = (x, y) -> x / y;

        // This BiFunction has a danger of divide by zero error.
        // But validating it inside violates the rule of maintaining one responsibility
        // So wrap it up with higher order function

        // A Function that takes the BiFunction above and returns a safe behavior

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> zeroDivideCheck =
                // Again, takes a function and returns a function that takes 2 args
                (func) -> (x, y) -> {
                    if (y == 0f) {
                        System.err.println("Error: Denominator cannot be zero");
                        return 0f;
                    }
                    // return original bifunction "behaviour" after validation. Meaning return the result
                    return func.apply(x, y);
                };

        // Now create a new safeDivide version of the original divide
        BiFunction<Float, Float, Float> safeDivide = zeroDivideCheck.apply(divide);

        System.out.println(safeDivide.apply(2f, 0f));
        System.out.println(safeDivide.apply(4f, 2f));
    }


}
