package com.laicode.base.binary_search;

import java.util.Collection;
import java.util.Collections;

/*
Given a 2D matrix that contains integers only, which each row is sorted in an ascending order.
The first element of next row is larger than (or equal to) the last element of previous row.

Given a target number, returning the position that the target locates within the matrix.
If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:

The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.
Examples:

matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
 */
public class SearchInSortedMatrixI {

    static int[] search(int[][] matrix, int target) {
        // Consider 2D matrix as an array
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{ -1, -1 };
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0, right = cols * rows -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] searchII(int[][] matrix, int target) {
        // search row first, then search col
        int[] result = new int[]{ -1, -1 };
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = findRow(matrix, target);
        if (row == -1) {
            System.out.println("Not find");
            return result;
        }
        int col = findCol(matrix[row], target);
        if (col == -1) {
            System.out.println("Not find");
            return result;
        }
        result[0] = row;
        result[1] = col;
        return result;
    }

    private static int findRow(int[][] matrix, int target) {
        int up = 0, down = matrix.length - 1;
        while (up <= down) {
            int mid = (up + down) >>> 1;
            if (matrix[mid][0] <= target) {
                up = mid + 1;
            } else {
                down = mid - 1;
            }
        }
        return down;
    }

    private static int findCol(int[] array, int target) {
        return ClassicBinarySearch.binarySearch(array, target);
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,7},{8,9,10},{12,14,16}};
        System.out.println(matrix.length);
        System.out.println((1 + Integer.MAX_VALUE) >>> 1);
    }
}
