package com.scqzyq.tearalgorithm.tencent50;

/**
 * @Description: 整数反转 LeetCode 7
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class Reverse {
    public static int reverse(int x) {
        long s = 0;
        while (x != 0) {
            int i = x % 10;
            s = s * 10 + i;
            x /= 10;
        }
        return (int) s == s ? (int) s : 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1534269));
    }
}
