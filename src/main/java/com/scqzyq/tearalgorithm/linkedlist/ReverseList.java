package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;
import java.util.Scanner;

/**
 * @Description: 单链表翻转 LeetCode 206
 * @Author 盛春强
 * @Date 2021/4/15 16:37
 */

public class ReverseList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String listString = scanner.next();
        ListNode head = ListNode.string2ListNode(listString);
        ListNode node = reverseList(head);
        ListNode.printListNode(node);
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

    public static ListNode reverseList1(ListNode head) {
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
