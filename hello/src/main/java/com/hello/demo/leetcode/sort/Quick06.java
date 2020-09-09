package com.hello.demo.leetcode.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Quick06 implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) {
        int[] copy = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(copy, 0, copy.length - 1);
    }


    /**
     * 快速排序方法
     */
    private int[] quickSort(int[] array, int start, int end) {
        if (start < 0 || end >= array.length || start > end) return null;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
        return array;
    }

    /**
     * 快速排序算法——partition
     */
    private int partition(int[] array, int start, int end) {
        //取随机一个作为基准
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        //将基准值交换到最后
        this.swap2(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex) this.swap2(array, i, smallIndex);
            }
        return smallIndex;
    }


}
