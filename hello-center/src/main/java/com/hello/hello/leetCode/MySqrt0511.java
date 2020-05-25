package com.hello.hello.leetCode;

import com.hello.hello.leetCode.domain.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MySqrt0511 {

    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
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
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *
     * 示例：
     * 输入：10
     * 输出：true
     * 解释：
     * 1的平方 + 0的平方 = 1
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private Integer getNext(int n){
        int sum = 0;
        while (n > 0){
            int i = n % 10;
            n /= 10;
            sum += i * i;
        }
        return sum;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     *
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
     *
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

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * @param nums1 原数组
     * @param m     原数组长度
     * @param nums2 合并数组
     * @param n     合并数组长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //反着比较 由于原数组长度足够 比较后直接将大值放入合并后数组中
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 || j>=0) {
            //注意两个边界条件，i<0以及j<0，这表示一个数组已经拷贝完了
            if (i < 0){
                nums1[k--] = nums2[j--];
            }else if (j < 0){
                nums1[k--] = nums1[i--];
            }else if (nums1[i] <= nums2[j]){
                nums1[k--] = nums2[j--];
            }else {
                nums1[k--] = nums1[i--];
            }
        }

        //数组合并，然后排序
//        System.arraycopy(nums2, 0, nums1, m, n);
//        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(16));

        System.out.println(climbStairs(5));

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        System.out.println(deleteDuplicates(listNode));

        int[] ints = {2, 5, 6, 0, 0, 0};
        merge(ints, 3, new int[]{1, 2, 3}, 3);
        System.out.println("ints = " + Arrays.toString(ints));
    }
}
