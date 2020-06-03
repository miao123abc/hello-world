package com.hello.hello.leetCode.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Selection02 implements IArraySort {

    /**
     * 首先，找到数组中最小的元素，拎出来，将它和数组的第一个元素交换位置，
     * 第二步，在剩下的元素中继续寻找最小的元素，拎出来，和数组的第二个元素交换位置，
     * 如此循环，直到整个数组排序完成。
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] copy = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < copy.length - 1; i++) {
            //剩余最小值所在的索引
            int curMinIndex = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[curMinIndex])
                    curMinIndex = j;
            }
            //交换
            int temp = copy[i];
            copy[i] = copy[curMinIndex];
            copy[curMinIndex] = temp;
        }
        return copy;
    }
}
