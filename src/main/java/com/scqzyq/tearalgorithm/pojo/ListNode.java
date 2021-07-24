package com.scqzyq.tearalgorithm.pojo;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode string2ListNode(String listString) {
        String[] split = listString.split("->");
        if (split.length == 0) {
            return null;
        }
        ListNode listNode = null;
        for (int i = split.length-1;i>=0;--i) {
            if ("NULL".equals(split[i])) {
                continue;
            }
            ListNode head = new ListNode(Integer.parseInt(split[i]));
            head.next = listNode;
            listNode = head;
        }
        return listNode;
    }

    public static void printListNode(ListNode head) {
        if (Objects.nonNull(head)) {
            System.out.println(head.val);
            head = head.next;
        } else {
            System.out.println((Object) null);
        }
    }
}


