package com.java.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-pattern-ii/
 * */
public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
		Map<Character, String> wordMap = new HashMap<>();
		Set<String> wordSet = new HashSet<>();
		return wordPatternHelper(pattern, str, wordMap, wordSet);
	}

	private boolean wordPatternHelper(String pattern, String wordString, 
			Map<Character, String> wordMap, Set<String> wordSet) {
		if(pattern.isEmpty())
			return wordString.isEmpty();
		if(wordMap.containsKey(pattern.charAt(0))) {
			String word = wordMap.get(pattern.charAt(0));
			if(wordString.length() < word.length() || !wordString.substring(0, word.length()).equals(word)) {
				return false;
			}
			if(wordPatternHelper(pattern.substring(1), wordString.substring(word.length()), wordMap, wordSet))
				return true;
		} else {
			for(int i=1; i<=wordString.length(); i++) {
				if(wordSet.contains(wordString.substring(0,i))) {
					continue;
				}
				wordSet.add(wordString.substring(0, i));
				wordMap.put(pattern.charAt(0), wordString.substring(0, i));
				if(wordPatternHelper(pattern.substring(1), wordString.substring(i), wordMap, wordSet))
					return true;
				wordMap.remove(pattern.charAt(0));
				wordSet.remove(wordString.substring(0, i));
			}
		}
		return false;
	}
}
