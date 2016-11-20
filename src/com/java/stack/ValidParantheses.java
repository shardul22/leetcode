package com.java.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParantheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> bracketStack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '{' || charArray[i] == '(' || charArray[i] == '[') {
                bracketStack.push(charArray[i]);
            } else {
                if (bracketStack.isEmpty()) {
                    return false;
                } else if (charArray[i] == ')' && bracketStack.peek() == '(') {
                    bracketStack.pop();
                } else if (charArray[i] == '}' && bracketStack.peek() == '{') {
                    bracketStack.pop();
                } else if (charArray[i] == ']' && bracketStack.peek() == '[') {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }
}
