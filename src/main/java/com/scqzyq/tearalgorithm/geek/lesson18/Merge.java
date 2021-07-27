package com.scqzyq.tearalgorithm.geek.lesson18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: 56. 合并区间
 * @Author 盛春强
 * @Date 2021/7/27 11:43
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (list.get(list.size()-1)[1]>=l) {
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1],r);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[0][0]);
    }
}
