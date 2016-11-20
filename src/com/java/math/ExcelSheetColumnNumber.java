package com.java.math;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        if (s == null || s.length() == 0)
            return 0;

        int length = s.length() - 1;
        int unitPlace = 0, result = 0;

        while (length >= 0) {
            result = result + (int) Math.pow(26, unitPlace) * (s.charAt(length) - 'A' + 1);
            length--;
            unitPlace++;
        }
        return result;
    }
}
