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

    public ListNode detectCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (Objects.isNull(fast) || Objects.isNull(fast.next)) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        DetectCycle detectCycle = new DetectCycle();
        ListNode node = detectCycle.detectCycle1(l1);
        ListNode.printListNode(node);
    }
}
