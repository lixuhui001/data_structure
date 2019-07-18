package com.lxh.queue;

/**
 * @Auther: LiXuHui
 * @Date: 2019/7/16/016 17:20
 * @Description:
 */
public class MyQueue
{
    // 数组
    private char[] arr;

    // 最大空间
    private int maxSize;

    // 有效元素大小
    private int elems;

    // 队头
    private int font;

    // 队尾
    private int end;

    public MyQueue(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new char[maxSize];
        elems = 0;
        font = 0;
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

    // 移除数据
    public char remove()
    {
        char tmp = arr[font++];

        if (font == maxSize)
        {
            font = 0;
        }
        elems--;
        System.out.println(elems+"---");
        return tmp;
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

    public static void main(String[] args)
    {
        MyQueue mq = new MyQueue(5);
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

