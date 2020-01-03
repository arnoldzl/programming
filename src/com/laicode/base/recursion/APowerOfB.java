package com.laicode.base.recursion;

/*
Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

Examples

power(2, 0) = 1
power(2, 3) = 8
power(0, 10) = 0
power(-2, 5) = -32
 */
public class APowerOfB {

    private static long power(int a, int b) {
        if (b == 0) return 1;
        if (a == 0) return 0;
        long res = power(a, b/2);
        res *= res;
        if (b % 2 != 0) {
            res *=a;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power(5, 2));
    }
}
