package com.hello.hello;

import com.hello.hello.leetCode.Array0521;
import com.hello.hello.leetCode.Rule0519;
import com.hello.hello.leetCode.String0520;
import com.hello.hello.leetCode.Tree0512;
import com.hello.hello.leetCode.sort.IArraySort;
import com.hello.hello.leetCode.sort.MergeSort;
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
        IArraySort mergeSort = new MergeSort();
        int[] sourseArray = {1,5,6,3,2,7};
        int[] sortArray = mergeSort.sort(sourseArray);
        System.out.println("sortArray = " + Arrays.toString(sortArray));
    }

    @Test
    public void testTree(){
        Tree0512 tree0512 = new Tree0512();
        int[] ints = {-10,-3,0,5,9};
        System.out.println("有序数组 -> 高度平衡二叉搜索树：" + tree0512.sortedArrayToBST(ints));
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

        System.out.println("数组中多数元素：" + rule0519.majorityElement(new int[]{2, 3, 2}));
        System.out.println("阶乘结果尾数中零的数量：" + rule0519.trailingZeroes(13));
    }

    @Test
    public void testString(){
        String0520 string0520 = new String0520();
        System.out.println("是否是回文串：" + string0520.isPalindrome("A man, a plan, a canal: Panama"));

        System.out.println("单独数字：" + string0520.singleNumber(new int[]{1, 2, 1}));
    }

    @Test
    public void testArray(){
        Array0521 array0521 = new Array0521();

        int[] ints = {1, 2, 3};
        array0521.rotate(ints, 4);
        System.out.println("数组向右移动后：" + Arrays.toString(ints));
    }

}
