package com.scqzyq.tearalgorithm.geek;

import java.util.HashMap;

/**
 * @Description: 146. LRU 缓存机制
 * @Author 盛春强
 * @Date 2021/7/22 11:29
 */
public class LRUCache {

    private class ListNode {

        public int key,val;
        public ListNode next, prev;

        ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        DoubleList() {
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.prev = head;
        }

        private ListNode head,tail;


        public ListNode toHead(ListNode node) {
            this.head.next.prev = node;
            node.next = this.head.next;
            node.prev = this.head;
            this.head.next = node;
            return node;
        }

        private void remove(ListNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        public int removeLast() {
            int key = this.tail.prev.key;
            remove(this.tail.prev);
            return key;
        }
    }

    private HashMap<Integer, ListNode> map;

    private DoubleList doubleList;

    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        doubleList = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode node = map.get(key);
        this.doubleList.remove(node);
        this.doubleList.toHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            this.doubleList.remove(node);
            this.doubleList.toHead(node);
        } else {
            if (this.cap == map.size()) {
                map.remove(this.doubleList.removeLast());
            }
            map.put(key,this.doubleList.toHead(new ListNode(key,value)));
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }

}
