package com.laicode.base.sorting_algo;

import com.laicode.base.util.HelperUtil;

import java.util.Arrays;

/*
Selection sort/Insertion sort. go over the array, compare each value with the rest of the array from left to right.
 */
public class SelectionSort {
    // in-place. O(n^2)
    private int[] solve(int[] array) {
        // null/empty
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                if (array[i] > array[j]) {
                    HelperUtil.swapIntArray(array, i, j);
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,2,3,-5,7};
        System.out.println(Arrays.toString(new SelectionSort().solve(array)));
    }
}
