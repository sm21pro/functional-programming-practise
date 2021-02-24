package com.srikanth.functional.Functions;

import java.util.function.Function;

public class A_FunctionInterface {

    protected static class MyMath {
        public static Integer triple(Integer x) {
            return x * 3;
        }
    }

    public static void main(String[] args) {
        // Assigning the function to a variable
        // Function generic types - Argument and return type

        // Notice that Function can allow only one argument
        Function<Integer, Integer> myTripleFunc = MyMath::triple;

        Integer result = myTripleFunc.apply(5);
        System.out.println(result);
    }
}
