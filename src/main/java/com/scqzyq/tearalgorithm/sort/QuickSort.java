package com.scqzyq.tearalgorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * @Author 盛春强
 * @Date 2021/7/26 10:43
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] ranArr = new int[15];
        for (int i = 0; i < ranArr.length; i++) {
            ranArr[i] = RandomUtils.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(ranArr));
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(ranArr, 0, ranArr.length - 1);
    }


    private void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivot = partition1(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    /**
     * 单路快速排序（有序数组会退化为单链表）
     *
     * @Author 盛春强
     * @Date 2021/7/26 11:44
     * @Param [nums, begin, end]
     * @Return int
     */

    private int partition1(int[] nums, int begin, int end) {
        int finalPivot = begin;
        int tmp;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[end]) {
                tmp = nums[finalPivot];
                nums[finalPivot] = nums[i];
                nums[i] = tmp;
                finalPivot++;
            }
        }
        tmp = nums[finalPivot];
        nums[finalPivot] = nums[end];
        nums[end] = tmp;
        return finalPivot;
    }

    /**
     * 双路快速排序
     *
     * @Author 盛春强
     * @Date 2021/7/26 11:44
     * @Param [nums, begin, end]
     * @Return int
     */
    private int partition2(int[] nums, int begin, int end) {
        int pivotKey = nums[begin];
        while (begin < end) {
            while (nums[end] >= pivotKey && begin < end) {
                end--;
            }
            nums[begin] = nums[end];
            while (nums[begin] <= pivotKey && begin < end) {
                begin++;
            }
            nums[end] = nums[begin];
        }
        nums[begin] = pivotKey;
        return begin;
    }

    /**
     * 三路快排
     *
     * @Author 盛春强
     * @Date 2021/7/26 12:12
     * @Param [nums, begin, end]
     * @Return int
     */
    private int partition3(int[] nums, int begin, int end) {
        int pivot = nums[begin];//基准值
        int i = begin;//左侧"哨兵"
        int j = end;//右侧"哨兵"
        int index = begin + 1;
        while (index <= j) {
            if (nums[index] < pivot) {
                swap(nums,index++,++i);
            } else if (nums[index] > pivot) {
                swap(nums,index,j--);
            } else {
                index++;
            }
        }
        swap(nums,begin,i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
