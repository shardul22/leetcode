package com.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/anagrams/
 * */
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return resultList;

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] stringArray = strs[i].toCharArray();
            Arrays.sort(stringArray);
            if (anagramMap.containsKey(String.valueOf(stringArray))) {
                anagramMap.get(String.valueOf(stringArray)).add(strs[i]);
            } else {
                List<String> anagramList = new ArrayList<>();
                anagramList.add(strs[i]);
                anagramMap.put(String.valueOf(stringArray), anagramList);
                resultList.add(anagramList);
            }
        }
        return resultList;
    }
}
