package com.lxh.algorithm.sort;


import java.util.Arrays;
import java.util.Date;

import static com.lxh.algorithm.sort.SortUtil.checkout;

/**
 * 算法排序： 快速排序
 * 时间复杂度： O(n^2)
 * 快速排序原理 ：
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 * 选定一个元素为基数，并记录该元素，标记为空置位
 * 对进行双向描述，先右后左，与基数进行比较，如不符合左小右大原则，则将被比较元素放入已空出位置，被比较元素原位置成为新生空置位
 * 最终将基数放入最后空置位，此时，基数位置左小右大
 *
 * 再对其左右数组分别递归如上循环，直至递归中参数仅剩单元素截止
 *
 * <p>
 * 优化算法： 可先对其中任意三个元素进行排序，增大基数选择的公平性可行性
 */
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
