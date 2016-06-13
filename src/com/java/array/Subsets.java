package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets/
 * */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		if(nums ==null ||nums.length == 0)
			return resultList;
		List<Integer> currentList = new ArrayList<>();
		Arrays.sort(nums);
		getSubsets(0, nums, currentList, resultList);
		return resultList;
	}

	private void getSubsets(int index, int[] numbersArray, 
			List<Integer> currentList, List<List<Integer>> resultList) {
		resultList.add(new ArrayList<Integer>(currentList));

		for(int i=index; i<numbersArray.length; i++) {
			currentList.add(numbersArray[i]);
			getSubsets(i+1, numbersArray, currentList, resultList);
			currentList.remove(currentList.size()-1);
		}
	}
}
