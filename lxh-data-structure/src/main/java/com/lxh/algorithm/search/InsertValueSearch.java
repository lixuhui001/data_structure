package com.lxh.algorithm.search;

import java.util.Arrays;

/**
 * 插值查找算法
 * 1.二分查找算法基础上衍生（要求数组有序），区别仅在于取对比基数算法，
 * 2.插值查找取索引基数mid算法： 插值算法：int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);）
 * 3.小于midValue则左递归（left->mid-1），大于则右递归(mid+1->right)，直至返回或left>right
 * 4.插值查找算法适合分布较为密集数列
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
        System.out.println("index = " + index);
    }


    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        //校验findValue是否超过边界,防止公式计算索引越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出mid索引基数
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }
}
