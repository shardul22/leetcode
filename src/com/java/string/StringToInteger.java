package com.java.string;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    /**
     * The method below converts String to Integer value.
     * @param str input string to be converted to int
     * @return converted integer value
     */
    public int myAtoi(String str) {

        /*
        * Steps to solve problem :-
        *
        * 1) Check if the input string is NULL/BLANK or not otherwise return 0.
        * 2) Trim the input string to remove leading and trailing spaces.
        * 3) Check if the input string starts with "-" which indicates that number is negative.
        * 4) Store the result in "DOUBLE". This important because we have to handle the overflow
        * condition.
        * 5) Convert char to int value and multiply result by 10 each time to build number
        * 6) If the result overflows Integer MIN_VALUE or MAX_VALIE then return appropriate value
        *
        * */

        // Code below is the boundry condition which checks
        // if the input string is null/blank or not
        if (str == null || str.length() == 0) {
            return 0;
        }

        double result = 0;
        int i = 0;
        boolean isNegative = false;
        char[] inputStringCharArray = str.trim().toCharArray();

        if (inputStringCharArray[i] == '+') {
            i++;
        } else if (inputStringCharArray[i] == '-') {
            isNegative = true;
            i++;
        }

        // Convert char to int value and multiply result by 10 each time to build number
        while (i < inputStringCharArray.length &&
                inputStringCharArray[i] >= '0' && inputStringCharArray[i] <= '9') {
            result = result * 10 + inputStringCharArray[i] - '0';
            i++;
        }

        // Multiply by -1 if number is negative number.
        if (isNegative)
            result = result * -1;

        // Handle the overflow condition otherwise convert result to int return it.
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) result;
    }
}
