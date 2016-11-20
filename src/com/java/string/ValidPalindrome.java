package com.java.string;

/*
 * https://leetcode.com/problems/valid-palindrome/
 * */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null || s == "")
            return false;

        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            if (isValidCharacter(s.charAt(i)) && isValidCharacter(s.charAt(j))) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
            if (!isValidCharacter(s.charAt(i))) {
                i++;
            }
            if (!isValidCharacter(s.charAt(j))) {
                j--;
            }

        }
        return true;
    }

    public boolean isValidCharacter(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}
