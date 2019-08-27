package com.lxh.algorithm.sort;

import java.util.Arrays;
import java.util.Date;


/**
 * 算法排序： 冒泡排序
 * 时间复杂度： O(n^2)
 * 冒泡排序原理 ：
 * 从第一个开始每两个互相比较，将小的在前，大的在后，每一次循环结束最大的都会转移到最后。每次循环均忽略上次参与循环的最后一个（最大值）
 * 设循环次数为i，则第i次参与循环的为第0到length-i个数
 * <p>
 * 优化算法： 判断是否存在提前结束排序循环：
 * 当内层循环未发票数据交换则表示顺序已经是从小到大，可以提交结束
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后: " + new Date());
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp; // 临时交换变量
        boolean flag; // 交换标志
        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 前>后，则交换(正序)
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                // 当次未产生交换，则数组已有序
                break;
            }
        }
    }

}
