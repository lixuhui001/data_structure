package com.lxh.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 算法排序： 基数排序
 * 时间复杂度： O(n^2)
 * 基数排序原理 ：
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较，基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序
 * 类似于桶排序，对每个数自低位到高位开始，分别放入0-9桶中，再将其按照桶顺序依次取回
 * 最终实现为： 先将低位数相同的归并到一起，最终秩序再通过高位比较来区分大小
 * 如：
 * 13  14  23  24  33  34
 * 分桶为 3： 13 23  33 4： 14 24 34
 * 取回为 13 23 33  14  24  34
 * 再分桶： 1： 13 14 2： 23 24 3： 33 34
 * 取回： 13 14 23 24 33 34
 */
public class RadixSort {


    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println("排序后: " + new Date());
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //1. 获得数组中最大的数的位数，决定定义桶个数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();


        //定义位数桶0-9 防止数据过于聚集溢出，定义桶数组length=array.length
        int[][] bucket = new int[10][arr.length];
        //定义桶存储记录数组，记录当前桶存贮值数目
        int[] bucketElementCounts = new int[10];


        //依次处理直至最高位
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出元素的对应位数值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应桶中，并对当前桶数目++
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[j];
            }
            //按照桶顺序依次取出数据，放入数组
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //判断当前桶中数据是否存在，取出元素
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //每次循环取出后需将桶元素数目记录-清空
                bucketElementCounts[k] = 0;

            }
        }
    }
}
