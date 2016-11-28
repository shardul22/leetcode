package com.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    /**
     * The function below calculates two sum and returns result array containing numbers
     * @param nums number array to find sum
     * @param target target sum
     * @return result array containing elemtents
     */
    public int[] twoSum(int[] nums, int target) {

        /*
         * Steps to solve problem :-
         *
         * 1) Check the boundry conditions
         * 2) As the input array contains exactly on pair, add required sum and index i pair to map.
         * 3) If the required sum is present in the map then return result array with the values.
         */
        int[] resultArray = new int[2];
        if(nums == null || nums.length < 2)
            return resultArray;
        
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberMap.containsKey(nums[i])) {
                resultArray[0] = numberMap.get(nums[i]);
                resultArray[1] = i;
            }
            numberMap.put(target - nums[i], i);
        }
        return resultArray;
    }
}
