package com.hello.hello.leetCode.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insert03 implements IArraySort {

    /**
     * 1.将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     *
     * 2.从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] copy = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < copy.length; i++) {
            //待插入元素 curValue
            int curValue = copy[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (curValue < copy[j]) copy[j+1] = copy[j]; //大于 curValue 的元素整体后移
                else break;
            }
            copy[j+1] = curValue; //插入元素
        }
        return copy;
    }
}
