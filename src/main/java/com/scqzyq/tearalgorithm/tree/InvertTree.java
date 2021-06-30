package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.Objects;

/**
 * @Description: 翻转二叉树 LeetCode 226
 * @Author 盛春强
 * @Date 2021/6/30 17:09
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
