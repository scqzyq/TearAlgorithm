package com.scqzyq.tearalgorithm.geek.lesson03;

/**
 * @Description: 88. 合并两个有序数组
 * @Author 盛春强
 * @Date 2021/7/25 19:36
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + --n;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n>=0) {
            nums1[p--] = nums2[n--];
        }
    }
}
