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
    }

    private static void mergeSort(int[] ranArr) {
        sort(ranArr, 0, ranArr.length - 1, new int[ranArr.length]);
    }

    private static void sort(int[] ranArr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(ranArr, left, mid, tmp);
            sort(ranArr, mid + 1, right, tmp);
            merge(ranArr, left, mid, right, tmp);
        }
    }

    private static void merge(int[] ranArr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
//        // 方便分析
//        tmp = new int[right-left+1];
        while (i <= mid && j <= right) {
            if (ranArr[i] <= ranArr[j]) {
                tmp[k++] = ranArr[i++];
            } else {
                tmp[k++] = ranArr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = ranArr[i++];
        }
        while (j <= right) {
            tmp[k++] = ranArr[j++];
        }
        k = 0;
        while (left <= right) {
            ranArr[left++] = tmp[k++];
        }
        System.out.println("__________________");
        System.out.println(Arrays.toString(tmp));
        System.out.println(Arrays.toString(ranArr));
    }
}
