package com.java.math;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class ExcelSheetColumnNumber {

    /**
     * The function below converts Column title to respective number.
     * @param s input string to convert to column number value.
     * @return converted column number otherwise return 0;
     */
    public int titleToNumber(String s) {

        /*
        * Steps to solve problem :-
        *
        * 1) Check if the input string is NULL/BLANK or not otherwise return 0.
        * 2) Start your calculation from last character of the string to build a number.
        * 3) As we know A -> 1, B -> 2,..., Z -> 26 so if number is 27 then we represent it as
        * AA. Therefore it is in the powers of "26".
        * e.g. str = "AB" then
        * B = 26^0 * 2 =  1 * 2 = 02(2 is value of B)
        * A = 26^1 * 1 = 26 * 1 = 26
        * result = 2 + 26 = 28 -> AB
        *
        * 4) Form a number in powers of 26 and add it to previously calculated result.
        *
        * */

        if (s == null || s.length() == 0)
            return 0;

        int lengthOfString = s.length() - 1;
        int power = 0, result = 0;

        while(lengthOfString >= 0) {
            // Here we calculate the value of character and add 1 becasue the value starts with 1
            // i.e. if we subtract "A" then for B = 66 - 65 = 1 (Ascii value for B=66, A=65).
            // but value of B sould be 2 hencewe add 1 the result.
            int valueOfChar = s.charAt(lengthOfString) - 'A' + 1;
            result = result + (int) Math.pow(26, power) * valueOfChar;

            power++;
            lengthOfString--;
        }
        return result;
    }
}
