package com.laicode.base.util;

public class HelperUtil {

    public static void swapIntArray(int[] array, int i, int j) {
        // swap two values in an array by index
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
