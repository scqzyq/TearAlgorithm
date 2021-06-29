package com.scqzyq.tearalgorithm.tencent50;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length<2) {
            return nums.length;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                nums[++count] = nums[i];
            }
        }
        return ++count;
    }

    public static void main(String[] args) {
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(ints));
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
