package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 18:14
 */
public class StringSort1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            Arrays.sort(strings);
            for (String string : strings) {
                System.out.print(string+" ");
            }
        }
    }
}
