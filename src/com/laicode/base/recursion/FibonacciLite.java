package com.laicode.base.recursion;

public class FibonacciLite {

    private static int fib(int k) {
        // may overflow
        if (k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return fib(k - 2) + fib(k - 1);
    }

    private static int fib2(int k) {
        // initialize an array to store all result
        if (k <= 0) {
            return 0;
        }
        int[] result = new int[k + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= k; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[k];
    }

    private static int fib3(int k) {
        // we don't need to store whole array, all we need is just previous
        int a = 0, b = 1, temp = a+b;
        for (int i = 2; i <= k; i++) {
            temp = a + b; // 2
            a = b; // 1
            b =temp; // 2
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib2(5));
        System.out.println(fib3(5));
    }
}
