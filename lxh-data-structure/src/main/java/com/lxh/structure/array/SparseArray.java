package com.lxh.structure.array;

/**
 * @author: 李旭辉
 * @Date: 2019/8/4 0004 17:46
 * @description： 稀疏数组
 * 二维数组 转 稀疏数组的思路
 * 1. 遍历  原始的二维数组，得到有效数据的个数 sum
 * 2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]
 * 3. 将二维数组的有效数据数据存入到 稀疏数组
 * <p>
 * 稀疏数组转原始的二维数组的思路
 * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
 * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
 */
public class SparseArray {

    /**
     * @Description: 稀疏数组
     * @author 李旭辉
     * @date 2019/8/4 0004 18:14
     */
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11 * 11
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        desployArray(chessArr1);

        int[][] sparseArr = coverToSparseArray(chessArr1);
        System.out.println("得到稀疏数组为~~~~");
        desployArray(sparseArr);

        int[][] ordinaryArray = coverToOrdinaryArray(sparseArr);
        System.out.println("恢复后的二维数组~~~~");
        desployArray(ordinaryArray);


    }

    public static int[][] coverToOrdinaryArray(int[][] sparseArr) {
        //将稀疏数组 --》 恢复成 原始的二维数组
        /*
         *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
         *  2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         */
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return chessArr2;
    }

    public static int[][] coverToSparseArray(int[][] chessArr1) {
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;

        for (int i = 0; i < chessArr1.length; i++) {
            int[] row = chessArr1[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            int[] row = chessArr1[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = row[j];
                }
            }
        }
        return sparseArr;
    }


    public static void desployArray(int[][] array) {
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();

    }
}
