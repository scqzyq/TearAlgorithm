package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Scanner;

/**
 * @Description: A+B(1)
 * @Author 盛春强
 * @Date 2021/7/25 17:46
 */
public class APlusB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
        }
    }
}
