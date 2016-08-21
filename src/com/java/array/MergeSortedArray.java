package com.java.array;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// In this code i denotes number of elements in nums1 array.
		// j denotes number of elements in nums1 array.
		// k denotes length of result array which is nums1 in this case.  
		int i = m-1, j = n-1, k = nums1.length - 1;
		while(i >= 0 || j >= 0) {
			if(i >= 0 && j >= 0) {
				if(nums1[i] > nums2[j]) {
					nums1[k] = nums1[i];
					i--;
				} else {
					nums1[k] = nums2[j];
					j--;
				}
				k--;
			} else {
				if(j >=0) {
					while(j >= 0) {
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
