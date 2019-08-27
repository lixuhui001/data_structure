package com.lxh.algorithm.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * 算法排序： 希尔排序
 * 时间复杂度：
 * 希尔排序原理 ：
 * 对数组每次按照length/2 步长进行增量间隔分组，并依次比较组内元素，组内比较采用冒泡法或者插入排序法
 * 缩短步长/2 ，减少分组，重新进行组内比较，
 * 循环直至步长=1，分组元素数等于length-1
 * <p>
 * 有效的避免了最差情况（最小位在最后）需要多次移动的问题
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.getIntGroup(100);
        System.out.println("排序前: " + new Date());
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后: " + new Date());
        System.out.println(Arrays.toString(arr));
    }

//

    //交换法
    public static void shellSort(int[] arr) {

        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }


    }

    //位移法
    public static void shellSort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }

}
