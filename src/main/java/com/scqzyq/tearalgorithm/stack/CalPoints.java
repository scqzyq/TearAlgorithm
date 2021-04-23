package com.scqzyq.tearalgorithm.stack;

import java.util.Stack;

/**
 * @Description: 棒球比赛 LeetCode 682
 * @Author: 盛春强
 * @Date: 2021/4/23 15:53
 */
public class CalPoints {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if ("+".equals(op)) {
                Integer pop = stack.pop();
                Integer peek = stack.peek();
                stack.push(pop);
                stack.push(pop + peek);
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }
        return sum;
    }

}
