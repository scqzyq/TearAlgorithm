package com.scqzyq.tearalgorithm.other;

/**
 * @Description: 1. 两数之和
 * @Author: 盛春强
 * @Date: 2021/4/23 16:53
 */
public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[1];
    }
}
