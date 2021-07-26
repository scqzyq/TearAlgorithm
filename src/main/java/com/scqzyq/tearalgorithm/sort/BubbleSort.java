package com.scqzyq.tearalgorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * @Description: 冒泡排序
 * @Author: 盛春强
 * @Date: 2021/5/8 14:57
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] ranArr = new int[15];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = RandomUtils.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(ranArr));
        bubbleSort(ranArr);
    }

    private static void bubbleSort1(int[] nums) {
        // 冒泡排序
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    private static void bubbleSort(int[] ranArr) {
        for (int i = 0; i < ranArr.length; i++) {
            boolean op = false;
            for (int j = 0; j < ranArr.length - i - 1; j++) {
                if (ranArr[j] > ranArr[j + 1]) {
                    int tmp = ranArr[j];
                    ranArr[j] = ranArr[j + 1];
                    ranArr[j + 1] = tmp;
                    op = true;
                }
            }
            if (!op) {
                break;
            }
            System.out.println(Arrays.toString(ranArr));
        }
    }

}
