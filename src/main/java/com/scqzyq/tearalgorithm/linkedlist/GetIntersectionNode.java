package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description: 单链表找交点 LeetCode 160
 * @Author: 盛春强
 * @Date: 2021/4/15 17:05
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        if (Objects.isNull(a)||Objects.isNull(b)) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (Objects.nonNull(a)) {
            set.add(a);
            a = a.next;
        }
        while (Objects.nonNull(b)) {
            if (!set.add(b)) {
                return b;
            }
            b = b.next;
        }
        return null;
    }
}
