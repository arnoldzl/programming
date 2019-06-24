package com.laicode.base.binary_search;

/*
Given a target integer T and an integer array A sorted in ascending order,
find the index of the first occurrence of T in A or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array.
Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 1
Corner Cases

What if A is null or A of zero length? We should return -1 in this case.
 */
public class FindOccurence {

    static int findFirstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0, r = array.length - 1;
        while (l < r - 1) {
            // return left and right.
            int mid = (l + r) >>> 1;
            if (array[mid] >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        // 5 cases:
        // 1. only one element in array
        // 2. only two elements in array
        // 3. left == right -1, left is the result
        // 4. left == right -1, right is the result
        // 5. left == right -1, no result
        if (array[l] == target) {
            return l;
        } else if (array[r] == target) {
            return r;
        }
        return -1;
    }

    static int findLastOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int l = 0, r = array.length - 1;
        while (l < r - 1) {
            // return left and right.
            int mid = (l + r) >>> 1;
            if (array[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        // 5 cases:
        // 1. only one element in array
        // 2. only two elements in array
        // 3. left == right -1, left is the result
        // 4. left == right -1, right is the result
        // 5. left == right -1, no result
        if (array[r] == target) {
            return r;
        } else if (array[l] == target) {
            return l;
        }
        return -1;
    }
}
