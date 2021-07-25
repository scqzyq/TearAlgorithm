package com.scqzyq.tearalgorithm.geek.lesson03;

/**
 * @Description: 66. 加一
 * @Author 盛春强
 * @Date 2021/7/25 19:20
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (++digits[i] % 10 != 0) {
                return digits;
            }
            digits[i] %= 10;
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;
    }
}
