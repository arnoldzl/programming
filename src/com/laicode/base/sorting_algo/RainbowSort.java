package com.laicode.base.sorting_algo;

import com.laicode.base.util.HelperUtil;

import java.util.Arrays;

public class RainbowSort {
    /**
     * Red: -1, Blue: 0, Green: 1
     * [1,0,1,-1,0]  -> [-1,0,0,1,1]
     */
    public static int[] rainbowSort(int[] arr) {
        int i = 0, j = 0, k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == -1) {
                HelperUtil.swapIntArray(arr, i++, j++);
            } else if (arr[j] == 1) {
                HelperUtil.swapIntArray(arr, k--, j);
            } else {
                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ret = rainbowSort(new int[]{1,0,1,-1,0});
        System.out.println(Arrays.toString(ret));
    }
}
