package com.scqzyq.tearalgorithm.tencent50;

/**
 * @Description: 整数反转 LeetCode 9
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int s = 0;
        int t = x;
        while (t != 0) {
            s = s * 10 + t % 10;
            t /= 10;
        }
        return x == s;
    }
}
