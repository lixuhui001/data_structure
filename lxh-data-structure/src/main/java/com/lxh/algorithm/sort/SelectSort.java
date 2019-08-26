package com.lxh.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 算法排序： 选择排序
 * 时间复杂度： O(n^2)
 * 选择排序原理 ：
 * 设置最小数游标 minIndex
 * 从首位开始选择，假设为最小，将其游标赋值到最小数游标 minIndex，与minIndex之后的数依次开始比较，如小于则替换赋值到minIndex（保持minIndex在当次循环对应最小数），最终交换首位与minIndex对应值（保持最小值在最前）
 * 注：  每次参与循环均忽略上一轮参与循环的最首位（最小数），假设循环次数为i 则第I次开始被选择的下标为i，参与循环比较的数据为i+1到length-1。
 */

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后: " + new Date());
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) { // 说明假定的最小值，并不是最小
                    minIndex = j; // 重置minIndex
                }
            }
            // 与参与比较的首位进行交换（如等于首位索引则略过）
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
