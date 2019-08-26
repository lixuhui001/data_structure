package com.lxh.algorithm.sort;

/**
 * @author: 李旭辉
 * @Date: 2019/8/27 0027 0:50
 * @description：
 */
public class SortUtil {
    public static int[] getIntGroup(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * length); //生成一个[0, length) 数
        }
        return arr;
    }

    public static boolean checkSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkout(int[] arr, int left, int right, int temp) {
        for (int i = left; i < temp; i++) {

            if (arr[i] > arr[temp]) {
                return false;
            }

        }
        for (int i = temp; i < right; i++) {

            if (arr[i] < arr[temp]) {
                return false;
            }

        }
        return true;
    }
}
