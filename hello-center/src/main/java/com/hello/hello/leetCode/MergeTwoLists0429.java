package com.hello.hello.leetCode;

import com.hello.hello.leetCode.domain.ListNode;

import java.util.Arrays;

public class MergeTwoLists0429 {

    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1);
        ListNode preNode = listNode;
        while (null != l1 && null != l2){
            if (l1.val <= l2.val){
                preNode.next = l1;
                l1 = l1.next;
            }else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = null == l1 ? l2 : l1;
        return listNode.next;

//        递归比较 拼接，直到最后较短链表结束，返回拼接后的链表
//        if (l2 == null) return l1;
//        if (l1 == null) return l2;
//        if (l1.val <= l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }else {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) return 0;
        int resultNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[resultNum]) {
                resultNum++;
                nums[resultNum] = nums[i];
            }
        }
        return resultNum + 1;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (null == nums || nums.length == 0) return 0;
        int resultNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[resultNum] = nums[i];
                resultNum++;
            }
        }
        return resultNum;
    }

    /**
     * indexOf 方法的实现
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if (needle.isEmpty()) return 0;
        if (!haystack.contains(needle)) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        listNode1.next = new ListNode(2);
//        listNode1.next.next = new ListNode(4);
//
//        ListNode listNode2 = new ListNode(1);
//        listNode2.next = new ListNode(3);
//        listNode2.next.next = new ListNode(4);
//
//        ListNode listNode = mergeTwoLists(listNode1, listNode2);
//        System.out.println("listNode = " + listNode);

        int[] ints = {1, 2, 1};
//        int len = removeDuplicates(ints);
//        System.out.println("len = " + len + " --- " + "ints = " + Arrays.toString(ints));

        int removeElement = removeElement(ints, 2);
        System.out.println("removeElement = " + removeElement + " --- " + "ints = " + Arrays.toString(ints));

        System.out.println("strStr(\"hello\", \"ll\") = " + strStr("h", "lle"));
    }
}
