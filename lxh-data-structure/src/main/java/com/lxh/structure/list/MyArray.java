package com.lxh.structure.list;

import java.util.Random;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/16/016 09:30
 * @Description:
 */
public class MyArray {

    private final static int DEFAULT_SIZE = 50;

    /**
     * 数组
     */
    private int[] arr;

    /**
     * 数组中有效数据的大小
     */
    private int elem;

    /**
     * 默认构造函数
     * 定义一个长度为50的数组
     */
    public MyArray() {
        arr = new int[DEFAULT_SIZE];
    }

    /**
     * 有参构造函数
     * 定义自定义长度数组
     */
    public MyArray(int max) {
        arr = new int[max];
    }

    /**
     * 有效数据计算，预留扩容数族
     */
    private void expansionElem() {
        this.elem++;
    }

    /**
     * 插入数据
     * 有效数+1
     */
    public void insert(int value) {
        arr[elem] = value;
        elem++;
    }

    /**
     * 有序插入数据
     * 每次插入都进行排序
     * 大于该数的依次后移
     */
    public void orderInsert(int value) {
        int i;
        for (i = 0; i < elem; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        elem++;
        for (int j = elem; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
    }

    public void delete(long deleteKey) {

        int index;
        if ((index = find(deleteKey)) == -1) {
            System.out.println("数据不存在");
        } else {
            for (int i = index; i < elem; i++) {
                //前移一位
                arr[i] = arr[i + 1];
            }
            elem--;
        }
    }

    /**
     * 显示数据
     */
    public void display() {
        for (int i = 0; i < elem; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 普通查找
     */
    public int find(long searchKey) {
        int i;
        for (i = 0; i < elem; i++) {
            if (arr[i] == searchKey) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法查找
     * 如数组有序,则可使用二分法查找
     */
    public int binaryFind(int searchKey) {
        int ins = 0;
        int low = 0;
        int pow = elem;

        while (true) {
            ins = (low + pow) / 2;
            if (arr[ins] == searchKey) {
                return ins;
            } else if (low > pow) {
                return -1;
            } else {
                if (arr[ins] > searchKey) {
                    pow = ins - 1;
                } else {
                    low = ins + 1;
                }
            }
        }


    }


    /**
     * 冒泡排序：
     * 从第一个开始每两个互相比较，将小的在前，大的在后，每一次循环结束最大的都会转移到最后。每次循环均忽略上次参与循环的最后一个（最大值）
     * 设循环次数为i，则第i次参与循环的为第0到length-i个数
     * <p>
     * 优化算法： 判断是否存在提前结束排序循环：
     * 当内层循环未发票数据交换则表示顺序已经是从小到大，可以提交结束
     */
    public void bubbleSort() {
        int tmp = 0;
        int flag = 1;
        for (int i = 0; i < elem - 1; i++) {
            flag = 0;
            for (int j = 0; j < elem - i - 1 && flag == 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = 1;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        display();

    }


    /**
     * 插入排序：
     * 从游标为1的数据开始选中，并记录该数，依次和前一位比较，如大于被选择数，则后移一位（被选择数位置已空开），如小于则将选中数放于当前循环位
     */
    public void insertSort() {
        int select = 0;
        for (int i = 1; i < elem; i++) {
            select = arr[i];
            int j = 0;
            for (j = i; j > 0 && arr[j - 1] >= select; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = select;
        }
        display();
    }

    /**
     * 选择排序：
     * 从第一个参与数开始选择，假设为最小数，记录该游标，与之后的数依次开始比较，小于选择数则替换该选中游标为当前游标（保持记录下的游标对应最小数），最终替换参与比循环比较的首位与游标对应数据，保证最小数在最首位
     * 每次循环均忽略上一轮参与循环的最首位（最小数）
     * 假设循环次数为i 则第I次开始被选择的下标为i，参与循环比较的数据为i+1到length。
     */
    public void selectSort() {
        int min = 0;
        int tmp = 0;
        for (int i = 0; i < elem - 1; i++) {
            min = i;
            for (int j = i + 1; j < elem; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        display();

    }

    public void rundomInsert(int length) {
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            insert(random.nextInt(1000));
        }

    }

    public void rundomorderInsert(int length) {
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            orderInsert(random.nextInt(1000));
        }

    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        myArray.rundomInsert(10);
        myArray.display();
        myArray.bubbleSort();
        myArray.insertSort();
        myArray.selectSort();
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        MyArray orderArray = new MyArray();
        orderArray.rundomorderInsert(10);
        orderArray.display();
        System.out.println(orderArray.binaryFind(696));
    }

}
