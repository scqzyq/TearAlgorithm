package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: 单链表找中间节点 LeetCode 876
 * @Author: 盛春强
 * @Date: 2021/4/16 10:42
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (Objects.nonNull(fast)&&Objects.nonNull(fast.next)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
