package com.scqzyq.tearalgorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 基本计算器 LeetCode 224
 * @Author: 盛春强
 * @Date: 2021/4/20 15:40
 */
public class Calculate {

    public static void main(String[] args) {
        String s = "1 + 1";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        Deque<Integer> dt = new ArrayDeque<>();
        char[] chars = s.replace(" ", "").toCharArray();
        int sign = 1;
        int res = 0;
        for (char c : chars) {
            if (Character.isDigit(c)) {
                if (dt.isEmpty()) {
                    dt.push(c - '0');
                } else {
                    dt.push(dt.pop() * 10 + (c - '0'));
                }
            } else {
                if (!dt.isEmpty()) {
                    res += sign * dt.pop();
                }
            }
            if (c == '(') {
                d.push(res);
                d.push(sign);
                res = 0;
                sign = 1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == ')') {
                res = d.pop()*res + d.pop();
            }
        }
        if (!dt.isEmpty()) {
            res += sign * dt.pop();
        }
        return res;
    }
}
