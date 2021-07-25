package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 18:06
 */
public class APlusB6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}
