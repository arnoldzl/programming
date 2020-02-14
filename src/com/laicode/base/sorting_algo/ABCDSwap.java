package com.laicode.base.sorting_algo;

import com.laicode.base.util.HelperUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // char[] res = swap1();
        char[] res = swap21();
        System.out.println(new String(res));
    }

    // s1 -> s2
    public static char[] swap2() {
        char[] s1Char = s1.toCharArray();
        if (s1Char.length % 2 == 0) {
            reorder(s1Char, 0, s1Char.length - 1);
        } else {
            reorder(s1Char, 0, s1Char.length - 2);
        }
        return s1Char;
    }

    private static void reorder(char[] arr, int l, int r) {
        // calculate 3 mid points
        int length = r - l + 1;
        if (length <= 2) {
            return;
        }
        int mid = l + length / 2;
        int lMid = l + length / 4;
        int rMid = l + length * 3 / 4;
        HelperUtil.reverseCharArray(arr, lMid, mid - 1);
        HelperUtil.reverseCharArray(arr, mid, rMid - 1);
        HelperUtil.reverseCharArray(arr, lMid, rMid - 1);

        // recursive call left and right side
        // need to match left side and right side size. left size is (lmid - l) * 2
        reorder(arr, l, l + (lMid - l) * 2 - 1);
        reorder(arr, l + (lMid - l) * 2, r);
    }

    public static char[] swap21() {
        char[] arr = s1.toCharArray();
        int len = arr.length;
        if (( (len & (len - 1) )) !=0 ) {
            return null;
        }
        Map<Integer, Integer> idMap = new HashMap<>();
        int i = 0;
        while (i < len) {
            idMap.put(i, (i >>> 1 | i << ((int)(Math.log(len)/Math.log(2)) - 1)) & (len - 1));
            i ++;
        }
        char[] ret = new char[len];
        for (int j = 0; j < s1.length(); j++) {
            ret[j] = arr[idMap.get(j)];
        }
        return ret;
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