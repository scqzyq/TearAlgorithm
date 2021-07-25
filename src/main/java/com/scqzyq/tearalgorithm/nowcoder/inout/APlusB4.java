package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 17:59
 */
public class APlusB4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                sum+=scanner.nextInt();
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}
