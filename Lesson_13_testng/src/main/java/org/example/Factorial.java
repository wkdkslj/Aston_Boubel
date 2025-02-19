package org.example;

public class Factorial {
    public static long factorial(int n) {
        long result = 1;

        if (n < 0) {
            throw new IllegalArgumentException("Negative numbersare not allowed");
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
