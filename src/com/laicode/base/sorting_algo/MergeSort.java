package com.laicode.base.sorting_algo;

import java.util.Arrays;

public class MergeSort {

    private int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] helper = new int[array.length];
        helper(array, helper, 0, array.length - 1);
        return array;
    }

    private void helper(int[] array, int[] helper, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = i + (j - i) / 2;
        helper(array, helper, i, mid);
        helper(array, helper, mid + 1, j);
        merge(array, helper, i, mid, j);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        // put all elements in helper array
        if (right + 1 - left >= 0) System.arraycopy(array, left, helper, left, right + 1 - left);
        // merge
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (helper[l] < helper[r]) {
                array[left++] = helper[l++];
            } else {
                array[left++] = helper[r++];
            }
        }
        while (l <= mid) {
            array[left++] = helper[l++];
        }
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] retVal = ms.sort(new int[]{3,5,1,2,4,8});
        System.out.println(Arrays.toString(retVal));
    }
}
