package com.scqzyq.tearalgorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 下一个更大元素 I LeetCode 496
 * @Author: 盛春强
 * @Date: 2021/4/23 16:09
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        int[] r = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            r[i] = map.getOrDefault(nums1[i], -1);
        }
        return r;
    }

}
