package com.laicode.base.sorting_algo;

/**
 * ABCDSwap
 * 
 */
public class ABCDSwap {

    /*
    swap A1B2C3D4 -> ABCD1234
    */
    public static String s1 = "ABCD1234";
    public static String s2 = "A1B2C3D4";

    public static void main(String[] args) {
        char[] res = swap1();
        System.out.println(new String(res));
    }

    // s1 -> s2
    public static char[] swap2() {
        
    }

    // s2 -> s1
    public static char[] swap1() {
        char[] s2Char = s2.toCharArray();
        char[] tmp = new char[s2Char.length];
        helper(s2Char, tmp, 0, s2Char.length - 1);
        return s2Char;
    }

    private static void helper(char[] arr, char[] tmp, int i, int j) {
        if (i >= j) {
            return;
        }
        int mid = i + (j - i) / 2;
        helper(arr, tmp, i, mid);
        helper(arr, tmp, mid + 1, j);
        System.out.println("I'm merging from " + i + " to " + j);
        merge(arr, tmp, i, mid, j);
    }

    private static void merge(char[] arr, char[] tmp, int left, int mid, int right) {
        System.arraycopy(arr, left, tmp, left, right - left + 1);
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (Character.isLetter(tmp[i])) arr[left++] = tmp[i++];
            else if (Character.isLetter(tmp[j])) arr[left++] = tmp[j++];
            else break;
        }
        while (i <= mid) {
            arr[left++] = tmp[i++];
        }
        System.out.println("Result array now is:" + new String(arr));
    }
}