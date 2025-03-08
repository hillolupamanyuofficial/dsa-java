package com.hillol.binary.search.concept;

import java.util.Arrays;
import java.util.concurrent.CancellationException;

/*
 *
 * Strictly sorted matrix
 */
public class BinarySearch2D {

    public static void main(String[] args) {

        /*
         *Matrix is sorted row-wise and column-wise,find the target
         */
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };


        System.out.println(Arrays.toString(search(arr, 12)));
    }

    private static int[] search(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length; //matrix might be empty

        if (row == 1) {
            return binarySearch(matrix, 0, 0, col, target);
        }
        int rStart = 0;
        int rEnd = row - 1;
        int cMid = col / 2;

        //run till two rows are remaining
        if (rStart < (rEnd - 1)) {
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }
            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        //now we have two rows
        //check whether target is in the col of two rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        //search in first half
        if (target < matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

        //search in second half
        if (target > matrix[rStart][cMid + 1] && target <= matrix[rStart][col - 1]) {   //should not lie in 4th half
            return binarySearch(matrix, rStart, cMid + 1, col - 1, target);
        }

        //search in third half
        if (target < matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } else {
            return binarySearch(matrix, rStart + 1, cMid + 1, col - 1, target);
        }

    }


    //search in the row provided
    private static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {

        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};                             //element not found inside array
    }
}
