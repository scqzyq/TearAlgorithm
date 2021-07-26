package com.scqzyq.tearalgorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * @Description: 归并排序（递归）
 * @Author: 盛春强
 * @Date: 2021/5/10 14:45
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ranArr = new int[15];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = RandomUtils.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(ranArr));
        mergeSort(ranArr);
        System.out.println(Arrays.toString(ranArr));
    }

    private static void mergeSort(int[] ranArr) {
        sort(ranArr, 0, ranArr.length - 1, new int[ranArr.length]);
    }

    private static void sort(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid, tmp);
        sort(nums, mid + 1, right, tmp);
        merge(nums, left, mid, right, tmp);
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] tmp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= right) {
            tmp[k++] = nums[j++];
        }
        for (int p = 0; p < (right - left + 1); p++) {
            nums[left + p] = tmp[p];
        }
    }
}
