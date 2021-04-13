package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;
import java.util.Scanner;

public class ReverseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String listString = scanner.next();
        ListNode head = ListNode.string2ListNode(listString);
        ListNode node = reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (Objects.nonNull(node)) {
            ListNode tmp;
            tmp = node.next;
            node.next = pre;
            pre = node;
            node = tmp;
        }
        return pre;
    }

}
