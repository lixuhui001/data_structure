package com.lxh.algorithm.sort;


import java.util.Arrays;
import java.util.Date;

import static com.lxh.algorithm.sort.SortUtil.checkout;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后: " + new Date() + "," + SortUtil.checkSort(arr));
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /*分割策略：假设数组被排序的范围为left和right，center=（left+right）/
    2，对a[left]、a[right]和a[center]进行适当排序，取中值为中轴，将最小者放a[left]，
    最大者放在a[right]，把中轴元与a[right-1]交换，并在分割阶段将i和j初始化为left+1和right-2。然后使用双向描述法，进行快排。*/
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] a = new int[]{array[left], array[left + 1], array[right]};
        //先冒泡排序3个值 作为基数
        BubbleSort.bubbleSort(a);
        array[left] = a[0];
        array[left + 1] = a[1];
        array[right] = a[2];
        int i = left + 1;
        int j = right;

        int base = array[i];
        while (i < j) {
            while (array[j] > base && j > i) {
                j--;
            }
            if (i < j) {
                array[i++] = array[j];
            }
            while (array[i] < base && i < j) {
                i++;
            }
            if (i < j) {
                array[j--] = array[i];
            }
        }
        array[i] = base;
        checkout(array, left, right, i);
        if (i - left > 0) {
            quickSort(array, left, i - 1);
        }
        if (right - i > 0) {
            quickSort(array, i + 1, right);
        }
    }

}
