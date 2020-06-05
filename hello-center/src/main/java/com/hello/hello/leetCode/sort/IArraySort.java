package com.hello.hello.leetCode.sort;

//@Service
public interface IArraySort {

    int[] sort(int[] sourceArray);

    /**
     *      static
     *
     * 数组两元素交换（接口中静态方法）
     * 调用方式：IArraySort.swap1()  --> 接口名.静态方法名()
     */
    static void swap1(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *      default
     *
     * 数组两元素交换（接口中默认方法）
     * 调用方式：
     *  1.在实现类类体中调用: this.swap2() --> 通过this.父接口默认方法名调用
     *  2.在其他类中 通过子类对象 调用
     */
    default void swap2(int[] arr, int i, int j) {
        if (i == j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
