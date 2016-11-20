package com.java.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-pattern/
 * */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        if (str == null || pattern == null)
            return false;

        String[] stringTokens = str.split(" ");
        int patternLength = pattern.length();
        if (patternLength != stringTokens.length)
            return false;

        Map<Character, String> wordMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < patternLength; i++) {
            if (wordMap.containsKey(pattern.charAt(i))) {
                if (!wordMap.get(pattern.charAt(i)).equals(stringTokens[i]))
                    return false;
            } else {
                if (!wordSet.add(stringTokens[i]))
                    return false;
                wordMap.put(pattern.charAt(i), stringTokens[i]);
            }
        }
        return true;
    }
}
