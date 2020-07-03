package com.hello.demo.leetcode.sort;

import java.util.Arrays;

/**
 * 归并排序（分治法）
 */
public class Merge05 implements IArraySort {

    /**
     * 步骤1：把长度为n的输入序列分成两个长度为n/2的子序列；
     * 步骤2：对这两个子序列分别采用归并排序；
     * 步骤3：将两个排序好的子序列合并成一个最终的排序序列。
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] copy = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = copy.length;
        if (length < 2) return copy;
        int middle = length / 2;
        int[] left = Arrays.copyOfRange(copy, 0, middle);
        int[] right = Arrays.copyOfRange(copy, middle, length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        //合并结果数组
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length){
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = left[i++];
            }else if (left[i] < right[j]){
                result[index] = left[i++];
            }else {
                result[index] = right[j++];
            }
        }
        return result;
    }


}