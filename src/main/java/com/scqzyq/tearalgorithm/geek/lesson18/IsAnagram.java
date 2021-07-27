package com.scqzyq.tearalgorithm.geek.lesson18;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 242. 有效的字母异位词
 * @Author 盛春强
 * @Date 2021/7/27 11:29
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer integer = map.get(c);
            if (integer == null) {
                return false;
            } else {
                map.put(c, integer - 1);
            }
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
