package com.java.array;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    /**
     * The function merges two sorted array in result array (larger array in this case).
     * @param nums1 larger array
     * @param m length of the larger array
     * @param nums2 smaller array
     * @param n length of smaller array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        /*
         * Steps to solve problem :-
         *
         * 1) Start from the end of both of the array.
         * 2) Compare the two elements of the array and store it at the end.
         * 3) Decrement result index and store number index and continue further.
         * 4) If the index of larger array reaches to zero then copy the rest of the elements
         * of the array.
         *
         */

        // In this code i denotes number of elements in nums1 array.
        // j denotes number of elements in nums1 array.
        // k denotes length of result array which is nums1 in this case.
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            } else {
                if (j >= 0) {
                    while (j >= 0) {
                        nums1[k] = nums2[j];
                        j--;
                        k--;
                    }
                } else {
                    i--;
                }
            }
        }
    }
}
