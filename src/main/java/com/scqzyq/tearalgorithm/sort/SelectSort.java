package com.scqzyq.tearalgorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * @Description: 选择排序
 * @Author: 盛春强
 * @Date: 2021/5/8 15:33
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] ranArr = new int[15];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = RandomUtils.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(ranArr));
        selectSort(ranArr);
    }

    private static void selectSort(int[] ranArr) {
        for (int i = 0; i < ranArr.length; i++) {
            int min = ranArr[i];
            int f = i;
            for (int j = i; j < ranArr.length - 1; j++) {
                if (ranArr[j + 1] < min) {
                    min = ranArr[j + 1];
                    f = j + 1;
                }
            }
            ranArr[f] = ranArr[i];
            ranArr[i] = min;
            System.out.println(Arrays.toString(ranArr));
        }
    }

    private static void selectSort1(int[] ranArr) {
        for (int i = 0; i < ranArr.length; i++) {
            int min = ranArr[i];
            int l = i;
            for (int j = i+1; j < ranArr.length; j++) {
                if (ranArr[j]<min) {
                    min = ranArr[j];
                    l = j;
                }
            }
            if (l!=i) {
                ranArr[l] = ranArr[i];
                ranArr[i] = min;
            }
        }
    }
}
