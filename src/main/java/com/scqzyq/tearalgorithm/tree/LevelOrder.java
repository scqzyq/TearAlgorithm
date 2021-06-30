package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.*;

/**
 * @Description: 二叉树的层序遍历 LeetCode 102
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                levelList.add(poll.val);
                if (Objects.nonNull(poll.left)) {
                    deque.offer(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    deque.offer(poll.right);
                }
            }
            lists.add(levelList);
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> list = levelOrder.levelOrderDfs(treeNode1);
        System.out.println(list);
    }

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists, 0);
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        return lists;
    }

    private void dfs(TreeNode node, List<List<Integer>> lists, int level) {
        if (Objects.isNull(node)) {
            return;
        }
        if (lists.size() - 1 < level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(node.val);
        dfs(node.left, lists, level + 1);
        dfs(node.right, lists, level + 1);
    }

}
