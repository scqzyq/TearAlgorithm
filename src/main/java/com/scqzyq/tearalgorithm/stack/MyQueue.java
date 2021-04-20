package com.scqzyq.tearalgorithm.stack;

import java.util.Stack;

/**
 * @Description: 用栈实现队列 LeetCode 232
 * @Author: 盛春强
 * @Date: 2021/4/20 11:59
 */
public class MyQueue {

    private Stack<Integer> left;

    private Stack<Integer> right;

    /** Initialize your data structure here. */
    public MyQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!right.empty()) {
            left.push(right.pop());
        }
        left.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (right.empty()) {
            trans();
        }
        return right.pop();

    }

    private void trans() {
        while (!left.empty()) {
            right.push(left.pop());
        }
    }

    /** Get the front element. */
    public int peek() {
        if (right.empty()) {
            trans();
        }
        return right.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return right.empty()|| left.empty();
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */