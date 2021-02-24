package com.srikanth.functional.Functions;

import com.srikanth.functional.Functions.interfaces.NoArgFunction;

public class G_Closure {
    // Define a function that returns a function
    // But the returned function still has access to internal scope of the function that returned it

    public static void main(String[] args) {

        // A function that returns another function that uses a property of parent function
        NoArgFunction<NoArgFunction<String>> createGreeter = () -> {
            String name = "Srikanth!";
            return () -> "Hello, " + name;
        };

        NoArgFunction<String> greeter = createGreeter.apply();

        // looks simple. But look closely. The line above returned a function to main scope
        // And when you apply, the greeter function still has access to the name property of createGreeter
        System.out.println(greeter.apply());
    }
}
