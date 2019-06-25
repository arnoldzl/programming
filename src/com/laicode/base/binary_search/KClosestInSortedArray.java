package com.laicode.base.binary_search;

import java.util.Arrays;

/*
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order,
find the K closest numbers to T in A.

Assumptions

A is not null
K is guaranteed to be >= 0 and K is guaranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A,
sorted in ascending order by the difference between the number and T.
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
 */
public class KClosestInSortedArray {

    static int[] kClosest(int[] array, int k, int target) {
        // find target's index in O(log n), find k in O(k)
        int[] result = new int[k];
        int[] closestIndex = ClosestInSortedArray.findClosestLeftAndRight(array, target);
        int i = closestIndex[0], j = closestIndex[1];
        int l = 0;
        if (k == 1) {
            result[0] = array[i];
            return result;
        }
        while ((j - i + 1) < k) {
            if (j >= array.length || i > 0 && ((target - array[i]) <= (array[j] - target)) ) {
                result[l++] = array[i--];
            } else {
                result[l++] = array[j++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = kClosest(new int[]{1,5}, 1, 0);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }
}
