package com.lxh.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 算法排序： 归并排序
 * 时间复杂度： O(n^2)
 * 归并排序原理 ：
 * 按照递归将数组拆分直至单个元素，然后在当前调用栈中进行合并，
 * 合并方法为对左右两数组进行依次比较放入较小值
 */
public class MergetSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后: " + new Date());
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int arr[]) {
        //归并排序需要一个额外临时空间
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    //分+合
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            //左递归分解
            mergeSort(arr, left, mid, temp);
            //右递归分解
            mergeSort(arr, mid + 1, right, temp);

            //合并
            merge(arr, left, mid, right, temp);

        }
    }

    //合并
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        // 初始化i, 左初始索引
        int i = left;
        //初始化j, 右初始索引
        int j = mid + 1;
        //指向temp数组索引
        int t = 0;

        //依次对比两边数组数据，较小者加入临时数组temp中，较大者不做处理，继续和之后数据对比，直至一边比较结束
        while (i <= mid && j <= right) {//继续
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //对未比较完成数组中剩余数据做处理，依次填入
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //从临时数组中拷贝回原数组： 仅拷贝到当前初始左右索引区间
        t = 0;
        int tempLeft = left; //
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

}
