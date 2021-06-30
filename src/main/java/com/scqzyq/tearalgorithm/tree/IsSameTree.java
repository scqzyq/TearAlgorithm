package com.scqzyq.tearalgorithm.tree;

import com.scqzyq.tearalgorithm.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @Description: 相同的树 LeetCode 100
 * @Author 盛春强
 * @Date 2021/6/30 16:29
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
            if (Objects.nonNull(pLeft) && Objects.nonNull(qLeft)) {
                pQueue.offer(pLeft);
                qQueue.offer(qLeft);
            }
            if (Objects.nonNull(pRight) && Objects.nonNull(qRight)) {
                pQueue.offer(pRight);
                qQueue.offer(qRight);
            }
        }
        return pQueue.isEmpty() && qQueue.isEmpty();
    }
}
