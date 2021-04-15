package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: 单链表找环入口 LeetCode 141
 * @Author: 盛春强
 * @Date: 2021/4/15 16:38
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        set.add(head);
        ListNode node = head.next;
        while (Objects.nonNull(node)) {
            if (!set.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
