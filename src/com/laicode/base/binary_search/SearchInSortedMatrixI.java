package com.laicode.base.binary_search;

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
            int mid = left + (right - left) / 2;
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
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{ -1, -1 };
        }
        int rows = matrix.length; // 0~rows-1 is index
        int up = 0, down = rows - 1;
        while (up < down) { // target should fall in up row
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] <= target && matrix[mid + 1][0] > target) {
                int col = ClassicBinarySearch.binarySearch(matrix[mid], target);
                return new int[]{mid, col};
            } else if (matrix[mid][0] > target) {
                down = mid;
            } else {
                up = mid;
            }
        }
        return new int[]{ -1, -1 };
    }



    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,7},{8,9,10},{12,14,16}};
        System.out.println(matrix.length);
    }
}
