package com.scqzyq.tearalgorithm.geek.lesson03;

import com.scqzyq.tearalgorithm.pojo.ListNode;

import java.util.Objects;

/**
 * @Description: 24. 两两交换链表中的节点
 * @Author 盛春强
 * @Date 2021/7/24 18:34
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        res.next = head;
        ListNode zeroNode = res;
        while (Objects.nonNull(zeroNode.next)&&Objects.nonNull(zeroNode.next.next)) {
            ListNode oneNode = zeroNode.next;
            ListNode twoNode = zeroNode.next.next;
            zeroNode.next = twoNode;
            oneNode.next = twoNode.next;
            twoNode.next = oneNode;
            zeroNode = oneNode;
        }
        return res.next;
    }
}
