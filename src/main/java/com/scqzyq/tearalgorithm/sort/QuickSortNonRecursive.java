package com.scqzyq.tearalgorithm.sort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: 快速排序非递归
 * @Author 盛春强
 * @Date 2021/7/26 16:10
 */
public class QuickSortNonRecursive {
    private void quickSort(int[] nums, int begin, int end) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(end);
        deque.push(begin);
        while (!deque.isEmpty()) {
            Integer left = deque.pop();
            Integer right = deque.pop();
            int pivot = partition2(nums, left, right);
            if (pivot - 1 > left) {
                deque.push(pivot - 1);
                deque.push(left);
            }
            if (pivot + 1 < right) {
                deque.push(right);
                deque.push(pivot + 1);
            }
        }
    }

    /**
     * 双路快排
     *
     * @Author 盛春强
     * @Date 2021/7/26 16:28
     * @Param [nums, begin, end]
     * @Return int
     */
    private int partition2(int[] nums, int begin, int end) {
        int pivot = nums[begin];
        int l = begin;
        int r = end;
        while (l < r) {
            while (nums[r] > pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (nums[l] < pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        return l;
    }
}
