package com.scqzyq.tearalgorithm.tencent50;

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
