package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * */
public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return resultList;
		Arrays.sort(nums);
		getSubsets(0, new ArrayList<Integer>(), nums, resultList);
		return resultList;
	}

	private void getSubsets(int index, List<Integer> currentList, 
			int[] nums, List<List<Integer>>  resultList) {
		resultList.add(new ArrayList<Integer>(currentList));
		
		for(int i=index; i<nums.length; i++) {
			currentList.add(nums[i]);
			getSubsets(i+1, currentList, nums, resultList);
			currentList.remove(currentList.size()-1);
			
			while(i<nums.length-1 && nums[i] == nums[i+1]) {
				i++;
			}
		}
	}
}
