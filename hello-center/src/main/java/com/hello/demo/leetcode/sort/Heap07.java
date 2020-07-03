package com.hello.demo.leetcode.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class Heap07 implements IArraySort {

   @Override
   public int[] sort(int[] sourceArray) {
       // 对 arr 进行拷贝，不改变参数内容
       int[] copy = Arrays.copyOf(sourceArray, sourceArray.length);

       int len = copy.length;

        buildMaxHeap(copy, len);

        for (int i = len - 1; i > 0; i--) {
            this.swap2(copy, 0, i);
            len--;
            heapify(copy, 0, len);
        }
        return copy;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            this.swap2(arr, i, largest);
            heapify(arr, largest, len);
        }
    }
}
