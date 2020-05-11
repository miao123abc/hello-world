package com.hello.hello.leetCode;

import com.hello.hello.leetCode.domain.ListNode;

public class MySqrt0511 {

    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * @param x
     * @return
     */
    public static int mySqrt(int x){
        //Math自带平方根方法 return (int) Math.sqrt(x);

        //2.二分查找
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        // 为了照顾到 0 把左边界设置为 0
        long left = 0;
        // # 为了照顾到 1 把右边界设置为 x // 2 + 1
        long right = x / 2 + 1;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            long mid = (left + right + 1) >>> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid; //由于取得是 右中位数 这里所以是直接赋值
            }
        }
        return (int) left;

        //3.牛顿法
//        long res = x;
//        while (res * res > x) {
//            res = (res + x / res) / 2;
//        }
//        return (int) res;
    }

    /**
     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

     注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int thrid = first + second;
            first = second;
            second = thrid;
        }
        return second;
    }

    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            if (curNode.val != curNode.next.val) curNode = curNode.next;
            else curNode.next = curNode.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        System.out.println(mySqrt(16));

//        System.out.println(climbStairs(5));

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        System.out.println(deleteDuplicates(listNode));
    }
}
