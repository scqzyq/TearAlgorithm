package com.scqzyq.tearalgorithm.other;

import java.util.Arrays;

/**
 * @Description: 1833. 雪糕的最大数量
 * @Author 盛春强
 * @Date 2021/7/2 9:49
 */
public class MaxIceCream {
    public static int maxIceCream(int[] costs, int coins) {
        int count = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins - cost >= 0) {
                count++;
                coins -= cost;
            } else {
                break;
            }
        }
        return count;
    }

}
