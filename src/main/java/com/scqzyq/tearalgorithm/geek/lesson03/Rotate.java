package com.scqzyq.tearalgorithm.geek.lesson03;


/**
 * @Description: 189. 旋转数组
 * @Author 盛春强
 * @Date 2021/7/25 20:15
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int begin, int end) {
        int tmp;
        while (begin < end) {
            tmp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        rotate.rotate(new int[]{1,2,3,4,5,6,7},3);
    }

}
