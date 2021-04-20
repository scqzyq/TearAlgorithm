package com.scqzyq.tearalgorithm.stack;

import java.util.Stack;

/**
 * @Description: 比较含退格的字符串 LeetCode 844
 * @Author: 盛春强
 * @Date: 2021/4/20 15:09
 */
public class BackspaceCompare {

    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        boolean b = backspaceCompare(s, t);
        System.out.println(b);
    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (char sChar : sArray) {
            if (sChar == '#') {
                if (!tStack.empty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(sChar);
            }
        }
        char[] tArray = t.toCharArray();
        for (char tChar : tArray) {
            if (tChar == '#') {
                if (!tStack.empty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(tChar);
            }
        }
        while (!sStack.empty() && !tStack.empty()) {
            if (!sStack.pop().equals(tStack.pop())) {
                return false;
            }
        }
        return sStack.empty() && tStack.empty();
    }
}
