package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.*;

/**
 * @Description: 二叉树的中序遍历 LeetCode 94
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (Objects.nonNull(root) || !deque.isEmpty()) {
            while (Objects.nonNull(root)) {
                deque.push(root);
                root = root.left;
            }
            list.add(deque.peek().val);
            root = deque.pop().right;
        }
        return list;
    }
}
