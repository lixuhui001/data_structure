package com.lxh.structure.queue;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/16/016 17:20
 * @Description:
 */
public class ArrayQueue01
{
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

    public ArrayQueue01(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new char[maxSize];
        elems = 0;
        front = -1;
        end = -1;
    }

    // 插入数据
    public void insert(char value)
    {
        if (end == maxSize - 1)
        {
            end = -1;
        }
        arr[++end] = value;
        elems++;
    }

    // 获取队列的数据, 出队列
    public char remove()
    {
        char tmp = arr[++front];

        if (front == maxSize)
        {
            front = -1;
        }
        elems--;
        System.out.println(elems+"---");
        return tmp;
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
    public boolean isEmpty()
    {
        return (elems == 0);
    }

    // 是否满了
    public boolean isFull()
    {
        return (elems == maxSize);
    }

    // 返回有效元素大小
    public int size()
    {
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

    public static void main(String[] args)
    {
        ArrayQueue01 mq = new ArrayQueue01(5);
        System.out.println(mq.isEmpty());
        mq.insert('1');
        mq.insert('2');
        mq.insert('3');
        mq.insert('4');
        mq.insert('5');
        mq.insert('6');
        mq.insert('7');

        while (!mq.isEmpty())
        {
            char tmp = mq.remove();
            System.out.println(tmp);
        }

    }
}

