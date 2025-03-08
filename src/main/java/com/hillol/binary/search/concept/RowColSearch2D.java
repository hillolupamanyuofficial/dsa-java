package com.hillol.binary.search.concept;

import java.util.Arrays;


public class RowColSearch2D {

    public static void main(String[] args) {

        /*
         *Matrix is sorted row-wise and column-wise,find the target
         */
        int[][] arr = {
                {10, 20, 30, 40},
                {11, 25, 35, 45},
                {28, 29, 37, 41},
                {33, 34, 38, 50}
        };


        System.out.println(Arrays.toString(rowColSearch2d(arr, 37)));
    }

    // T.C. -> O(n) S.C -> O(1)
    private static int[] rowColSearch2d(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return new int[]{r,c};
            }else if(matrix[r][c] < target){
                r++;
            }else {
                c--;
            }
        }

        return new int[]{-1, -1};
    }

}
