package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 18:34
 */
public class StringSort2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(" ");
            Arrays.sort(strings);
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }
}
