package com.scqzyq.tearalgorithm.stack;

import java.util.Stack;

/**
 * @Description: 有效的括号 LeetCode 20
 * @Author: 盛春强
 * @Date: 2021/4/16 16:42
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("{()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char pop;
        for (char bChar : chars) {
            if (bChar == ')') {
                if (stack.empty()) {
                    return false;
                }
                pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (bChar == '}') {
                if (stack.empty()) {
                    return false;
                }
                pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            } else if (bChar == ']') {
                if (stack.empty()) {
                    return false;
                }
                pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else {
                stack.push(bChar);
            }
        }
        return stack.empty();
    }
}
