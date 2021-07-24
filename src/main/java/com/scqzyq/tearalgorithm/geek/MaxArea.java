package com.scqzyq.tearalgorithm.geek;

/**
 * @Description: 11. 盛最多水的容器
 * @Author 盛春强
 * @Date 2021/7/24 8:44
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int minHeight = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            minHeight = height[i] < height[j] ? height[i++] : height[j--];
            maxArea = Math.max(minHeight * (j - i + 1), maxArea);
        }
        return maxArea;
    }
}
