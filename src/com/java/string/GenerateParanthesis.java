package com.java.string;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/
 * */
public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {
		List<String> resultList = new ArrayList<>();
		if(n <= 0) {
			return resultList;
		}
		
		generate(0, 0, n, new StringBuilder(""), resultList);
		return resultList;

	}
	
	private void generate(int open, int close, int n, StringBuilder stringBuilder, List<String> resultList) {
		if(open == n && close == n) {
			resultList.add(stringBuilder.toString());
			return;
		}
		
		if(open < n) {
			stringBuilder.append("(");
			generate(open+1, close, n, stringBuilder, resultList);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		
		if(close < open) {
			stringBuilder.append(")");
			generate(open, close+1, n, stringBuilder, resultList);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
	}
}
