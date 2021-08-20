package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @Description: 另一个树的子树 LeetCode 572
 * @Author 盛春强
 * @Date 2021/6/30 9:59
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root)) {
            return false;
        }
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        } else if (Objects.isNull(p) || Objects.isNull(q)) {
            return false;
        }
        Deque<TreeNode> pQueue = new ArrayDeque<>();
        Deque<TreeNode> qQueue = new ArrayDeque<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pPoll = pQueue.poll();
            TreeNode qPoll = qQueue.poll();
            if (pPoll.val != qPoll.val) {
                return false;
            }
            TreeNode pLeft = pPoll.left;
            TreeNode qLeft = qPoll.left;
            TreeNode pRight = pPoll.right;
            TreeNode qRight = qPoll.right;
            if (Objects.isNull(pLeft) ^ Objects.isNull(qLeft)) {
                return false;
            }
            if (Objects.isNull(pRight) ^ Objects.isNull(qRight)) {
                return false;
            }
            if (Objects.nonNull(pLeft)) {
                pQueue.offer(pLeft);
                qQueue.offer(qLeft);
            }
            if (Objects.nonNull(pRight)) {
                pQueue.offer(pRight);
                qQueue.offer(qRight);
            }
        }
        return pQueue.isEmpty() && qQueue.isEmpty();
    }
}
