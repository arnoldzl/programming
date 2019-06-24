package com.laicode.base.binary_search;

/*
Given a target integer T and an integer array A sorted in ascending order,
find the index i in A such that A[i] is closest to T.

Assumptions

There can be duplicate elements in the array, and we can return any of the indices with same value.
Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 4, 6}, T = 3, return 1
A = {1, 4, 6}, T = 5, return 1 or 2
A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
Corner Cases

What if A is null or A is of zero length? We should return -1 in this case.
 */
public class ClosestInSortedArray {

    static int[] findClosestLeftAndRight(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = (left + right) >>> 1;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return new int[]{left, right};
    }

    static int closest(int a, int b, int[] array, int target) {
        if ((target - array[a]) <= array[b] - target) {
            return a;
        } else {
            return b;
        }
    }

    static int findClosest(int[] array, int target) {
        // closest, return left and right. check which is smaller
        if (array == null || array.length == 0) {
            return -1;
        }
        int[] closestTwoIndex = findClosestLeftAndRight(array, target);
        return closest(closestTwoIndex[0], closestTwoIndex[1], array, target);
    }

    public static void main(String[] args) {
        System.out.println(findClosest(new int[]{1,2,6,8}, 3));
    }
}
