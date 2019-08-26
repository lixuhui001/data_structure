package com.lxh.algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法查找
 * 1.前提： 数组有序
 * 2.查询单条： 取中间值索引mid指向值进行对比，大于则向右递归（边界： mid-1->(right=length-1)），小于则向左递归（边界：(0=left)->mid-1），等于则返回（正序）
 * 3.查询多条： 同单条查询逻辑，当查询到该数据时，向左右边界进行查找是否也存在查找值
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println("resIndexList=" + resIndexList);
    }

    /**
     * @Description: 单条二分查找法
     * @author 李旭辉
     * @date 2019/8/27 0027 0:20
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {


        // 当 left > right 时，递归结束
        if (left > right) {
            return -1;
        }
        //取中值
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

    /**
     * @Description: 二分法查找多条值
     * @author 李旭辉
     * @date 2019/8/27 0027 0:22
     */

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//退出
                    break;
                }
                resIndexlist.add(temp);
                temp -= 1;
            }
            resIndexlist.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {//退出
                    break;
                }
                resIndexlist.add(temp);
                temp += 1;
            }
            return resIndexlist;
        }
    }
}
