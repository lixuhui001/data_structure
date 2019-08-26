package com.lxh.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 算法排序： 插入排序
 * 时间复杂度： O(n^2)
 * 插入排序原理 ：
 * 从游标为1的数据开始选中，并记录该数，
 * 依次向前比较，如大于被选择数，则被比较数后移一位（被选择数位置已记录空开），如小于则将选中数放于当前循环位，
 * 比较结束后则被选中数游标+1重新进行上述循环
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后: " + new Date());
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            //定义被比较数起始索引
            insertIndex = i - 1;
            // 大于被选择数，则被比较数后移一位，并继续向前比对，直至越界，反之则跳出循环，在被比较数之后（insertIndex + 1）插入比较数，当次插入循环结束
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

}
