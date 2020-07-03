package com.hello.demo;

import com.hello.demo.leetcode.*;
import com.hello.demo.leetcode.domain.ListNode;
import com.hello.demo.leetcode.domain.TreeNode;
import com.hello.demo.leetcode.sort.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class HelloCenterApplicationTests {

//    @Autowired
//    private IArraySort iArraySort;

    @Test
    public void contextLoads() {
        int[] sourceArray = {8, 2, 5, 9, 7};
        //冒泡
        IArraySort bubbleSort = new Bubble01();
        int[] sort1 = bubbleSort.sort(sourceArray);

        //选择
        IArraySort selectionSort = new Selection02();
        int[] sort2 = selectionSort.sort(sourceArray);

        //插入
        IArraySort insert03 = new Insert03();
        int[] sort3 = insert03.sort(sourceArray);

        //希尔
        IArraySort shell04 = new Shell04();
        int[] sort4 = shell04.sort(sourceArray);

        //归并
        IArraySort merge05 = new Merge05();
        int[] sort5 = merge05.sort(sourceArray);

        //快排
        IArraySort quick06 = new Quick06();
        int[] sort6 = quick06.sort(sourceArray);

        System.out.println("排序后 sort = " + Arrays.toString(sort6));
    }

    @Test
    public void testArray(){
        Array0521 array0521 = new Array0521();

        int[] ints = array0521.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println("ints = " + Arrays.toString(ints));

        int searchInsert = array0521.searchInsert(new int[]{1, 3, 5, 6}, 8);
        System.out.println("searchInsert = " + searchInsert);

        int[] ints2 = {1, 2, 3};
        array0521.rotate(ints2, 4);
        System.out.println("数组向右移动后：" + Arrays.toString(ints));

        int maxSubArray = array0521.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("maxSubArray = " + maxSubArray);

        System.out.println("能够偷窃到的最高金额: " + array0521.rob(new int[]{2,1,1,2}));

        int[] ints3 = {1, 2, 1};
        int len = array0521.removeDuplicates(ints3);
        System.out.println("len = " + len + " --- " + "ints3 = " + Arrays.toString(ints3));

        int removeElement = array0521.removeElement(ints3, 2);
        System.out.println("removeElement = " + removeElement + " --- " + "ints3 = " + Arrays.toString(ints3));

        int[] ints4 = {2, 5, 6, 0, 0, 0};
        array0521.merge(ints4, 3, new int[]{1, 2, 3}, 3);
        System.out.println("ints4 = " + Arrays.toString(ints4));
    }

    @Test
    public void testBinary(){
        Binary0522 binary0522 = new Binary0522();

        System.out.println("汉明重量：" + binary0522.hanmingWeight(11));
    }

    @Test
    public void testSqrt(){
        MySqrt0511 mySqrt0511 = new MySqrt0511();

        System.out.println(mySqrt0511.mySqrt(16));

        System.out.println("是否为快乐数：" + mySqrt0511.isHappy(19));
    }

    @Test
    public void testRule(){
        Rule0519 rule0519 = new Rule0519();
        List<List<Integer>> generate = rule0519.generate(3);
        System.out.println("杨辉三角前n行 = " + generate);

        System.out.println("杨辉三角当前行：" + rule0519.getRow(2));

        System.out.println("单次购买最大利润：" + rule0519.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println("多次购买最大利润：" + rule0519.maxProfit2(new int[]{7,1,5,3,6,4}));

        System.out.println("正整数对应Excel 表中相对应的列名称：" + rule0519.convertToTitle(53));
        System.out.println("列名称对应Excel 表中相对应的正整数：" + rule0519.titleToNumber("BA"));

        int romanToInt = rule0519.romanToInt("MCMXCIV");
        System.out.println("romanToInt = " + romanToInt);

        System.out.println("数组中多数元素：" + rule0519.majorityElement(new int[]{2, 3, 2}));
        System.out.println("阶乘结果尾数中零的数量：" + rule0519.trailingZeroes(13));

        int reverse = rule0519.reverse(994748399);
        System.out.println("reverse = " + reverse);

        boolean palindrome = rule0519.isPalindrome(1221);
        System.out.println("palindrome = " + palindrome);

        int[] plusOne = rule0519.plusOne(new int[]{9});
        System.out.println("plusOne = " + Arrays.toString(plusOne));

        System.out.println(rule0519.climbStairs(5));
    }

    @Test
    public void testString(){
        String0520 string0520 = new String0520();
        System.out.println("是否是回文串：" + string0520.isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println("单独数字：" + string0520.singleNumber(new int[]{1, 2, 1}));

        System.out.println("被添加的字母：" + string0520.findTheDifference("abc", "acbt"));

        System.out.println("两个字符串是否同构：" + string0520.isIsomorphic("ab", "aa"));

        String s = string0520.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println("s = " + s);

        boolean valid = string0520.isValid("}){}");
        System.out.println("valid = " + valid);

        System.out.println("indexOf 方法 = " + string0520.strStr("h", "lle"));
        System.out.println("第一个不重复的字符：" + string0520.firstUniqChar("agaeg"));
        System.out.println("是否可用后边字符串构成：" + string0520.canConstruct("aab", "baa"));

        int helloWorld = string0520.lengthOfLastWord("aaaa xcv ");
        System.out.println("helloWorld = " + helloWorld);

        String addBinary = string0520.addBinary("11", "11");
        System.out.println("addBinary = " + addBinary);
    }

    @Test
    public void testListNode(){
        StructureListNode structureListNode = new StructureListNode();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        head.next.next = node3;
//        head.next.next.next = node4;
        System.out.println("翻转后链表为：" + structureListNode.reverse(head));
    }

    @Test
    public void testTree(){
        Tree0512 tree0512 = new Tree0512();

        int[] ints = {-10,-3,0,5,9};
        System.out.println("有序数组 -> 高度平衡二叉搜索树：" + tree0512.sortedArrayToBST(ints));

        TreeNode treeNode = tree0512.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println("由前序和中序构建的 treeNode = " + treeNode);
    }

}
