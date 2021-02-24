package com.srikanth.functional.Functions;

import com.srikanth.functional.Functions.interfaces.NoArgFunction;
import com.srikanth.functional.Functions.interfaces.TriFunction;

import java.util.function.BiFunction;

public class C_BiFunctions {

    public static void main(String[] args) {

        // BiFunction unlike Function takes 2 arguments
        BiFunction<Integer, Integer, Integer> sumOf = (x, y) -> x + y;
        System.out.println(sumOf.apply(3, 5));

        // How about functions for greater than 2 arguments?
        // Implement own interface - Refer to interfaces package

        TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
        System.out.println(addThree.apply(2, 3, 4));

        NoArgFunction<String> sayHello = () -> "Hello!";
        System.out.println(sayHello.apply());

    }
}
