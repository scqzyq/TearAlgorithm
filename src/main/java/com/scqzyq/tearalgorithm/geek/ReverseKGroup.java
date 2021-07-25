package com.scqzyq.tearalgorithm.geek;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: 25. K 个一组翻转链表
 * @Author 盛春强
 * @Date 2021/7/25 15:44
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode empty = new ListNode();
        empty.next = head;
        ListNode pre = empty;
        ListNode tail = empty;
        while (Objects.nonNull(tail.next)) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (Objects.isNull(tail)) {
                    return empty.next;
                }
            }
            ListNode tailNext = tail.next;
            tail.next = null;
            ListNode reversedTail = pre.next;
            pre.next = reverse(reversedTail);
            reversedTail.next = tailNext;
            pre = reversedTail;
            tail = pre;
        }
        return empty.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode node = head;
        ListNode pre = null;
        ListNode next;
        while (Objects.nonNull(node)) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
