package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 18:09
 */
public class APlusB7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextLine()) {
            String[] numsStrings = scanner.nextLine().split(" ");
            for (String numsString : numsStrings) {
                sum += Integer.parseInt(numsString);
            }
            System.out.println(sum);
            sum = 0;
        }
    }
}
