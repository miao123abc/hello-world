package com.hello.hello.leetCode;

import com.hello.hello.leetCode.domain.ListNode;

import java.util.HashSet;
import java.util.Set;

public class StructureListNode {

    /**
     * 给定一个链表，判断链表中是否有环。
     *
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        //Set容器存取
        Set<Object> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)) {
                return true;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return false;

        //双指针
//        if (head == null || head.next == null) return false;
//        ListNode slow = head;
//        ListNode fast = head.next.next;
//        while (fast != null && fast.next != null){
//            if (slow == fast) return true;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return false;
    }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //双指针
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;

        //容器存取
//        Set<Object> set = new HashSet<>();
//        while (headA != null){
//            set.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null){
//            if (set.contains(headB)) return headB;
//            headB = headB.next;
//        }

        //双循环查找
//        while (headA != null){
//            ListNode temp = headB;
//            while (temp != null){
//                if (headA == temp) return headA;
//                temp = temp.next;
//            }
//            headA = headA.next;
//        }
//        return null;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = head, prev = res;
        while (temp != null){
            if (temp.val == val) prev.next = temp.next;
            else prev = temp;
            temp = temp.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
//        listNode2.next = listNode1;
        System.out.println("链表是否有环：" + hasCycle(listNode1));

        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(3);
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        headA.next = listNode;
        headB.next = listNode;
        System.out.println("两个单链表相交的起始节点：" + getIntersectionNode(headA, headB));

        listNode2.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        System.out.println("删除给定值后：" + removeElements(listNode1, 3));
    }
}
