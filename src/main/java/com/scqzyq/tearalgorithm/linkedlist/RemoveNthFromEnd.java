package com.scqzyq.tearalgorithm.linkedlist;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: TODO
 * @Author: 盛春强
 * @Date: 2021/4/16 15:52
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nodeHead = new ListNode(-1);
        nodeHead.next = head;
        ListNode nNode = nodeHead.next;
        ListNode node = nodeHead;
        while (n-->0) {
            nNode = nNode.next;
        }
        while (Objects.nonNull(nNode)) {
            nNode = nNode.next;
            node = node.next;
        }
        node.next = node.next.next;
        return nodeHead.next;
    }
    /*
        if (Objects.isNull(head.next)) {
            return null;
        }
        int c=0;
        ListNode list = head;
        ListNode node = head;
        while (Objects.nonNull(list)) {
            list = list.next;
            c++;
        }
        if (c == n) {
            return head.next;
        }
        if (c < n) {
            return head;
        }
        while (c-++n>0) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;
     */
    /*
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode listNode = node;
        ListNode delNode = node;
        int c= 0;
        while(Objects.nonNull(listNode)) {
            listNode = listNode.next;
            c++;
        }
        while (c-++n>0) {
            delNode = delNode.next;
        }
        delNode.next = delNode.next.next;
        return node.next;
     */
}
