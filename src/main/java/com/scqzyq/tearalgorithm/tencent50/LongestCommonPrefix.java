package com.scqzyq.tearalgorithm.tencent50;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[] f = strs[0].toCharArray();
        int length = f.length;
        for (int i = 1; i < strs.length; i++) {
            char[] t = strs[i].toCharArray();
            length = Math.min(length, t.length);
            for (int j = 0; j < length; j++) {
                if (f[j] != t[j]) {
                    length = j;
                }
            }
        }
        return strs[0].substring(0, length);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }
}
