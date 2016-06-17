package com.java.array;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations/
 * */
public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<>();
		if(nums == null || nums.length == 0)
			return resultList;
		
		getPermutations(0, new ArrayList<Integer>(), resultList, nums);
		return resultList;
	}
	
	public void getPermutations(int index, List<Integer> currentList, 
			List<List<Integer>> resultList, int[] nums) {
		if(currentList.size() == nums.length) {
			resultList.add(new ArrayList<Integer>(currentList));
			currentList = new ArrayList<>();
			return;
		}
		
		for(int i=0; i<nums.length; i++) {
			if(!currentList.contains(nums[i])) {
				currentList.add(nums[i]);
				getPermutations(0, currentList, resultList, nums);
				currentList.remove(currentList.size()-1);
			}
		}
	}
}
