package com.scqzyq.tearalgorithm.tencent50;

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
