package com.java.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-break-ii/
 * */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		Map<String, List<String>> wordMap = new HashMap<>();
		return wordBreakHelper(s, wordDict, wordMap);
	}
	private List<String> wordBreakHelper(String wordString, Set<String> wordDict, Map<String, List<String>> wordMap) {
		List<String> resultList = new ArrayList<>();
		if(wordMap.containsKey(wordString))
			resultList.add(wordString);
		for(int i=1; i<=wordString.length(); i++) {
			String word = wordString.substring(0, i);
			if(wordDict.contains(word)) {
				List<String> wordList = wordBreakHelper(wordString.substring(i), wordDict, wordMap);
				for(String temp : wordList) {
					resultList.add(word + " " + temp);
				}
			}
		}
		wordMap.put(wordString, resultList);
		return resultList;
	}
}
