package com.scqzyq.tearalgorithm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 最小栈 LeetCode 155
 * @Author: 盛春强
 * @Date: 2021/4/20 9:35
 */
class MinStack {

    private int size;

    private int[] data;

    private int[] min;

    private int minSize;

    private static final int MULTIPLE = 2;

    /** initialize your data structure here. */
    public MinStack() {
        size = 0;
        data = new int[100];
        minSize = 0;
        min = new int[]{Integer.MAX_VALUE};
    }

    public void push(int val) {
        if (size == data.length) {
            data = Arrays.copyOf(data, size * MULTIPLE);
        }
        data[size++] = val;
        if (minSize == min.length) {
            min = Arrays.copyOf(min, minSize * MULTIPLE);
        }
        if (minSize == 0 || val <= min[minSize - 1]) {
            min[minSize++] = val;
        }
    }

    public void pop() {
        if (data[size-- - 1] == min[minSize - 1]) {
            minSize--;
        }
    }

    public int top() {
        return data[size - 1];
    }

    public int getMin() {
        return min[minSize - 1];
    }

}

class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(-1);
        minStack.push(0);
        minStack.getMin();   // 返回 -3.
        minStack.pop();
//        minStack.top();      // 返回 0.
        minStack.getMin();   // 返回 -2.
    }
}

class MinStack1 {

    /** initialize your data structure here. */
    public MinStack1() {
        data = new ArrayList<>();
        min = new ArrayList<>();
        min.add(Integer.MAX_VALUE);
    }

    private List<Integer> data;
    private List<Integer> min;

    public void push(int val) {
        data.add(val);
        if (val<=min.get(min.size()-1)) {
            min.add(val);
        }
    }

    public void pop() {
        Integer remove = data.remove(data.size() - 1);
        if (remove.equals(min.get(min.size() - 1))) {
            min.remove(min.size() - 1);
        }
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */