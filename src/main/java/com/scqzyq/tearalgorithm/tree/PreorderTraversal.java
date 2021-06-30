package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.*;

/**
 * @Description: 二叉树的前序遍历 LeetCode 144
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        findChild(list, root);
        return list;
    }

    private void findChild(List<Integer> list, TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        list.add(treeNode.val);
        findChild(list, treeNode.left);
        findChild(list, treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        List<Integer> list = preorderTraversal.preorderTraversal(treeNode1);
        System.out.println(list);
    }

    public List<Integer> preorderTraversalNonRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (Objects.nonNull(root) || !deque.isEmpty()) {
            while (Objects.nonNull(root)) {
                list.add(root.val);
                deque.push(root);
                root = root.left;
            }
            root = deque.pop().right;
        }
        return list;
    }
}
