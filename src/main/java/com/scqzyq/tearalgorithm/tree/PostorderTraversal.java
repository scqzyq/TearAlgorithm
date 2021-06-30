package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.*;

/**
 * @Description: 二叉树的后序遍历 LeetCode 145
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root1,root2 = null;
        while (Objects.nonNull(root) || !deque.isEmpty()) {
            if (Objects.nonNull(root)) {
                deque.push(root);
                root = root.left;
            } else {
                root1 = deque.peek();
                if (Objects.isNull(root1.right)||root1.right == root2) {
                    list.add(deque.pop().val);
                    root2 = root1;
                } else {
                    root = root1.right;
                }
            }
        }
        return list;
    }

}
