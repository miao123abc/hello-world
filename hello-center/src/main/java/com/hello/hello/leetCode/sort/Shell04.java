package com.hello.hello.leetCode.sort;

import java.util.Arrays;

/**
 * 希尔排序：缩小增量排序，
 */
public class Shell04 implements IArraySort {

    /**
     *  1.希尔排序 给定一个增量gap区间，按增量序列个数 k，对序列进行 k 趟排序；
     *
     *  2.插入排序对于大规模的乱序数组的时候效率是比较慢的，因为它每次只能将数据移动一位，
     *      希尔排序为了加快插入的速度，让数据移动的时候可以实现跳跃移动，节省了一部分的时间开支。
     *
     * 3.当区间为 1 的时候，它使用的排序方式就是插入排序
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] copy = Arrays.copyOf(sourceArray, sourceArray.length);
        int gap = copy.length;
        while (gap > 0){
            //计算增量空间
            gap /= 2;
            for (int i = gap; i < copy.length; i++) {
                int curValue = copy[i];
                int j = i - gap;
                while (j >= 0 && copy[j] > curValue){
                    copy[j + gap] = copy[j];
                    j -= gap;
                }
                copy[j + gap] = curValue;
            }
        }
        return copy;
    }
}
