package com.scqzyq.tearalgorithm.other;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: 2. 两数相加
 * @Author: 盛春强
 * @Date: 2021/4/23 17:04
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);


        ListNode node = addTwoNumbers(node1, node2);

        ListNode.printListNode(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        int ten = 0;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            node.next = new ListNode((ten + l1.val + l2.val) % 10);
            node = node.next;
            if (ten + l1.val + l2.val > 9) {
                ten = 1;
            } else {
                ten = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode tmp = Objects.isNull(l1) ? l2 : l1;
        while (Objects.nonNull(tmp)) {
            node.next = new ListNode((ten + tmp.val) % 10);
            node = node.next;
            if (tmp.val + ten > 9) {
                ten = 1;
            } else {
                ten = 0;
            }
            tmp = tmp.next;
        }
        if (ten == 1) {
            node.next = new ListNode(1);
        }
        return head.next;
    }

}
