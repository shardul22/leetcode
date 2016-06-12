package com.java.binarysearch;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * */
public class SearchInRotatedSortedArray {
	
	public int search(int[] nums, int target) {

		if(nums == null || nums.length == 0)
			return -1;
		return searchHelper(0, nums.length-1, nums, target);
	}
	
	private int searchHelper(int start, int end, int[] nums, int target) {
		if(start <= end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target) {
				return mid;
			}
			
			if(nums[start] <= nums[mid]) {
				if(nums[start] <= target && target < nums[mid]) {
					return searchHelper(start, mid - 1, nums, target);
				}
				return searchHelper(mid + 1, end, nums, target);
			} else {
				if(nums[mid] < target && target <= nums[end]) {
					return searchHelper(mid + 1, end, nums, target);
				}
				return searchHelper(start, mid - 1, nums, target);
			}
		}
		return -1;
	}
}
