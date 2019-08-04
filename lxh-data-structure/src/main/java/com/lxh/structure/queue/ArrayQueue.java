package com.lxh.structure.queue;

import java.util.Queue;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/16/016 17:20
 * @Description:
 */
public class ArrayQueue {
    // 数组
    private char[] arr;

    // 最大空间
    private int maxSize;

    // 有效元素大小
    private int elems;

    // 队头
    private int front;

    // 队尾
    private int end;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new char[maxSize];
        elems = 0;
        front = -1;
        end = -1;
    }

    // 插入数据
    public void insert(char value) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        elems++;
        arr[++end] = value;
    }

    // 获取队列的数据, 出队列
    public char remove() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        elems--;
        // front后移
        return arr[++front];
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }

    // 是否为空
    public boolean isEmpty() {
        return (front == end);
    }

    // 是否满了
    public boolean isFull() {
        return (end == maxSize - 1);
    }

    // 返回有效元素大小
    public int size() {
        return elems;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue mq = new ArrayQueue(5);
        System.out.println(mq.isEmpty());
        mq.insert('1');
        mq.insert('2');
        mq.insert('3');
        mq.insert('4');
        mq.insert('5');
        mq.insert('6');
        mq.insert('7');

        mq.remove();
        mq.remove();
        mq.remove();
        mq.remove();
        mq.remove();
        System.out.println( "队列中包含元素："+mq.elems);;
        while (!mq.isEmpty()) {
            char tmp = mq.remove();
            System.out.println(tmp);
        }

    }
}

