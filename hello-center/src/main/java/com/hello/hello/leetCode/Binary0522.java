package com.hello.hello.leetCode;

public class Binary0522 {

    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */
    public int hanmingWeight(int n){
        //位操作
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;

        //循环与位移动
//        int sum = 0;
//        int mask = 1;
//        for (int i = 0; i < 32; i++) {
//            if ((n & mask) != 0) sum++;
//            mask <<= 1;
//        }
//        return sum;
    }
}
