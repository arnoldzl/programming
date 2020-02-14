package com.laicode.base.sorting_algo;


import com.laicode.base.util.HelperUtil;

import java.util.Arrays;

public class Move0ToEnd {

    /**
     * for a string, move all 0s to end
     */
    public static String moveToEndI(String input) {
        char[] arr = input.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            if (arr[i] == '0') {
                HelperUtil.swapCharArray(arr, i, j);
                j--;
            } else {
                i++;
            }
        }
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        System.out.println(moveToEndI("10203000"));
    }
}
