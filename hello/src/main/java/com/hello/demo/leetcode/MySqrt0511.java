package com.hello.demo.leetcode;

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
    public int mySqrt(int x) {
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

}
