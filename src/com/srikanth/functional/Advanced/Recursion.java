package com.srikanth.functional.Advanced;

import com.srikanth.functional.Functions.interfaces.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Recursion {

    // Observe that no actual for loop and mutation of data
    static void countDown(Integer x) {
        if(x < 0) {
            System.out.println("Done!");
            return;  // Very important stuff - to know and write where to stop the recursion
        }
        System.out.println(x);
        countDown(x - 1);
    }

    static void countUp(Integer x) {
        if(x > 10) {
            System.out.println("Done!");
            return;  // Very important stuff - to know and write where to stop the recursion
        }
        System.out.println(x);
        countUp(x + 1);
    }

    public static void main(String[] args) {
        countDown(10);
        countUp(0);

    }
}
