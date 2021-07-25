package com.scqzyq.tearalgorithm.geek.lesson03;

/**
 * @Description: 70. 爬楼梯
 * @Author 盛春强
 * @Date 2021/7/24 9:04
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int a = 1, b = 2, tmp;
        for (int i = 3; i <= n; ++i) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairs(2);
    }
}
