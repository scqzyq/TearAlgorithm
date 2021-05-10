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
    }

    private static void mergeSortNonRecursive(int[] ranArr) {
    }
}
