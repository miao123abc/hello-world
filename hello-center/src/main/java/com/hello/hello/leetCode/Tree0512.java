package com.hello.hello.leetCode;

import com.hello.hello.leetCode.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Tree0512 {

    /**
     给定两个二叉树，编写一个函数来检验它们是否相同。

     如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //递归比较
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        //1.检查两个树 是否相同
//        else if (p.val != q.val) return false;
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        //2.检查两个树是否 镜像对称
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        //递归
//        if (null == root) return true;
//        return isSameTree(root.left, root.right);

        //迭代
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(3);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.left.right.left = new TreeNode(8);
        p.left.right.right = new TreeNode(9);

        p.right = new TreeNode(3);
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(3);
        p.right.left.left = new TreeNode(9);
        p.right.left.right = new TreeNode(8);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(4);

        System.out.println("两个二叉树 是否相同： " + isSameTree(p, q));

        System.out.println("是否镜像对称： " + isSymmetric(p));
    }

}
