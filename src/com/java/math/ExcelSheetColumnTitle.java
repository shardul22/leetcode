package com.java.math;


/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		
		StringBuilder stringBuilder = new StringBuilder();
		if(n <= 0) {
			return stringBuilder.toString();
		}
		while(n > 0) {
			// We decrement n because we are adding to character A. 
			n--;
			stringBuilder.insert(0 , (char)('A' + (n%26))); 
			n = n / 26; 
		}
		return stringBuilder.toString();
	}
}
