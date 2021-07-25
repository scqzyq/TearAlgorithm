package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 17:56
 */
public class APlusB3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a+b);
        }
    }
}
