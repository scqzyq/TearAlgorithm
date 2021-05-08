package com.scqzyq.tearalgorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @Author: 盛春强
 * @Date: 2021/5/8 15:15
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] ranArr = new int[15];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = RandomUtils.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(ranArr));
        insertionSort(ranArr);
    }

    private static void insertionSort(int[] ranArr) {
        for (int i = 1; i < ranArr.length; i++) {
            int value = ranArr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < ranArr[j]) {
                    ranArr[j + 1] = ranArr[j];
                } else {
                    break;
                }
            }
            ranArr[j + 1] = value;
            System.out.println(Arrays.toString(ranArr));
        }
    }
}
