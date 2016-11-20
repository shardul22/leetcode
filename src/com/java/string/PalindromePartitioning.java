package com.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {

    public static void main(String args[]) {
        PalindromePartitioning p = new PalindromePartitioning();
        p.partition("aab");
    }

    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        if (s == null || s.length() == 0)
            return resultList;
        getPartitions(0, s, new ArrayList<String>(), resultList);
        return resultList;
    }

    public void getPartitions(int index, String s, List<String> currentList,
                              List<List<String>> resultList) {
        if (index == s.length()) {
            resultList.add(new ArrayList<>(currentList));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if (isPalindrome(stringBuilder)) {
                currentList.add(stringBuilder.toString());
                getPartitions(i + 1, s, currentList, resultList);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0)
            return false;

        int i = 0, j = stringBuilder.length() - 1;
        while (i < j) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
