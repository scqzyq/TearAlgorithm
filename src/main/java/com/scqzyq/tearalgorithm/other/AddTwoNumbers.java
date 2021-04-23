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
        ListNode node1 = new ListNode(0);
//        node1.next = new ListNode(4);
//        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(0);
//        node2.next = new ListNode(6);
//        node2.next.next = new ListNode(4);


        ListNode node = addTwoNumbers(node1, node2);

        ListNode.printListNode(node);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }

}
