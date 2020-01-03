package com.laicode.base.sorting_algo;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr) {

        // null check
        int len = arr.length;
        int[] tmp = new int[len];
        helper(arr, tmp, 0, len - 1);

        return arr;
    }

    static void helper(int[] arr, int[] tmp, int i, int j) {
        if (i >= j) return;
        int mid = i + (j - i) / 2;
        helper(arr, tmp, i, mid);
        helper(arr, tmp, mid + 1, j);
        merge(arr, tmp, i, mid, j);
    }


    /**
     * make arr[l] to arr[right] inclusive sorted
     * @param arr
     * @param tmp
     * @param l
     * @param mid
     * @param right
     */
    static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
        System.arraycopy(arr, left, tmp, left, right - left + 1);
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (tmp[l] < tmp[r]) arr[left++] = tmp[l++];
            else arr[left++] = tmp[r++];
        }
        while (l <= mid) {
            arr[left++] = tmp[l++];
        }
        // don't need copy r since r is already in the rest of array
        /*
        while (r <= right) {
            arr[left++] = tmp[r++];
        }
        */
    }

    public static void main(String[] args) {
        int[] retVal = MergeSort.sort(new int[]{3,5,1,2,4,8});
        System.out.println(Arrays.toString(retVal));
    }
}