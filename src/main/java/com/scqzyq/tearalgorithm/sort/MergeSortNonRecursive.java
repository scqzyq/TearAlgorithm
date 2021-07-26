package com.scqzyq.tearalgorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * @Description: 归并排序（非递归）
 * @Author: 盛春强
 * @Date: 2021/5/10 17:30
 */
public class MergeSortNonRecursive {
    public static void main(String[] args) {
        int[] ranArr = new int[15];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = RandomUtils.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(ranArr));
        mergeSortNonRecursive(ranArr);
        System.out.println(Arrays.toString(ranArr));
    }

    private static void mergeSortNonRecursive(int[] ranArr) {

        int len = 1;
        int left;
        int mid;
        int right;
        int[] tmp = new int[ranArr.length];
        while (len <= ranArr.length) {
            for (int i = 0; i + len <= ranArr.length - 1; i += len * 2) {
                left = i;
                right = i + 2 * len - 1;
                mid = i + len - 1;
                if (right > ranArr.length - 1) {
                    right = ranArr.length - 1;
                }
                merge(ranArr, left, mid, right, tmp);
            }
            len *= 2;
        }
    }

    private static void merge(int[] ranArr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            tmp[k++] = ranArr[i] < ranArr[j] ? ranArr[i++] : ranArr[j++];
        }
        while (i <= mid) {
            tmp[k++] = ranArr[i++];
        }
        while (j <= right) {
            tmp[k++] = ranArr[j++];
        }
        for (int p = 0; p < (right - left + 1); p++) {
            ranArr[left + p] = tmp[p];
        }
    }
}
