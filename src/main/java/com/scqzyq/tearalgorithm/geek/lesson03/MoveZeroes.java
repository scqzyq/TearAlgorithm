package com.scqzyq.tearalgorithm.geek.lesson03;

/**
 * @Description: 283. 移动零
 * @Author 盛春强
 * @Date 2021/7/24 8:32
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (i != index) {
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}
