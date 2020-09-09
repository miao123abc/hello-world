package com.hello.demo.leetcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble01 implements IArraySort{
    @Override
    public int[] sort(int[] sourceArray) {
        int[] copyArray = Arrays.copyOf(sourceArray, sourceArray.length);
        int count = 0;
        for (int i = 0; i < copyArray.length; i++) {
            boolean stop = true;
            for (int j = 0; j < copyArray.length - i - 1; j++) {
                if (copyArray[j] > copyArray[j + 1]){
                    IArraySort.swap1(copyArray, j, j + 1);
                    stop = false;
                }
                count++;
            }
            if (stop) break;
        }
//        System.out.println("冒泡排序次数count = " + count);
        return copyArray;
    }
}
