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
public class FirstOccurence {

    static int findFirstOccurence(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        return -1;
    }
}
