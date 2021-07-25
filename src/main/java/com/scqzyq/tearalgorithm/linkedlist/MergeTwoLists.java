package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: 单链表合并 LeetCode 21
 * @Author: 盛春强
 * @Date: 2021/4/16 11:05
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        mergeTwoLists(l1, l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sort = new ListNode(-1);
        ListNode head = sort;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val < l2.val) {
                sort.next = l1;
                l1 = l1.next;
            } else {
                sort.next = l2;
                l2 = l2.next;
            }
            sort = sort.next;
        }
        sort.next = Objects.isNull(l1) ? l2 : l1;
        return head.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode empty = new ListNode(Integer.MIN_VALUE);
        ListNode head = empty;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = Objects.isNull(l1)?l2:l1;
        return empty.next;
    }
}
