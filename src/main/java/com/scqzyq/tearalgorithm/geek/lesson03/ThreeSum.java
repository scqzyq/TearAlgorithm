package com.scqzyq.tearalgorithm.geek.lesson03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 三数之和
 * @Author 盛春强
 * @Date 2021/7/24 16:48
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }

            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    --k;
                } else if (sum < 0) {
                    ++j;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    // 判断与下一位置的值是否相同，相同就跳过
                    while(j < k && nums[j] == nums[++j]);
                    while(j < k && nums[k] == nums[--k]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);
    }
}
