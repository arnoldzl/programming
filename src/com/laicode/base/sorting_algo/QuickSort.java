package com.laicode.base.sorting_algo;

import java.util.Arrays;

import com.laicode.base.util.HelperUtil;

/**
 * QuickSort
 */
public class QuickSort {

    public static int[] sort(int[] arr) {
        // null check
        helper(arr, 0, arr.length - 1);
        return arr;
    }

    public static void helper(int[] arr, int i, int j) {
        if (i >=j) return;
        int pivot = partition(arr, i, j);
        helper(arr, i, pivot - 1);
        helper(arr, pivot + 1, j);
    }

    static int chooseRandomPivot(int left, int right) {
        return left + (int)(Math.random() * (right - left + 1));
    }

    // return pivot index
    public static int partition(int[] arr, int left, int right) {
        int pivotIndex = chooseRandomPivot(left, right);
        int pivotVal = arr[pivotIndex];
        HelperUtil.swapIntArray(arr, pivotIndex, right);
        int i = left, j = right -1;
        while (i <= j) {
            if (arr[i] < pivotVal) i++;
            else if (arr[j] > pivotVal) j--;
            else HelperUtil.swapIntArray(arr, i++, j--);
        }
        // can guarantee index i is larger than pivot
        HelperUtil.swapIntArray(arr, i, right);
        return i;
    }

    public static void main(String[] args) {
        int[] retVal = sort(new int[]{3,5,1,2,4,8});
        System.out.println(Arrays.toString(retVal));
    }
}