package com.scqzyq.tearalgorithm.nowcoder.inout;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author 盛春强
 * @Date 2021/7/25 18:37
 */
public class StringSort3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(",");
            Arrays.sort(strings);
            String string = Arrays.toString(strings);
            System.out.println(string.substring(1,string.length()-1).replaceAll(" ",""));
        }
    }
}
