package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/permutations-ii/
 * */
public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if(nums== null || nums.length == 0)
			return resultList;
		Arrays.sort(nums);
		getPermutations(nums, new ArrayList<Integer>(), new HashSet<Integer>(), resultList);
		return resultList;
	}
	
	public void getPermutations(int[] nums, List<Integer> currentList,
			Set<Integer> indexSet, List<List<Integer>> resultList) {
		if(currentList.size() == nums.length) {
			resultList.add(new ArrayList<>(currentList));
			return;
		}
		for(int i=0; i<nums.length; i++) {
			
			if(!indexSet.contains(i)) {
				indexSet.add(i);
				currentList.add(nums[i]);
				getPermutations(nums, currentList, indexSet, resultList);
				currentList.remove(currentList.size()-1);
				indexSet.remove(i);
				
				while(i<nums.length-1 && nums[i] == nums[i+1])
					i++;
			}
		}
	}
}
