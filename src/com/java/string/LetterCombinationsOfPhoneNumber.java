package com.java.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * */
public class LetterCombinationsOfPhoneNumber {

public List<String> letterCombinations(String digits) {
		
		Map<Character, String> numberMap = new HashMap<>();
		numberMap.put('2', "abc");
		numberMap.put('3', "def");
		numberMap.put('4', "ghi");
		numberMap.put('5', "jkl");
		numberMap.put('6', "mno");
		numberMap.put('7', "pqrs");
		numberMap.put('8', "tuv");
		numberMap.put('9', "wxyz");

		List<String> resultList = new ArrayList<>();
		if(digits == null || digits.length() == 0)
			return resultList;
		
		getCombinations(digits, 0, new StringBuilder(""), resultList, numberMap);
		return resultList;
	}
	
	public void getCombinations(String digits, int nextDigitIndex ,StringBuilder stringBuilder, 
			List<String> resultList, Map<Character, String> numberMap) {
		if(stringBuilder.length()== digits.length()) {
			resultList.add(stringBuilder.toString());
			return;
		}
		
		String numberString = numberMap.get(digits.charAt(nextDigitIndex));
		for(int i=0; i<numberString.length(); i++) {
			stringBuilder.append(numberString.charAt(i));
			getCombinations(digits, nextDigitIndex+1, stringBuilder, resultList, numberMap);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
	}

}
