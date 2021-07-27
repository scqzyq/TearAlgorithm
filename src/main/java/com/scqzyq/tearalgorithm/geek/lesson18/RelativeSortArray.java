package com.scqzyq.tearalgorithm.geek.lesson18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 1122. 数组的相对排序
 * @Author 盛春强
 * @Date 2021/7/27 9:53
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int item : arr1) {
            map1.put(item, map1.getOrDefault(item, 0) + 1);
        }
        int k = 0;
        for (int value : arr2) {
            for (int j = 0; j < map1.get(value); j++) {
                arr1[k++] = value;
            }
            map1.remove(value);
        }
        int begin = k;
        for (Map.Entry<Integer, Integer> en : map1.entrySet()) {
            for (int i = 0; i < en.getValue(); i++) {
                arr1[k++] = en.getKey();
            }
        }
        Arrays.sort(arr1,begin,arr1.length);
        return arr1;
    }


}
