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

    private static void sort(int[] ranArr, int left, int right, int[] finalArr) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(ranArr, left, mid, finalArr);
            sort(ranArr, mid + 1, right, finalArr);
            merge(ranArr, left, mid, right, finalArr);
        }
    }

    private static void merge(int[] ranArr, int left, int mid, int right, int[] finalArr) {
        int i = left;
        int j = mid + 1;
        int k = 0;
//        // 方便分析
//        finalArr = new int[right-left+1];
        while (i <= mid && j <= right) {
            if (ranArr[i] <= ranArr[j]) {
                finalArr[k++] = ranArr[i++];
            } else {
                finalArr[k++] = ranArr[j++];
            }
        }
        while (i <= mid) {
            finalArr[k++] = ranArr[i++];
        }
        while (j <= right) {
            finalArr[k++] = ranArr[j++];
        }
        k = 0;
        while (left <= right) {
            ranArr[left++] = finalArr[k++];
        }
        System.out.println("__________________");
        System.out.println(Arrays.toString(finalArr));
        System.out.println(Arrays.toString(ranArr));
    }
}
