package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 18:03
 */
public class APlusB5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNext()) {
            int t = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt();
                for (int i1 = 0; i1 < n; i1++) {
                    sum += scanner.nextInt();
                }
                System.out.println(sum);
                sum = 0;
            }
        }
    }
}
