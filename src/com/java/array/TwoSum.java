package com.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numberMap = new HashMap<>();
        int[] resultArray = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(numberMap.containsKey(nums[i])) {
            	resultArray[0] = numberMap.get(nums[i]);
            	resultArray[1] = i;
            }
        	numberMap.put(target - nums[i], i);
        }
        return resultArray;
	}

}
