package com.hillol.binary.search.concept;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length;
        int mid = 0;

        //exit condition
        while (start <= end) {
            mid = start + (end - start) / 2; //stops integer overflow
            if (target == arr[mid]) {
                return mid;
            } else if (target < mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;                             //element not found inside array
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 13, 16, 23, 27, 32, 37};
        System.out.print(binarySearch(arr, 32));
    }
}
