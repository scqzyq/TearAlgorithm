package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 17:50
 */
public class APlusB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int c = scanner.nextInt();
        for (int i = 0; i < c; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            list.add(a+b);
        }
        list.forEach(System.out::println);
    }
}
