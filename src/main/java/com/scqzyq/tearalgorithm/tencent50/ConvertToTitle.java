package com.scqzyq.tearalgorithm.tencent50;

/**
 * @Description: 寻找两个正序数组的中位数 LeetCode 4
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class ConvertToTitle {

    public static String convertToTitle(int columnNumber) {
        StringBuilder rt = new StringBuilder();
        while (columnNumber != 0) {
            rt.append((char) ('A'+ --columnNumber % 26));
            columnNumber /= 26;
        }
        return rt.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
