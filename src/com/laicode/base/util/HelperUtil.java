package com.laicode.base.util;

import java.util.Arrays;

public class HelperUtil {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void swapIntArray(int[] array, int i, int j) {
        // swap two values in an array by index
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void swapCharArray(char[] array, int i, int j) {
        // swap two values in an array by index
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void reverseCharArray(char[] arr, int l, int r) {
        while (l < r) {
            char tmp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] arr = "abcd".toCharArray();
        reverseCharArray(arr, 0, 3);
        System.out.println(Arrays.toString(arr));
    }
}
