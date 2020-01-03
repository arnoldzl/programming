package com.laicode.base.binary_search;

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
        int left = largestSmallest(array, target);
        int right = left + 1;
        for (int i = 0; i < k; i++) {
            // left-- condition: right > array.length -1 or left >= 0 and (target - a[left]) < (a[right] - target)
            if (right >= array.length || left >= 0 && (target - array[left]) < (array[right] - target)) {
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }

    static int largestSmallest(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right - 1) {
            int mid = (left + right) >>> 1;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[right] <= target) {
            return right;
        } else if (array[left] <= target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] result = kClosest(new int[]{1,2,2,2,2,2}, 1, 2);
        int result = largestSmallest(new int[]{1,2,2,2,2}, 2);
//        for (int i: result) {
//            System.out.print(i + " ");
//        }
        System.out.println(result);
    }
}
