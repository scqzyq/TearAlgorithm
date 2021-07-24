package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: 单链表判断是否有环 LeetCode 141
 * @Author 盛春强
 * @Date 2021/4/15 16:37
 */

public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.next)) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }
        ListNode oneStep = head;
        ListNode twoStep = head.next;
        while (Objects.nonNull(twoStep) && Objects.nonNull(twoStep.next)) {
            if (oneStep == twoStep) {
                return true;
            }
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return false;
    }
}
