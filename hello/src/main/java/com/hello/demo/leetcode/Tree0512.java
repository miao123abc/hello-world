package com.hello.demo.leetcode;

import com.hello.demo.leetcode.domain.TreeNode;

import java.util.*;

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

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (null == root) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (null == root) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null || root.right == null) return leftDepth + rightDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * @param root 二叉树
     * @return
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        if (null == root) return resultList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                integers.add(Objects.requireNonNull(node).val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            resultList.add(0, integers);
        }
        return resultList;
    }

    /**
     * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return binaryJoin(0, nums.length - 1, nums);
    }

    //中序遍历 递归从下往上返回各个节点 组成二叉树
    private TreeNode binaryJoin(int left, int right, int[] nums){
        if (left > right) return null;
        int median = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[median]);
        treeNode.left = binaryJoin(left, median - 1, nums);
        treeNode.right = binaryJoin(median + 1, right, nums);
        return treeNode;
    }

    /**
     *给定一个二叉树，判断它是否是高度平衡的二叉树。
     * @param root [1,2,2,3,null,null,3,4,null,null,4]
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     * @param root 根节点
     * @param sum 目标和
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) return false;
        sum -= root.val;
        //到此叶子节点 检查是否刚好sum为0
        if (root.left == null && root.right == null) return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意: 你可以假设树中没有重复的元素。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0 || preorder.length != inorder.length) return null;
        /*
        preorder第一个元素为root，在inorder里面找到root，在它之前的为左子树（长l1），之后为右子树（长l2）。
         preorder[1]到preorder[l1]为左子树,之后为右子树，分别递归。
         */
        TreeNode treeNode = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                treeNode.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return treeNode;
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
        q.left.left = new TreeNode(3);
        q.right = new TreeNode(4);

        System.out.println("两个二叉树 是否相同： " + isSameTree(p, q));

        System.out.println("是否镜像对称： " + isSymmetric(p));

        System.out.println("二叉树 最大深度：" + maxDepth(q));
        System.out.println("二叉树 最小深度：" + minDepth(q));

        System.out.println("自底向上的层次遍历：" + levelOrderBottom(q));

        System.out.println("是否是高度平衡的二叉树：" + isBalanced(q));

        System.out.println("根节点到叶子节点路径和 是否满足目标值：" + hasPathSum(q, 3));
    }

}
